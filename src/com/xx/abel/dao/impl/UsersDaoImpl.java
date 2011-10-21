package com.xx.abel.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Users;
import com.xx.abel.dao.intf.UsersDao;


@SuppressWarnings("unchecked")
@Repository
public class UsersDaoImpl extends BaseDAOImpl implements UsersDao{

	@SuppressWarnings("unchecked")
	public Users Login(String username, String password) {
		String hql="from Users u where u.name=? and u.password=?";
		if(username.indexOf("@") != -1)
			hql="from Users u where u.email=? and u.password=?";
		List list = getListAll(hql, username,password);
		return (list == null || list.size() != 1) ? null : (Users)list.get(0);
	}

}
