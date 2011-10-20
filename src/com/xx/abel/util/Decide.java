package com.xx.abel.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Decide {

	/**
	 * 判断是否为空
	 * 
	 * @param name
	 * @throws Exception
	 */
	public static void isString(Object name) throws Exception {
		// 如果name为空，抛出异常
		if (name == null || "".equals((name + "").trim())) {
			throw new Exception("name can't be empty !");
		}
	}

	/**
	 * 判断是否是int 类型
	 * 
	 * @param 
	 * @return
	 */
	public static boolean isNumeric(Object val) throws Exception{
		try {
		    return val instanceof Integer;   
		} catch (Exception e) {
			throw new Exception("判断int类型错误！");
		}
	}

	/**
	 * 过滤脏数据代码 如HTML代码等！
	 * @param val
	 * @return
	 */
	public static String isHTML(Object val) {
		val = (val + "").replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "").replaceAll(
				"</[a-zA-Z]+[1-9]?>", "");// 去掉标签
		String reg = "[`~$%^()+=|{}':;'\\[\\]<>/~@#￥%……&（）——+|{}【】‘；”“’\"]";// 去掉内容的
		return (val + "").replaceAll(reg, "");
	}

	/**
	 * 判断是否是时间类型 是返回时间类型 否则返回 null
	 * @param val
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public static Date isTime(Object val) throws Exception{
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return smf.parse(val + "");
		} catch (Exception e) {
			return null;
//			throw new Exception("判断时间类型错误");
		}
	}
	/**
	 * 根据ch的字符 在obj查询 截取从ch开始后的字符
	 * @param obj 将要截取的字符串
	 * @param ch 条件
	 * @return
	 */
	public static String intercept(String obj,String ch){
		if(obj.indexOf(ch) == -1){
			return obj;
		}else{
			return obj.substring(obj.lastIndexOf(ch)+1);
		}
	}
}
