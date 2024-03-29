package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Tag;

public interface TagService {
	
	public void saveOrUpdate(Tag tag);
	
	public List<Tag> list(int resourceId,int type);
	
	public void delete(int resourceId,int type);
	
	public String findUserTag(int resourceId,int type);

}
