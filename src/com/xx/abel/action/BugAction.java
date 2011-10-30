package com.xx.abel.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.xx.abel.bean.Bug;
import com.xx.abel.bean.Users;
import com.xx.abel.service.impl.UserServiceImpl;
import com.xx.abel.service.intf.BugService;
import com.xx.abel.service.intf.UsersService;

@Controller
@Scope("prototype")
public class BugAction {
	Logger logger = Logger.getLogger(BugAction.class);
	@Autowired
	private BugService bugService;
	@Autowired
	private UsersService userService;

	private int bugtype;

	public String save() {
		bug.setUsers(UserServiceImpl.getUser());
		bugService.save(bug);
		return "list";
	}

	public String list() {
		if (UserServiceImpl.getUser().getBugType() == null)
			bugtype = 0;
		
		Users user = UserServiceImpl.getUser();
		if (user.getBugType() == 0){
			list = bugService.findAll(null,null);
			return "success";
		}else{
			list = bugService.findAll(0,5);
			return "success2";
		}
	}
	public String ajaxList(){
		list = bugService.findAll(start,end);
		return "ajax";
	}

	public String findById() {
		Integer id = bug.getId();
		if (id != null)
			bug = bugService.findById(id);
		Users user = UserServiceImpl.getUser();
		if (user.getBugType() == 0)
			return "view";
		else
			return "view2";
	}
	public String findUpdate(){
		Integer id = bug.getId();
		if (id != null)
			bug = bugService.findById(id);
			return "update";
	}

	public String updateType() {
		Users user = UserServiceImpl.getUser();
		if (user.getBugType() == 0)
			user.setBugType(1);
		else
			user.setBugType(0);
		try {
			userService.update(user);
			ServletActionContext.getRequest().getSession().setAttribute("user",user);
		} catch (Exception e) {
			logger.error("bug修改状态错误");
		}
		return "list";
	}

	public void delete() {
		bugService.delete(bug);
	}
	public String deleteList(){
		bugService.delete(bug);
		return "list";
	}

	private List<Bug> list;

	private Bug bug;

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public List<Bug> getList() {
		return list;
	}

	public void setList(List<Bug> list) {
		this.list = list;
	}

	public int getBugtype() {
		return bugtype;
	}

	public void setBugtype(int bugtype) {
		this.bugtype = bugtype;
	}
	
	private Integer start;
	
	private Integer end;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
}
