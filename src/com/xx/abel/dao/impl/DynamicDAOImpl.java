package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Dynamic;
import com.xx.abel.dao.intf.DynamicDAO;

@SuppressWarnings("unchecked")
@Repository
public class DynamicDAOImpl extends BaseDAOImpl<Dynamic, Integer> implements DynamicDAO{

	public List<Dynamic> findlist(int start, int end, String uid) {
		String hql="from Dynamic where users.id in ("+uid+") order by createTime desc LIMIT "+start+","+end;
		return getListAll(hql);
	}

}
