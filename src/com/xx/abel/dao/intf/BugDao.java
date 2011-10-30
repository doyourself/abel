package com.xx.abel.dao.intf;


import java.util.List;

import com.xx.abel.bean.Bug;

public interface BugDao extends BaseDAO<Bug, Integer>{
	
//	public List<Bug> list(int resourceId,int uid,int type);
//	
//	public void delete(int resourceId,int type);
	public List<Bug> list(int userId);
	public List<Bug> list(int userId,int start,int end);
	
}
