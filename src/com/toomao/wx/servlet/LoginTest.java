package com.toomao.wx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.UserInfo;
import com.toomao.wx.model.conf.Data;


@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_servlet_LoginTest", urlPatterns="/wx_login_test")
public class LoginTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String redirect_url = request.getParameter("url");
		if (redirect_url == null || redirect_url.trim().isEmpty())
			redirect_url = Data.URLHome;
		UserInfo userInfo = new UserInfo();
		userInfo.nickname = "zkk";
		userInfo.headimgurl = "14234234";
		
		request.getSession().setAttribute("user", userInfo);
		request.getSession().setAttribute("login", "2");
		//request.setAttribute("login", "1");
		response.sendRedirect(redirect_url + "?logined");
	}
}
