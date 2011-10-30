package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Bug;

public interface BugService {
	
	public List<Bug> findAll(Integer start,Integer count);
	
	public void save(Bug bug);
	
	public Bug findById(int id);
	
	public void delete(Bug bug);

}
