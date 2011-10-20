package com.xx.abel.bug;

import java.util.LinkedList;

import com.xx.abel.bean.UrlsClass;

public class XC extends Thread {

	private String url;

	public XC(String url) {
		this.url = url;
	}
	LinkedList<UrlsClass> linkList;
	
	LinkedList<UrlsClass> linkUrl = new LinkedList<UrlsClass>();

	public LinkedList<UrlsClass> XCstart(int j,String[] url) throws InterruptedException {
		Urls us = new Urls();
		linkList = us.getUrl(url);
		linkUrl.addAll(linkList);
		for (int k = 1; k < j; k++) {
//			int val = linkList.size() / 2;
			XC t = null;
			for (int i = 0; i < linkList.size(); i++) {
				System.out.println("========================");
				System.out.println("要抓的网址："+linkList.get(i).getUrl());
				t = new XC(linkList.get(i).getUrl());
				t.start();
				t.join();
			}
//			XC t2 = null;
//			for (int l = val; l < linkList.size(); l++) {
//				t2 = new XC(linkList.get(l).getUrl());
//				t2.start();
//			}
//			t2.join();
		}
		return linkUrl;
	}

	public static void main(String[] args) throws InterruptedException {
//		new XC(0).XCstart(200);
	}

	public void run() {
		Urls us = new Urls();
		String urls[]=new String[]{url};
		linkList = us.getUrl(urls);
		linkUrl.addAll(linkList);
	}

}
