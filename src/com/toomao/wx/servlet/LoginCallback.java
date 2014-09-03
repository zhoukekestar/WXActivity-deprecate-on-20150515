package com.toomao.wx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toomao.wx.model.UserAccessToken;
import com.toomao.wx.model.UserInfo;
import com.toomao.wx.model.conf.Data;
import com.toomao.wx.model.conf.WXURL;
import com.toomao.wx.utils.HttpRequest;
import com.toomao.wx.utils.Json;


@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_servlet_LoginCallback", urlPatterns="/wx_login_callback")
public class LoginCallback extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = WXURL.LoginCallback(request.getParameter("code"));
		String redirect_url = Data.getURL(request.getParameter("state"));
		
		//获取appid和token
		String result = HttpRequest.get(url).body();
		try {
			UserAccessToken userAccessToken = (UserAccessToken)Json.Json2Object(result, UserAccessToken.class);
			
			url = WXURL.UserInfo(userAccessToken);
			//根据appid和token 获取用户信息
			result = HttpRequest.get(url).body();
			UserInfo userInfo = (UserInfo)Json.Json2Object(result, UserInfo.class);
			
			//设置请求，返回
			request.getSession().setAttribute("login", "2");
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("login", "1");
			
			response.sendRedirect(redirect_url);
		} catch (Exception e) {
			e.printStackTrace();
			
			PrintWriter pw =  response.getWriter();
			pw.write("服务器内部错误，请稍后重试");
			pw.flush();
			pw.close();
		}
		
		
		
		
		/*
		url = "https://api.weixin.qq.com/sns/userinfo?"
		+"access_token="+ userAccessToken.access_token
		+"&openid="+ userAccessToken.openid
		+"&lang=zh_CN";
		
		result = HttpRequest.get(url).body();
		
		UserInfo userInfo = (UserInfo)Json.Json2Object(result, UserInfo.class);
		
		
		request.setAttribute("result", result);
		request.setAttribute("userinfo", userInfo);
		request.getRequestDispatcher("login-by-wx-after.jsp").forward(request, response);*/
	}
}
