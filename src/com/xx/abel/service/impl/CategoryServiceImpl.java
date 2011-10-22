package com.xx.abel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Category;
import com.xx.abel.dao.intf.CategoryDao;
import com.xx.abel.service.intf.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	public void saveOrUpdate(Category category){
		if(category.getUsers()==null||category.getUsers().getId() == null)category.setUsers(UserServiceImpl.getUser());
		if(category.getCreateTime() == null)category.setCreateTime(new Date());
		categoryDao.saveOrUpdate(category);
	}
	
	public List<Category> list(int uid, int type){
		return categoryDao.list(uid, type);
	}

	public void delete(int id) {
		categoryDao.deleteById(Category.class, id);
	}

}
