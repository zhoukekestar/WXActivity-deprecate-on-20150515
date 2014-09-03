package com.toomao.wx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_servlet_Login", urlPatterns="/wx_getopenid")
public class GetOpenID extends HttpServlet {
	
	@Override
	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
