package com.xx.abel.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xx.abel.bean.Users;

public class LoginedCheckInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoginedCheckInterceptor.class);
	public String intercept(ActionInvocation ai) throws Exception {
//
		String url = ServletActionContext.getRequest().getRequestURL()
				.toString();
		logger.debug(" URL intercept start===URL：" + url);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		Users user = null;

		if (url.indexOf("users_login.action") != -1 || url.indexOf("logout.action") != -1 || url.indexOf("users_nameOremail.action") != -1 || url.indexOf("users_save.action") != -1) {
			return ai.invoke();
		}else {
			if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {
				System.out.println(url);
				return "tologin";
			} else {
				user = (Users) ServletActionContext.getRequest().getSession()
						.getAttribute("user");
				if (user == null) {
					System.out.println(url);
					return "tologin";
				} else {
					return ai.invoke();
				}
			}

		}
		
	}

}