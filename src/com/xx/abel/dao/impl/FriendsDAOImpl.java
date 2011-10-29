package com.xx.abel.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.xx.abel.bean.Friends;
import com.xx.abel.dao.intf.FriendsDao;
@SuppressWarnings("unchecked")
@Repository
public class FriendsDAOImpl extends BaseDAOImpl<Friends, Integer> implements FriendsDao{

	public List<Friends> findlist(int uid) {
		String hql="from Friends where users.id=?";
		return getListAll(hql, uid);
	}

}
