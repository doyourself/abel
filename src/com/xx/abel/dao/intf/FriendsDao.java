package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Friends;

public interface FriendsDao extends BaseDAO<Friends, Integer>{
	
	public List<Friends> findlist(int uid);

}
