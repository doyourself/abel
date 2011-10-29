package com.xx.abel.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xx.abel.bean.Notepad;
import com.xx.abel.dao.intf.NotepadDao;
import com.xx.abel.service.intf.NotepadService;

@Service
public class NotepadServiceImpl implements NotepadService{

	@Autowired
	private NotepadDao notepadDao;
	
	public void delete(int id) {
		notepadDao.deleteById(Notepad.class, id);
	}

	@SuppressWarnings("static-access")
	public List<Notepad> findlist(Integer uid) {
		if(uid == null)uid=UserServiceImpl.getUser().getId();
		List<Notepad> list = notepadDao.findByProperty(Notepad.class, "users.id", uid, 1);
		List<Notepad> l = new LinkedList<Notepad>();
		for (Notepad notepad : list) {
			Calendar c = Calendar.getInstance();
			c.setTime(notepad.getCreateTime());
			c.add(c.MONTH, -1);
			Date te = c.getTime();
			notepad.setCreateTime(te);
			l.add(notepad);
		}
		return l;
	}

	public void save(Notepad notepad) {
		if(notepad.getUsers() == null)notepad.setUsers(UserServiceImpl.getUser());
		if(notepad.getCreateTime()==null)notepad.setCreateTime(new Date());
		if(notepad.getIsView()==null)notepad.setIsView(0);
		notepadDao.save(notepad);
	}

	public Notepad findById(Integer id) {
		return notepadDao.findById(Notepad.class, id);
	}

}
