package com.otovc.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.otovc.dao._BaseDao;
import com.otovc.dao.impl._BaseDaoImpl;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private _BaseDao baseDao = _BaseDaoImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");

		try {

			Method method = this.getClass().getMethod(methodName, new Class[] { HttpServletRequest.class, HttpServletResponse.class });

			method.invoke(this, new Object[] { request, response });

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// Put your code here
	}

}
