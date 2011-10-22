package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Category;

public interface CategoryService {
	
	public void saveOrUpdate(Category category);

	public List<Category> list(int uid, int type);
	
	public void delete(int id);
	
}
