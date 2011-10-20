package com.xx.abel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Blog;
import com.xx.abel.bean.Bug;
import com.xx.abel.bean.Comment;
import com.xx.abel.bean.CommentVo;
import com.xx.abel.bean.Notepad;
import com.xx.abel.dao.intf.CommentDao;
import com.xx.abel.service.intf.CommentService;
import com.xx.abel.util.PageListData;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	public void save(Comment comment) {
		if (comment.getOpposition() == null)
			comment.setOpposition(0);
		comment.setCreateTime(new Date());
		if (comment.getUsers() == null)
			comment.setUsers(UserServiceImpl.getUser());
		System.out.println(comment.getOpposition());
		if (comment.getLevel() == null)
			comment.setLevel(0);
		if (comment.getReport() == null)
			comment.setReport(0);
		if (comment.getSupport() == null)
			comment.setSupport(0);
		this.commentDao.save(comment);
	}

	@SuppressWarnings("unchecked")
	public PageListData list(int leave, int sortId, int type, int currentPage,
			int pageSize) {
		Class entityClass = Blog.class;
		switch (type) {
		case 2:
			entityClass = Notepad.class;
			break;
		case 3:
			entityClass = Bug.class;
			break;
		}
		String hql = "from Comment where status=0 and sortId=? and level=? and type=? order by createTime desc";
		Object[] params = { sortId, leave, type };
		PageListData pageListData = this.commentDao.findList(entityClass, hql,
				params, currentPage, pageSize);
		List<Comment> list = pageListData.getDataList();
		List<CommentVo> l = new LinkedList<CommentVo>();
		if (list != null) {
			for (Comment comment : list) {
				CommentVo cv = new CommentVo();
				cv.setComment(comment);
//				List<Comment> list1 = commentDao.list(1, comment.getId(), type);
				List<Comment> list2 = commentDao.list2(2, comment.getId(), type);
				if (list2 != null && list2.size() != 0){
						LinkedList<CommentVo> cvList =new LinkedList<CommentVo>();
						for(Comment c:list2){
							CommentVo cvc = new CommentVo();
							cvc.setComment(c);
							cvList.add(cvc);
						}
						cv.setCommentVo(cvList);
				}
				l.add(cv);
			}
		}
		pageListData.setDataList(l);
		return pageListData;
	}

	public Comment findById(int id) {
		return commentDao.findById(Comment.class, id);
	}

	public boolean updateSOR(String column,int id) {
		return this.commentDao.updateSOR(column, id) > 0 ? true : false;
	}

}
