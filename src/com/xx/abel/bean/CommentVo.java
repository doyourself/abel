package com.xx.abel.bean;

import java.util.List;

public class CommentVo {
	
	private Comment comment;
	
	private List<CommentVo> commentVo;

	public List<CommentVo> getCommentVo() {
		return commentVo;
	}

	public void setCommentVo(List<CommentVo> commentVo) {
		this.commentVo = commentVo;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}


}
