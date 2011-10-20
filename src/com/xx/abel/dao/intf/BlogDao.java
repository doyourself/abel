package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Blog;

public interface BlogDao extends BaseDAO<Blog,Integer>{
	
	public List<Blog> list(int uid);

}
