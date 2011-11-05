package com.xx.abel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.abel.bean.Dynamic;
import com.xx.abel.bean.Notepad;
import com.xx.abel.bean.Users;
import com.xx.abel.dao.intf.DynamicDAO;
import com.xx.abel.service.intf.DynamicService;
import com.xx.abel.service.intf.FriendsService;
import com.xx.abel.service.intf.NotepadService;

@Service
public class DynamicServiceImpl implements DynamicService{
	
	@Autowired
	private DynamicDAO dynamicDao;
	@Autowired
	private FriendsService friendsService;
	@Autowired
	private NotepadService notepadService;
	
	public void save(Dynamic dynamic) {
		if(dynamic.getCreateTime()==null)dynamic.setCreateTime(new Date());
		if(dynamic.getUsers()==null)dynamic.setUsers(UserServiceImpl.getUser());
		if(dynamic.getClickCount()==null)dynamic.setClickCount(0);
		if(dynamic.getViewCount()==null)dynamic.setViewCount(0);
		dynamicDao.save(dynamic);
		if(2==dynamic.getType()){
			Notepad notepad = new Notepad();
			String title = dynamic.getDescription();
			notepad.setTitle(title.substring(0, 20));
			notepad.setDescription(title);
			notepadService.save(notepad);
		}
		
	}

	public List<Dynamic> list(int start, int end) {
		Users user = UserServiceImpl.getUser();
		String uid=friendsService.appendFriends(user.getId());
		if(uid==null)
		uid =user.getId().toString();
		return dynamicDao.findlist(start, end, uid);
	}

}
