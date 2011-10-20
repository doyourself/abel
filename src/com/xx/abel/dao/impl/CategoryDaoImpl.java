package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Category;
import com.xx.abel.dao.intf.CategoryDao;

@SuppressWarnings("unchecked")
@Repository
public class CategoryDaoImpl  extends BaseDAOImpl<Category, Integer> implements CategoryDao{

	public List<Category> list(int uid, int type) {
		return getListAll("from Category where users.id=? and type=? order by createTime desc",uid,type);
	}

}
