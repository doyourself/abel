package com.xx.abel.service.intf;

import java.util.Map;

import com.xx.abel.util.PageListData;
import com.xx.abel.bean.Users;



public interface UsersService {
	/**
	 * 保存用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean save(Users user) throws Exception;
	/**
	 * 根据email username 获取用户
	 * @param email
	 * @return
	 */
	public Users getEmail(String email) throws Exception;
	/**
	 * 根据username 获取用户
	 * @param username
	 * @return
	 */
	public Users getUserName(String username) throws Exception;
	/**
	 * 用户登录
	 * @param username  用户
	 * 
	 * 
	 * @param password 登录密码
	 * @return
	 */
	public Users Login(String username, String password) throws Exception;
	
	public PageListData findList(Map param, int currentPage, int pageSize);
	
	public boolean update(Users user)throws Exception ; 
	
	public Users findById(Integer id );
}
