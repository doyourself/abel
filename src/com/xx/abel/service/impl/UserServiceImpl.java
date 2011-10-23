package com.xx.abel.service.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xx.abel.util.Decide;
import com.xx.abel.util.MD5;
import com.xx.abel.util.PageListData;
import com.xx.abel.bean.Users;
import com.xx.abel.dao.intf.UsersDao;
import com.xx.abel.service.intf.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersDao userDao;
	
	@SuppressWarnings("unchecked")
	public boolean save(Users user) throws Exception {
		try {
			userDao.save(user);
			return true;	
		} catch (Exception e) {
			return false;
			
		}
	}

	@SuppressWarnings("unchecked")
	public Users getEmail(String email) {
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		if (m.find()) {
			List<Users> list = userDao.findByProperty(Users.class, "email", email, 1);
			return (list == null || list.size() < 1) ? null : list
					.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Users getUserName(String username) {
		List<Users> list = userDao.findByProperty(Users.class, "name", username, 1);
		return (list == null || list.size() < 1) ? null :list.get(0);
	}

	public Users Login(String username, String password) {
		try {
			Decide.isString(username);
			Decide.isString(password);
			Users users = userDao.Login(username, MD5.MD5Encode(password));
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取用户的信�? 从session中取出来 成功返回�?个用户的对象、失败返回null
	 * 
	 * 
	 * @return
	 */
	public static Users getUser() {
		Object obj = ServletActionContext.getRequest().getSession().getAttribute("user");
		return obj == null ? null : (Users) obj;
	}
	@SuppressWarnings("unchecked")
	public PageListData findList(Map param, int pageNum, int pageSize) {
		String hql = "from User where 1=1 ";
		for (Object o : param.keySet()) {
			hql += " and " + o.toString() + " ? ";
		}
		Object params[] = param.values().toArray();
		return userDao.findList(Users.class, hql, params, pageNum, pageSize);
	}

	@SuppressWarnings("unchecked")
	public boolean update(Users user) {
		try {
			userDao.saveOrUpdate(user);
			return true;	
		} catch (Exception e) {
			return false;
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public Users findById(Integer id ) {
		return (Users) this.userDao.findById(Users.class, id);
	}

	@SuppressWarnings("unchecked")
	public void updatePoints(int points) {
		Users user = UserServiceImpl.getUser();
		if(points != 0){
			int point = user.getPoints()+points;
			user.setPoints(point);
			this.userDao.saveOrUpdate(user);
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}
	}

}
