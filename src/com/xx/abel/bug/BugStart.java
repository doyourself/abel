package com.xx.abel.bug;

import java.util.LinkedList;

import com.xx.abel.bean.UrlsClass;

public class BugStart {
	
	public static void main(String[] args) {
		BugStart.start();
	}
	public static void start(){
		try {
			XC x = new XC("");
			//,"http://www.sina.com.cn/""
			String[] surl=new String[]{"http://www.163.com/","http://news.baidu.com/"};
			LinkedList<UrlsClass> xx = x.XCstart(1,surl);
			System.out.println(xx.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
