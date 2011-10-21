package com.xx.abel.dao.intf;

import com.xx.abel.bean.Users;


@SuppressWarnings("unchecked")
public interface UsersDao extends BaseDAO{
	/**
	 * 登录的方�?
	 * @param username
	 * @param password
	 * @return
	 */
	public Users Login(String username,String password);
}
