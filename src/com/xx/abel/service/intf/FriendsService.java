package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Friends;

public interface FriendsService {
	
	/**
	 * 查找用户的好友
	 * @return
	 */
	public List<Friends> findlist();
	
	/**
	 * 获取好友ID
	 * @param uid 用户的ID
	 * @return 返回一个String行的好友ID，如 1,2,3
	 */
	public String appendFriends(int uid);
	

}
