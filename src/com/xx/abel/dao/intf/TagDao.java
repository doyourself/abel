package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Tag;

public interface TagDao extends BaseDAO<Tag, Integer>{
	
	public List<Tag> list(int resourceId,int uid,int type);
	
	public void delete(int resourceId,int type);
}
