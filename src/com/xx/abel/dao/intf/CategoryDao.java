package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Category;

public interface CategoryDao extends BaseDAO<Category,Integer>{
	
	public List<Category> list(int uid,int type);

}
