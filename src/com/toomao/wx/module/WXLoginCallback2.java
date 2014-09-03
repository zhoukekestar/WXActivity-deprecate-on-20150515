package com.toomao.wx.module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.UserAccessToken;
import com.toomao.wx.model.UserInfo;
import com.toomao.wx.model.conf.Data;
import com.toomao.wx.model.conf.WXURL;
import com.toomao.wx.utils.HttpRequest;
import com.toomao.wx.utils.Json;

@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_module_WXLoginCallback2", urlPatterns="/WXLoginCallback2")
public class WXLoginCallback2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String state = request.getParameter("state");
		try
		{
			String code = request.getParameter("code");
			
			String url = WXURL.LoginCallback(code);
			String result = HttpRequest.get(url).body();
			UserAccessToken userAccessToken = (UserAccessToken)Json.Json2Object(result, UserAccessToken.class);
			
			url = WXURL.UserInfo(userAccessToken);
			result = HttpRequest.get(url).body();
			UserInfo userInfo = (UserInfo)Json.Json2Object(result, UserInfo.class);
			
			request.getSession().setAttribute("user", userInfo);
			request.getSession().setAttribute("login", "12");
			
			response.sendRedirect(Data.getURL(state));
		}
		catch (Exception e)
		{
			response.sendRedirect(Data.getURL(state));
		}
	}

}
