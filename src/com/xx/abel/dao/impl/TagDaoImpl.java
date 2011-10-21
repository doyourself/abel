package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Tag;
import com.xx.abel.dao.intf.TagDao;

@SuppressWarnings("unchecked")
@Repository
public class TagDaoImpl extends BaseDAOImpl<Tag, Integer> implements TagDao{

	public List<Tag> list(int resourceId, int uid,int type) {
		return getListAll("from Tag where users.id=? and type=? and resourcesId=?",uid, type,resourceId);
	}

	public void delete(int resourceId, int type) {
		super.bulkUpdate("delete from Tag where type=? and resourcesId=?",type,resourceId);
	}

}
