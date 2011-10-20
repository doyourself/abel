package com.xx.abel.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class OVCommonUtil {
	private static Logger logger = Logger.getLogger(OVCommonUtil.class);

	public static String nvl(String value) {
		if (value == null || "".equals(value.trim())) {
			return "";
		} else {
			return value.trim();
		}
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		String resultString = origin;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
			return origin;
		}
		return resultString;
	}

	public static String getIntRandom(int length) {

		Random random = new Random();
		int tempInt = random.nextInt();
		if (Integer.MIN_VALUE == tempInt)
			tempInt++;
		tempInt = Math.abs(tempInt);
		StringBuffer temp = new StringBuffer("");
		for (int i = 0; i < length; i++) {
			temp.append("0");
		}
		String randomPass = (tempInt + temp.toString()).substring(0, length);
		return randomPass;
	}

	public static String getRandom(int length) {

		StringBuffer randomCode = new StringBuffer("");
		for (int i = 0; i < length; i++) {
			randomCode.append(getRandChar());
		}
		return randomCode.toString();
	}

	public static String getRandChar() {
		int rand = (int) Math.round(Math.random() * 2);
		long itmp = 0;
		char ctmp = '\u0000';

		switch (rand) {

		case 1:
			itmp = Math.round(Math.random() * 25 + 65);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);

		case 2:
			itmp = Math.round(Math.random() * 25 + 97);
			ctmp = (char) itmp;
			return String.valueOf(ctmp);

		default:
			itmp = Math.round(Math.random() * 9);
			return String.valueOf(itmp);
		}
	}

	public static String getMonth(String monthFormat, int num) {
		String str = "";

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, num);

		Date date = c.getTime();
		SimpleDateFormat df = new SimpleDateFormat(monthFormat);
		str = df.format(date);

		return str;
	}

	public static boolean checkPassword(String newPwd) {
		String pwdFormat = "[A-Za-z0-9]{8,15}";
		if (newPwd == null || newPwd.trim().length() == 0
				|| !Pattern.matches(pwdFormat, newPwd)) {
			return false;
		}

		int letterNum = 0;
		int digitNum = 0;

		char ch = 0;
		int ascii = 0;
		for (int i = 0; i < newPwd.length(); i++) {
			ch = newPwd.charAt(i);
			ascii = (int) ch;
			if (ascii >= 48 && ascii <= 57) {
				digitNum++;
			} else {
				letterNum++;
			}
		}

		if (letterNum < 6 || digitNum < 2) {
			return false;
		}

		return true;
	}

	public static String toFullTime(String theSecond) {
		int h = 0;
		int m = 0;
		int s = 0;
		if ("".equals(theSecond)) {
			return "";
		}
		int intSecond = Integer.valueOf(theSecond).intValue();
		if (intSecond > 0 && intSecond < 60) {
			return theSecond;
		}
		String fullTime = "";
		h = (int) Math.floor(intSecond / 3600.0);
		if (h > 0) {
			fullTime = h + ":";
			m = (int) Math.floor((intSecond - h * 3600) / 60.0);
			if (m > 9) {
				s = intSecond - h * 3600 - m * 60;
				if (s > 9) {
					fullTime = fullTime + m + ":" + s;
				} else {
					fullTime = fullTime + m + ":0" + s;
				}
			} else if (m > 0 && m <= 9) {
				s = intSecond - h * 3600 - m * 60;
				if (s > 9) {
					fullTime = fullTime + "0" + m + ":" + s;
				} else {
					fullTime = fullTime + "0" + m + ":0" + s;
				}

			} else {
				s = intSecond - h * 3600;
				if (s > 9) {
					fullTime = fullTime + "00:" + s;
				} else {
					fullTime = fullTime + "00:0" + s;
				}
			}
		} else {
			m = (int) Math.floor(intSecond / 60.0);
			if (m > 0) {
				s = intSecond - m * 60;
				if (s > 9) {
					fullTime = fullTime + m + ":" + s;
				} else {
					fullTime = fullTime + m + ":0" + s;
				}
			} else {
				s = intSecond;
				if (s > 9) {
					fullTime = fullTime + "00:" + s;
				} else {
					fullTime = fullTime + "00:0" + s;
				}
			}
		}
		return fullTime;
	}

	public static String daysBetween1(String fromDate, String toDate) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = ft.parse(fromDate);
			Date date2 = ft.parse(toDate);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 1000 / 60 / 60 / 24 + 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return String.valueOf(quot);
	}

	public static int daysBetween(String fromDate, String toDate) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		int betweenDays = 0;
		Date d1 = null, d2 = null;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			d1 = format.parse(fromDate);
			d2 = format.parse(toDate);
			c1.setTime(d1);
			c2.setTime(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (c1.after(c2)) {
			c1 = c2;
			c2.setTime(d1);
		}
		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
			betweenDays = c2.get(Calendar.DAY_OF_YEAR)
					- c1.get(Calendar.DAY_OF_YEAR);
		} else {
			betweenDays = c1.getActualMaximum(Calendar.DAY_OF_YEAR)
					- c1.get(Calendar.DAY_OF_YEAR)
					+ c2.get(Calendar.DAY_OF_YEAR);
			for (int i = c1.get(Calendar.YEAR) + 1; i < c2.get(Calendar.YEAR); i++) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.YEAR, i);
				betweenDays += c.getActualMaximum(Calendar.DAY_OF_YEAR);
			}
		}
		return betweenDays + 1;
	}

	public static String upperFirstChar(String str) {
		String pe;
		char ch[];
		int markOne = 0;
		StringBuffer sb = new StringBuffer("");
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			pe = st.nextToken();
			ch = pe.toCharArray();
			if (ch[0] >= 'a' && ch[0] <= 'z' && markOne == 0) {
				ch[0] = (char) (ch[0] - 32);
				markOne++;
			}
			String s = new String(ch);
			sb.append(s + " ");
		}
		return sb.toString().trim();
	}

	public static boolean isExsitDigital(String str) {
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			if (str.contains(String.valueOf(i))) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static Cookie getCookies(HttpServletRequest request,
			String cookieName) {
		Cookie[] cookies = request.getCookies();
		Cookie mycookie = null;
		if (null == cookies) {
			return mycookie;
		}
		for (int i = 0; i < cookies.length; i++) {
			if (cookieName.equals(cookies[i].getName())) {
				mycookie = cookies[i];
			}
		}
		return mycookie;
	}

	public static void saveCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName, String loginType) {

		String cookieDomain = "";
		if (null == OVLoadProperties.getInstance().getProperties(
				"ecare.isActiveCookieDomain")
				|| null == cookieDomain
				|| "true".equals(OVLoadProperties.getInstance().getProperties(
						"ecare.isActiveCookieDomain"))) {
			cookieDomain = request.getServerName();
		}
		Cookie cookie = new Cookie(cookieName, loginType);
		cookie.setDomain(cookieDomain);
		cookie.setPath("");
		response.addCookie(cookie);
	}

	public static String delCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName, String loginType) {
		String cookieDomain = "";
		if (null == OVLoadProperties.getInstance().getProperties(
				"ecare.isActiveCookieDomain")
				|| null == cookieDomain
				|| "true".equals(OVLoadProperties.getInstance().getProperties(
						"ecare.isActiveCookieDomain"))) {
			cookieDomain = request.getServerName();
		}
		String roleType = "";
		Cookie cook = getCookies(request, cookieName);
		if (null == cook) {
			roleType = loginType;
		} else {
			roleType = cook.getValue();
			Cookie cookie = new Cookie(cookieName, "");
			cookie.setMaxAge(0);
			cookie.setDomain(cookieDomain);
			cookie.setPath("");
			response.addCookie(cookie);
		}
		return roleType;
	}

	public static String formatDouble(double d, int n) {
		StringBuffer pattern = new StringBuffer("#0.");
		for (int i = 0; i < n; i++) {
			pattern.append("0");
		}
		return new DecimalFormat(pattern.toString()).format(d);
	}
	
	public static boolean isTheSameDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
				&& (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& (c1.get(Calendar.DAY_OF_MONTH) == c2
						.get(Calendar.DAY_OF_MONTH));
	}
}