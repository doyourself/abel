package com.xx.abel.bug;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xx.abel.bean.UrlsClass;

public class Urls {
	private static Urls myurl = new Urls("<body", "/body>");

	public Urls() {
		notURL.add("#");
		notURL.add("javascript");
		notURL.add("onclick");
		notURL.add("甲测资字11002019");
		notURL.add("导航");
		notURL.add("产品答疑");
		notURL.add("隐私保护");
		notURL.add("京卫网审[2010]");
		notURL.add("经营许可证");
		notURL.add("电信业务审批[2001]字第379号");
		notURL.add("国家药监局");
		notURL.add("京教研[2002]7号");
		notURL.add("国家药监局（京）-经营性-2009-0011");
		notURL.add("互联网新闻信息服务许可");
		notURL.add("新出网许（京）字009号");
		notURL.add("京网文[2011]0407-139号");
		notURL.add("京ICP证");
		notURL.add("版权所有");
		notURL.add("SINA English");
		notURL.add("网站律师");
		notURL.add("广告服务");
		notURL.add("联系我们");
		notURL.add("诚聘英才");
		notURL.add("About Sina");
		notURL.add("新浪简介");
		GVtitle.add("id");
		GVtitle.add("class");
		YURL.add("html");
		// notURL.add("");
		notURL.add("bf");
		notURL.add("公告");
		notURL.add("专栏");
		notURL.add("@");
		notURL.add("许可证");
		notURL.add("登录");
		notURL.add("许可证");
		notURL.add("注册");
		notURL.add("#");
		notURL.add("img");
		notURL.add("javascript");
		notURL.add("密码");
		notURL.add("退出");
		notURL.add("会员");
		notURL.add("邮箱");
		notURL.add("客服");
		notURL.add("关于我们");
		notURL.add("招聘信息");
		notURL.add("清华");
		notURL.add("更多");
	}

	private String startUrl; // 开始采集网址

	String urlContent;

	String ContentArea;

	private String strAreaBegin, strAreaEnd; // 采集区域开始采集字符串和结束采集字符串

	@SuppressWarnings("unused")
	private String stringInUrl, stringNotInUrl;

	String strContent;// 获得的采集内容

	String[] allUrls; // 采集到的所有网址

	private String regex; // 采集规则

	UrlAndTitle urlAndTitle = new UrlAndTitle(); // 存储网址和标题
	public static LinkedList<String> notURL = new LinkedList<String>();
	public static LinkedList<String> YURL = new LinkedList<String>();
	public static LinkedList<String> GVtitle = new LinkedList<String>();

	public static void main(String[] args) {
		LinkedList<UrlsClass> linkedList = new LinkedList<UrlsClass>();
		String[] surl = new String[] { "http://www.sina.com.cn/",
				"http://news.baidu.com/" };
		for (String l : surl) {
			myurl.getStartUrl(l);
			myurl.getUrlContent();
			myurl.getContentArea();
			myurl.getStringNotInUrl("google");
			myurl.Urls(linkedList);
		}
	}

	public LinkedList<UrlsClass> getUrl(String[] l) {
		LinkedList<UrlsClass> linkedList = new LinkedList<UrlsClass>();
		for (String ls : l) {
			if(ls.length() < 9)
				continue;
			String http = ls.substring(0, 4);
			if (!"http".equals(http))
				continue;
			myurl.getStartUrl(ls);
			myurl.getUrlContent();
			myurl.getContentArea();
			myurl.getStringNotInUrl("google");
			myurl.Urls(linkedList);
		}
		return linkedList;
	}

	// 初始化构造函数 strAreaBegin 和strAreaEnd

	public Urls(String strAreaBegin, String strAreaEnd) {
		this.strAreaBegin = strAreaBegin;
		this.strAreaEnd = strAreaEnd;
	}

	public boolean RTF(String title) {
		for (String val : notURL) {
			if (title.indexOf(val) != -1) {
				return true;
			}
		}
		return false;
	}

	public boolean FORMAT(String url) {
		for (String val : YURL) {
			if (url.indexOf(val) == -1) {
				return true;
			}
		}
		return false;
	}

	public boolean getGVTitle(String title) {
		for (String val : GVtitle) {
			if (title.indexOf(val) != -1) {
				return true;
			}
		}
		return false;
	}

