package com.xx.abel.service.intf;

import java.util.List;

import com.xx.abel.bean.Dynamic;

public interface DynamicService {
	
	public void save(Dynamic dynamic);
	
	public List<Dynamic> list(int start, int end);
}
