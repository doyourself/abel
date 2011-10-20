package com.xx.abel.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Comment;
import com.xx.abel.dao.intf.CommentDao;

@SuppressWarnings("unchecked")
@Repository
public class CommentDaoImpl extends BaseDAOImpl<Comment, Integer> implements CommentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> list(int leave, int sortId, int type) {
		Object[] params={sortId,leave,type};
		return getListAll("from Comment where status=0 and sortId=? and level=? and type=? order by createTime desc", params);
	}
	public List<Comment> list2(int leave, int parentId, int type) {
		Object[] params={parentId,type};
		return getListAll("from Comment where status=0 and parentId=? and type=?", params);
	}
	public int updateSOR(String column,int id) {
		
		String hql="update comment set "+column+"="+column+"+1 where id="+id;
		jdbcTemplate.execute(hql);
		return 1;
		//return this.bulkUpdate(hql, column,column,id);
	}
}
