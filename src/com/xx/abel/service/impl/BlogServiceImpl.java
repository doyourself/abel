package com.xx.abel.service.impl;

import java.util.Date;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Blog;
import com.xx.abel.bean.Comment;
import com.xx.abel.dao.intf.BlogDao;
import com.xx.abel.dao.intf.CommentDao;
import com.xx.abel.service.intf.BlogService;
import com.xx.abel.service.intf.CommentService;
import com.xx.abel.service.intf.TagService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private TagService tagService;
	@Autowired
	private CommentService commentService;

	public List<Blog> list() {
		return blogDao.list(UserServiceImpl.getUser().getId());
	}

	public void saveOrUpdate(Blog blog) {
		if (blog.getUsers() == null || blog.getUsers().getId() == null)
			blog.setUsers(UserServiceImpl.getUser());
		if (blog.getCreateTime() == null)
			blog.setCreateTime(new Date());
		blogDao.saveOrUpdate(blog);
	}

	public void save(Blog blog) {
		if (blog.getUsers() == null || blog.getUsers().getId() == null)
			blog.setUsers(UserServiceImpl.getUser());
		if (blog.getCreateTime() == null)
			blog.setCreateTime(new Date());
		blogDao.save(blog);
	}

	public Blog findById(Integer id) {
		return (Blog) blogDao.loadObject(Blog.class, id);
	}

	public void delete(Integer id) {
		tagService.delete(id, 1);
		blogDao.deleteById(Blog.class, id);
		List<Comment> listCommentS0 = commentService.list(0, id);
		if (listCommentS0 != null && listCommentS0.size() != 0) {
			StringBuffer sb = new StringBuffer();
			for (Comment comment : listCommentS0) {
				sb.append(comment.getId() + ",");
			}
			if (sb != null && sb.length() > 0) {
				int len = sb.length()-1;
				String strid = sb.substring(0, len);
				commentService.jdbcdelete(id+"" ,1);
				commentService.jdbcdelete(strid,0);
			}
		}
	}
}
