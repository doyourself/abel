package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Notepad;

public interface NotepadService {

	public List<Notepad> findlist(Integer uid);
	
	public void save(Notepad notepad);
	
	public void delete(int id);
	
	public Notepad findById(Integer id);
	
}
