package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Comment;

public interface CommentDao extends BaseDAO<Comment, Integer>{
	
	public List<Comment> list(int leave, int sortId, int type);
	
	public List<Comment> list2(int leave, int parentId, int type);

	public int updateSOR(String column,int id);
	
	/**
	 * 
	 * @param id 删除的sortId 或者 parentId
	 * @param type 1是删除总的评论 2、是总的子评论
	 */
	public void jdbcdelete(String id , int type);
	
}
