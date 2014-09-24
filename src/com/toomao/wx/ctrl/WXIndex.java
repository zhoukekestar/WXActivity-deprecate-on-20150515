package com.toomao.wx.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(name="com_toomao_wx_ctrl_WXIndex", urlPatterns="/index")
public class WXIndex extends HttpServlet {
	  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = (String)request.getSession().getAttribute("login");
		String id = (String)request.getParameter("id");

		if (null == login || login.trim().isEmpty())
		{
			//未登陆的情况下，跳转至login登陆
			System.out.println("login....");
			request.getSession().setAttribute("login", "1");
			response.sendRedirect("/WXActivity/index");
			return;
		}
		else if (null == id || id.trim().isEmpty())
		{
			//根据openid获取id值
			String openid = (String)request.getSession().getAttribute("openid");
			response.sendRedirect("/WXActivity/index?id=" + getIDbyopenid(openid));
			return;
		}
		else
		{
			String openid = (String)request.getSession().getAttribute("openid");
			//判断id时候和openid对应
			if (id.equals(getIDbyopenid(openid)))
			{
				System.out.println("my activity");
				request.getRequestDispatcher("/me.jsp").forward(request, response);
			}
			else
			{
				String myOpenId = getOpenIDbyID(id);
				String friendOpenId = (String)request.getSession().getAttribute("openid");
				
				
				System.out.println("friend activity");
				request.getRequestDispatcher("/friend.jsp").forward(request, response);
			}
		}
			
		
	}
	
	public static String getIDbyopenid(String openid)
	{
		return "11111";
	}
	
	public static String getOpenIDbyID(String id)
	{
		return "axxxaa";
	}
}
