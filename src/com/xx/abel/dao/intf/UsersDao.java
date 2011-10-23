package com.xx.abel.dao.intf;

import com.xx.abel.bean.Users;


@SuppressWarnings("unchecked")
public interface UsersDao extends BaseDAO{
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public Users Login(String username,String password);

}
