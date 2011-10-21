package com.xx.abel.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xx.abel.service.intf.TagService;

@Controller
public class TagAction {
	
	@SuppressWarnings("unused")
	@Autowired
	private TagService tagService;

}
