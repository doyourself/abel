package com.xx.abel.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.abel.bean.Notepad;
import com.xx.abel.service.impl.UserServiceImpl;
import com.xx.abel.service.intf.NotepadService;

@Controller
@Scope("prototype")
public class NotepadAction {
	
	@Autowired
	private NotepadService notepadService;
	
	public String list(){
		list = notepadService.findlist(null);
		return "success";
	}
	public String save(){
		notepadService.save(notepad);
		return "list";
	}
	public String findById(){
		Integer id =notepad.getId();
		if(id!=null)
		notepad = notepadService.findById(id);
		return "view";
	}
	public void delete(){
		notepadService.delete(notepad.getId());
	}
	
	private List<Notepad> list;

	public List<Notepad> getList() {
		return list;
	}

	public void setList(List<Notepad> list) {
		this.list = list;
	}
	
	private Notepad notepad;

	public Notepad getNotepad() {
		return notepad;
	}
	public void setNotepad(Notepad notepad) {
		this.notepad = notepad;
	}

	
}
