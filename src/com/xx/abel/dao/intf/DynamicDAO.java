package com.xx.abel.dao.intf;

import java.util.List;

import com.xx.abel.bean.Dynamic;

public interface DynamicDAO extends BaseDAO<Dynamic, Integer>{

	/**
	 * 
	 * @param start
	 * @param end
	 * @param uid
	 * @return
	 */
	public List<Dynamic> findlist(int start,int end,String uid);
	
}
