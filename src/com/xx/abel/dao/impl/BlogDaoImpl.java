package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Blog;
import com.xx.abel.dao.intf.BlogDao;

@SuppressWarnings("unchecked")
@Repository
public class BlogDaoImpl  extends BaseDAOImpl<Blog, Integer> implements BlogDao{

	public List<Blog> list(int uid) {
		return getListAll("from Blog where users.id=? order by createTime desc",uid);
	}

}
