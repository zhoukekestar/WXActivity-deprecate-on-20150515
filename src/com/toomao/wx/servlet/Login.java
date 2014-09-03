package com.toomao.wx.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.conf.Data;
import com.toomao.wx.model.conf.WXURL;


@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_servlet_Login", urlPatterns="/wx_login")
public class Login extends HttpServlet {
	
	@Override
	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String state = UUID.randomUUID().toString().replaceAll("-", "");
		Data.saveURL(state, request.getParameter("redirect_uri"));

		String url = WXURL.Login(1, state, Data.URLLoginCallback);

		System.out.println("Get: " + url);
		response.sendRedirect(url);
	}
}
