package com.toomao.wx.module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.conf.Data;
import com.toomao.wx.model.conf.WXURL;

@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_module_WXLogin2", urlPatterns="/WXLogin2")
public class WXLogin2 extends HttpServlet {
	  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//如果没有state，表明这是模块自访问
		String state =  request.getParameter("state");
			
		// 尝试让用户授权获取用户信息
		String url = WXURL.Login(2, state, Data.URLLoginCallback2);
		System.out.println("step2 Get:" + url);
		response.sendRedirect(url);
	}
}
