package com.xx.abel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Tag;
import com.xx.abel.dao.intf.TagDao;
import com.xx.abel.service.intf.TagService;
@Service
public class TagServiceImpl implements TagService{

	@Autowired
	private TagDao tagDao;
	public void saveOrUpdate(Tag tag) {
		if(tag.getUsers() == null) tag.setUsers(UserServiceImpl.getUser());
		if(tag.getCreateTime()==null)tag.setCreateTime(new Date());
		tagDao.saveOrUpdate(tag);
	}
	public List<Tag> list(int resourceId,int type) {
		return tagDao.list(resourceId, UserServiceImpl.getUser().getId(), type);
	}

}
