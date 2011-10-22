package com.xx.abel.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.xx.abel.bean.Comment;
import com.xx.abel.dao.intf.CommentDao;

@SuppressWarnings("unchecked")
@Repository
public class CommentDaoImpl extends BaseDAOImpl<Comment, Integer> implements CommentDao{
	
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
		super.getJdbcTemplate().execute(hql);
		return 1;
		//return this.bulkUpdate(hql, column,column,id);
	}
	public void jdbcdelete(String id, int type) {
		super.getHibernateTemplate().clear();
		if(type==1){
			String sql="delete from comment where sortId ="+id+" and level=0 and type=1";
			super.getJdbcTemplate().execute(sql);
		}
		else{
			String sql="delete from comment where parentId in ("+id+") and type=1";
			super.getJdbcTemplate().execute(sql);
		}
	}
}
