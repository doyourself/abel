package com.xx.abel.service.intf;

import com.xx.abel.bean.Comment;
import com.xx.abel.util.PageListData;

public interface CommentService {
	
	public void save(Comment comment);
	
	public PageListData list(int leave,int sortId,int type,int currentPage,int pageSize);

	public Comment findById(int id);
	
	public boolean updateSOR(String column,int id);
	
}
