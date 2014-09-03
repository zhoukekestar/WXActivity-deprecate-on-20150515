package com.toomao.wx.module;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toomao.wx.model.UserAccessToken;
import com.toomao.wx.model.conf.WXURL;
import com.toomao.wx.utils.HttpRequest;
import com.toomao.wx.utils.Json;

@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_module_WXLoginCallback", urlPatterns="/WXLoginCallback")
public class WXLoginCallback extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		String url = WXURL.LoginCallback(code);
		String result = HttpRequest.get(url).body();
		UserAccessToken userAccessToken = (UserAccessToken)Json.Json2Object(result, UserAccessToken.class);
		
		request.getSession().setAttribute("openid", userAccessToken.openid);
		request.getSession().setAttribute("login", "11");
		
		response.sendRedirect("/WXActivity/WXLogin2?state=" + state);
	}

}