	//
	public void Urls(LinkedList<UrlsClass> linkedList) {
		int i = 0;
		// String regex ="<a
		// href="?'?http://[a-zA-Z0-9]+.[a-zA-Z0-9]+.[a-zA-Z]+/?[.?[S|s]]+[a>]$";
		final String regex = "<a.*?/a>";
		// String regex ="http://.*?>";
		final Pattern pt = Pattern.compile(regex);
		final Matcher mt = pt.matcher(ContentArea);
		while (mt.find()) {
			// 获取标题
			final Matcher title = Pattern.compile(">.*?</a>").matcher(
					mt.group());
			String url = mt.group();
			if (RTF(url)) {
				continue;
			}
			if (FORMAT(url))
				continue;
			String tit = "";
			while (title.find()) {
				tit = title.group().replaceAll(">|</a>", "");
			}
			if ("".equals(tit) || tit == null)
				continue;
			if (getGVTitle(tit))
				continue;
			// http://news.sina.com.cn/guide/
			tit = tit.replaceAll("<b", "");
			tit = tit.replaceAll("</b", "");
			tit = tit.replaceAll("<span", "");
			tit = tit.replaceAll("</span", "");
			tit = tit.replaceAll("<div", "");
			tit = tit.replaceAll("</div", "");
			tit = tit.replaceAll("<font", "");
			tit = tit.replaceAll("</font", "");
			tit = tit.replaceAll("<h3", "");
			tit = tit.replaceAll("</h3", "");
			tit = tit.replaceAll("<h2", "");
			tit = tit.replaceAll("</2", "");
			tit = tit.replaceAll("<", "");
			tit = tit.replaceAll("</", "");
			tit = tit.replaceAll("&nbsp;","");
			String URLtitle = Html2Text(tit);
			if (URLtitle == null || "".equals(URLtitle)
					|| URLtitle.length() < 6)
				continue;
			// 获取网址
			final Matcher myurl = Pattern.compile("href=.*?>").matcher(
					mt.group());
			while (myurl.find()) {
				String u = myurl.group().replaceAll("href=|>", "");
				String ul;
				if (u.indexOf("\"") != -1)
					ul = u.substring(1, u.indexOf("\"", 2));
				else {
					ul = u;
				}
				String http = ul.substring(0, 4);
				String html = ul.substring(ul.length() - 4, ul.length());
				String htm = ul.substring(ul.length() - 4, ul.length() - 1);
				if (!"http".equals(http)
						|| !("html".equals(html) && "htm".equals(htm)))
					continue;
				UrlsClass uc = new UrlsClass();
				uc.setTitle(URLtitle);
				uc.setUrl(ul);
				System.out.println("标题:" + URLtitle);
				System.out.println("网址:" + ul);
				linkedList.add(uc);
				i++;
			}
		}
		System.out.println("共有" + i + "个符合结果");
	}

	// 获得开始采集网址
	public void getStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	// 获得网址所在内容;
	public void getUrlContent() {

		StringBuffer is = new StringBuffer();
		try {
			URL myUrl = new URL(startUrl);
			InputStreamReader isr = new InputStreamReader(myUrl.openStream());
			String encoding = isr.getEncoding();
			System.out.println(isr.getEncoding());
			BufferedReader br = new BufferedReader(isr);
			String s;
			while ((s = br.readLine()) != null) {
				is.append(new String(s.getBytes(),encoding));
			}
			urlContent = new String(is.toString().getBytes(),encoding);
		} catch (Exception e)

		{
			System.out.println("网址文件未能输出");
			e.printStackTrace();
		}

	}

	// 获得网址所在的匹配区域部分
	public void getContentArea() {
		int pos1 = 0, pos2 = 0;
		pos1 = urlContent.indexOf(strAreaBegin) + strAreaBegin.length();
		pos2 = urlContent.indexOf(strAreaEnd, pos1);
		ContentArea = urlContent.substring(pos1, pos2);
	}

	// 以下两个函数获得网址应该要包含的关键字及不能包含的关键字
	// 这里只做初步的实验。后期，保护的关键字及不能包含的关键字应该是不只一个的。
	public void getStringInUrl(String stringInUrl) {
		this.stringInUrl = stringInUrl;

	}

	public void getStringNotInUrl(String stringNotInUrl) {
		this.stringNotInUrl = stringNotInUrl;
	}

	// 获取采集规则

	// 获取url网址
	public void getUrl() {

	}

	public String getRegex() {
		return regex;

	}

	class UrlAndTitle {
		String myURL;

		String title;
	}

	public static String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^\"]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}
}
