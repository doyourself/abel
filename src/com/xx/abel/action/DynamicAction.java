package com.xx.abel.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.abel.bean.Dynamic;
import com.xx.abel.service.intf.DynamicService;

@Controller
@Scope("prototype")
public class DynamicAction {
	
	@Autowired
	private DynamicService dynamicService;

	public String save(){
		dynamicService.save(dynamic);
		return "list";
	}
	public String findList(){
		list = dynamicService.list(start, end);
		return "list";
	}
	
	private List<Dynamic> list;
	
	private int start;
	
	private int end;
	
	private Dynamic dynamic;
	
	public Dynamic getDynamic() {
		return dynamic;
	}
	public void setDynamic(Dynamic dynamic) {
		this.dynamic = dynamic;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<Dynamic> getList() {
		return list;
	}
	public void setList(List<Dynamic> list) {
		this.list = list;
	}
}
