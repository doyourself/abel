package com.xx.abel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Friends;
import com.xx.abel.dao.intf.FriendsDao;
import com.xx.abel.service.intf.FriendsService;
@Service
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	private FriendsDao friendsDao;
	
	public List<Friends> findlist() {
		int uid = UserServiceImpl.getUser().getId();
		return friendsDao.findlist(uid);
	}

	public String appendFriends(int uid) {
		List<Friends> list = this.findlist();
		StringBuffer sb = new StringBuffer();
		String friend = null;
		for (Friends friends:list) {
			sb.append(friends.getFriendId()+",");
		}
		if(sb!=null&&"".equals(sb)&&sb.length()>1){
			friend = sb.substring(0, sb.length()-1);
		}
		return friend;
	}

}
