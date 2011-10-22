package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Comment;
import com.xx.abel.util.PageListData;

public interface CommentService {
	
	public void save(Comment comment);
	
	public PageListData list(int leave,int sortId,int type,int currentPage,int pageSize);
	
	public List<Comment> list(int leave,int sortId);
	
	public Comment findById(int id);
	
	public boolean updateSOR(String column,int id);
	
	/**
	 * 
	 * @param Id
	 * @param type 1、删除ID 2、删除子项
	 */
	public void jdbcdelete(String Id,int type);
	
}
