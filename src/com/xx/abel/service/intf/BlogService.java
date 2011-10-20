package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Blog;

public interface BlogService {
	
	public List<Blog> list();

	public void saveOrUpdate(Blog blog);
	
	public void save(Blog blog);
	
	public Blog findById(Integer id);
}
