package com.xx.abel.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xx.abel.service.intf.TagService;

@Controller
@Scope("prototype")
public class TagAction {
	
	@SuppressWarnings("unused")
	@Autowired
	private TagService tagService;

}
