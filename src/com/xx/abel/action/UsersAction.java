package com.xx.abel.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.xx.abel.bean.Users;
import com.xx.abel.service.intf.UsersService;
import com.xx.abel.util.MD5;
import com.xx.abel.util.Tools;

@Controller
@Scope("prototype")
public class UsersAction extends BaseAction {
	private static final int BUFFER_SIZE = 16 * 1024;
	Logger logger = Logger.getLogger(UsersAction.class);

	private static final long serialVersionUID = 1L;

	private String password2;
	@Autowired
	private UsersService userService;

	private File upload;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * ajax验证 用户名和邮箱是否唯一
	 * 
	 * @param value �?
	 * @param type
	 *            类型 username、email
	 * @throws IOException
	 */
	public void nameOremail() throws Exception {
		String value = ServletActionContext.getRequest().getParameter("value");
		String type = ServletActionContext.getRequest().getParameter("type");
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=UTF-8");
		try {
			if ("email".equals(type)) {
				this.user = userService.getEmail(value);
			} else if ("username".equals(type)) {
				this.user = userService.getUserName(value);
			} else {
				ServletActionContext.getResponse().getWriter().println(2);// 非法操作�?
				return;
			}
			if (user == null) {
				ServletActionContext.getResponse().getWriter().println(1);
			} else {
				ServletActionContext.getResponse().getWriter().println(0);
			}
		} catch (Exception e) {
			logger.error("用户名或邮箱验证错误" + new Date());
			e.printStackTrace();
		}
	}

	/**
	 * 注册用户
	 */
	public String save() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		String piccode = ServletActionContext.getRequest().getParameter("piccode");
		String sessionPiccode = ServletActionContext.getRequest().getSession().getAttribute("piccode")
				+ "";
		if (!"POST".equals(method)) {
			return "register";
		}
		if (piccode == null || !(piccode.equalsIgnoreCase(sessionPiccode))) {
			this.addActionError("你输入的验证码不正确！");
			return "register";
		}
		String checked = ServletActionContext.getRequest().getParameter(
				"checkbox");
		if (this.user == null || (this.user.getId() == null && checked == null)) {
			this.addActionError("你未同意本网站的《免责声明》，暂不能加入！");
			return "register";
		}
		try {
			if (upload != null) {
				String fileName = this.getUploadFileName();
				if (Tools.isEnableUploadType(fileName)) {// 获取文件格式 是否正确
					this.addActionError("上传的图片格式不正确！");
					return "register";
				}
//				int width = 0;
//				int height = 0;
//				try {
//					String un = upload.getPath();
//					Map m = Tools.getPicWidthHeight(un);
//					Object[] len = m.values().toArray();
//					width = Integer.parseInt(len[0] + "");
//					height = Integer.parseInt(len[1] + "");
//				} catch (Exception e) {
//
//				}
//				if (upload.length() > 1048576) {
//					this.addActionError("上传的图片过大最大应为1MB！");
//					return "register";
//				} else if (width > 120 || height > 120) {
//					this.addActionError("上传的图片尺寸大小应为：120*120(px)");
//					return "register";
//				} else {
					try {
						String uuid = UUID.randomUUID().toString().replace("-",
								"").toUpperCase();
						String imgnameString = uuid + Tools.getFileExtName(this
												.getUploadFileName());
						// 根据服务器的文件保存地址和原文件名创建目录文件全路径

						String dstPath = ServletActionContext
								.getServletContext().getRealPath("/Upload/");
						File f = new File(dstPath);
						if(!f.exists()) f.mkdir();
						String xt = dstPath + "/" + imgnameString;
						File dstFile = new File(xt);
						user.setAvatar(imgnameString);
						// File dstFile = new File("D:\\" + imgnameString);
						String tmp = this.upload + "";// 缓存文件
						Tools.copy(this.upload, dstFile, BUFFER_SIZE);
						Tools.deleteDocument(tmp);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("上传文件失败" + new Date());
						this.addActionError("上传文件失败！");
						return "register";
					}
//				}
			}

			user.setStatus(0);
			user.setType(1);
			user.setCreateTime(new Date());
			user.setLastLogin(new Date());
			String password = user.getPassword();
			if (!password.equals(this.getPassword2())) {
				this.addActionError("密码和确认密码输入不一致！");
				return "register";
			}
			user.setPassword(MD5.MD5Encode(user.getPassword()));
			user.setPoints(0);
			boolean bool = userService.save(user);
			if (bool) {	
				user.setPassword(this.getPassword2());
				Users u = userService.Login(user.getName(), user.getPassword());
				if(u == null){
					this.addActionError("系统错误，请联系管理员！");
					return "register";
				}
				String host = ServletActionContext.getRequest().getServerName();
				Cookie ck = new Cookie("abelXX",u.getPassword()+u.getName());
				ck.setPath("/");
				ck.setDomain(host);
				ck.setMaxAge(999999);
				ServletActionContext.getResponse().addCookie(ck);
				ServletActionContext.getRequest().getSession().setAttribute("user", u);
				return "index";
			} else {
				return "register";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("注册错误" + new Date());
		}
		return "register";
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() throws Exception {
		Object obj = ServletActionContext.getRequest().getSession().getAttribute("from");
		ServletActionContext.getRequest().getSession().setAttribute("serverIp", ServletActionContext.getRequest()
				.getLocalAddr());
		try {
			Users u = userService.Login(user.getName(), user.getPassword());
			if (u == null) {
				this.addActionError("用户名和密码不正确！");
			} else if (u.getStatus().equals("1")) {
				this.addActionError("对不起你的号码非法操作，已被封！");
			} else {
				ServletActionContext.getRequest().getSession().setAttribute("user", u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("登录错误" + new Date());
		}
		if(obj==null)
		return "index";
		else{
			ServletActionContext.getRequest().getSession().removeAttribute("from");
			this.setFrom((String)obj);
			return "from";
		}
	}

	public String query() throws Exception {
		Users user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
		Integer type = user.getType();
		if (type == 0) {
			Map<String, String> param = new HashMap<String, String>();
			if (!"".equals(condition)) {
				if (querytype == 1) {
					param.put("userName like", "%" + condition + "%");
				} else if (querytype == 2) {

				}
			}
			pageListData = userService.findList(param, currentPage, 8);
		}

		return "query";
	}

	public String quit() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "quit";
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	private Users user;

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	private String from;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
