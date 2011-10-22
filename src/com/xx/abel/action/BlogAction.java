package com.xx.abel.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.xx.abel.bean.Blog;
import com.xx.abel.bean.Category;
import com.xx.abel.bean.Tag;
import com.xx.abel.bean.Users;
import com.xx.abel.service.impl.UserServiceImpl;
import com.xx.abel.service.intf.BlogService;
import com.xx.abel.service.intf.CategoryService;
import com.xx.abel.service.intf.TagService;

@Controller
public class BlogAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;

	public String add() {
		blog=null;
		Users user = UserServiceImpl.getUser();
		categoryList = categoryService.list(user.getId(), 1);
		return "add";
	}

	public String edit() {
		Users user = UserServiceImpl.getUser();
		if (blog != null && blog.getId() != null)
			blog = blogService.findById(blog.getId());
		categoryList = categoryService.list(user.getId(), 1);
		this.setTag(tagService.findUserTag(blog.getId(), 1));
		return "edit";
	}

	public String list() {
		list = blogService.list();
		return "list";
	}

	public String saveOrUpdate() {
		if (tag != null) {
			String tagval[] = tag.split(" ");
			System.out.println(blog.getId());
			if (blog.getId() == null)
				blogService.save(blog);
			else {
				if (tagval.length > 0 && blog != null && blog.getId() != null) {
					tagService.delete(blog.getId(), 1);
				}
				blogService.saveOrUpdate(blog);
			}
			for (int i = 0; i < tagval.length; i++) {
				Tag tag = new Tag();
				tag.setResourcesId(blog.getId());
				tag.setType(1);
				tag.setDescription(tagval[i]);
				tagService.saveOrUpdate(tag);
			}
		}
		return "findById";
	}

	public String findById() {
		if (blog != null && blog.getId() != null) {
			blog = blogService.findById(blog.getId());
			listTag = tagService.list(blog.getId(), 1);
			List<Tag> list = this.tagService.list(blog.getId(), 1);
			StringBuffer sb = new StringBuffer();
			for (Tag t : list) {
				sb.append(t.getDescription() + " ");
			}
			Integer tagsize = list.size();
			if (tagsize != null && tagsize > 0) {
				sb.substring(0, sb.length() - 1);
			}
			this.setTag(sb + "");
		}
		return "view";
	}

	public void delete() {
		if (blog != null && blog.getId() != null)
			blogService.delete(blog.getId());
	}

	private Blog blog;

	private List<Blog> list;

	public List<Blog> getList() {
		return list;
	}

	public void setList(List<Blog> list) {
		this.list = list;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	private List<Category> categoryList;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	private List<Tag> listTag;

	public List<Tag> getListTag() {
		return listTag;
	}

	public void setListTag(List<Tag> listTag) {
		this.listTag = listTag;
	}

}
