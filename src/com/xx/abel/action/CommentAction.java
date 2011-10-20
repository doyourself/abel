package com.xx.abel.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xx.abel.bean.Comment;
import com.xx.abel.service.intf.CommentService;

@Controller
public class CommentAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private CommentService commentService;
	
	public String addComment(){
		 commentService.save(comment);
		 if(comment.getLevel()!=null && comment.getLevel() == 1){
			 return "show1";
		 }else if(comment.getLevel() != null && comment.getLevel() ==2){
			 comment1 = commentService.findById(comment.getSortId());
			 return "show2";
		 }else{
			 return "show";
		 }
	}
	public String list(){
		Object sortId =  ServletActionContext.getRequest().getParameter("resould");
		Object type = ServletActionContext.getRequest().getParameter("type");
		if(sortId != null && type != null)
		{
			pageListData = this.commentService.list(0, Integer.parseInt(sortId+""), Integer.parseInt(type+""), currentPage, 20);
		}
		return "list";
	}
	public void updateSRO(){
		if(comment!= null && column != null && comment.getId() != null && ("support".equals(column) || "opposition".equals(column) || "report".equals(column))){
			this.commentService.updateSOR(column, comment.getId());
		}
	}
	
	private Comment comment1;
	
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Comment getComment1() {
		return comment1;
	}
	public void setComment1(Comment comment1) {
		this.comment1 = comment1;
	}
	private String column;

	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	
}
