package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Bug;
import com.xx.abel.dao.intf.BugDao;


@SuppressWarnings("unchecked")
@Repository
public class BugDaoImpl extends BaseDAOImpl<Bug, Integer> implements BugDao{

	public List<Bug> list(int userId, int start, int end) {
		return getListAll("from Bug where users.id="+userId+" order by createTime desc LIMIT "+start+","+end);
	}

	public List<Bug> list(int userId) {
		return getListAll("from Bug where users.id="+userId+" order by createTime desc");
	}


}
