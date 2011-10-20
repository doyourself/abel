package com.xx.abel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Blog;
import com.xx.abel.dao.intf.BlogDao;
import com.xx.abel.service.intf.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogDao;
	
	public List<Blog> list() {
		return blogDao.list(UserServiceImpl.getUser().getId());
	}

	public void saveOrUpdate(Blog blog) {
		if(blog.getUsers()==null||blog.getUsers().getId() == null)blog.setUsers(UserServiceImpl.getUser());
		if(blog.getCreateTime() == null)blog.setCreateTime(new Date());
		blogDao.saveOrUpdate(blog);
	}
	public void save(Blog blog) {
		if(blog.getUsers()==null||blog.getUsers().getId() == null)blog.setUsers(UserServiceImpl.getUser());
		if(blog.getCreateTime() == null)blog.setCreateTime(new Date());
		blogDao.save(blog);
	}

	public Blog findById(Integer id) {
		return blogDao.findById(Blog.class, id);
	}
}
