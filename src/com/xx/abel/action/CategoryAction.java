package com.xx.abel.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.xx.abel.bean.Category;
import com.xx.abel.bean.Users;
import com.xx.abel.service.impl.UserServiceImpl;
import com.xx.abel.service.intf.CategoryService;

@Controller
public class CategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoryService categoryService;

	public String saveOrUpdate() {
		Object obj = ServletActionContext.getRequest().getParameter("Ct");
		this.categoryService.saveOrUpdate(category);
		if(obj!=null||"js".equals((String)obj)){
			this.list = categoryService.list(UserServiceImpl.getUser().getId(), 1);
			return "js";
		}else{
			return "list";
		}
	}

	public String list() {
		Users user = UserServiceImpl.getUser();
		if (user == null)
			return "toLogin";
		this.list = categoryService.list(user.getId(), type);
		return "list";
	}

	private Category category;
	
	private List<Category> list;

	private int type;

	public void setType(int type) {
		this.type = type;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
