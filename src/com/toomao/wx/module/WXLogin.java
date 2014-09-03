package com.toomao.wx.module;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.conf.Data;
import com.toomao.wx.model.conf.WXURL;

@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_module_WXLogin", urlPatterns="/WXLogin")
public class WXLogin extends HttpServlet {
	  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//将url地址以state的映射存放在data中
		String state =	UUID.randomUUID().toString().replaceAll("-", "");
		Data.saveURL(state, request.getParameter("url"));
		
		// 自动获取openid值，不需要用户授权
		String url = WXURL.Login(1, state, Data.URLLoginCallback);
		System.out.println("step1 Get: " + url);
		response.sendRedirect(url);
	}
}
