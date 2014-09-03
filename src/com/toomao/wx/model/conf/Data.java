package com.toomao.wx.model.conf;

import java.util.HashMap;
import java.util.Map;

import com.toomao.wx.model.AccossToken;
import com.toomao.wx.model.Menu;

public class Data {
	//public
	public static String Token 				= "wxac##.123";
	
	public static String URLHome			= "/WXActivity/index.jsp";
	public static String URLToken			= "http://zhoukekestar.oicp.net/WXActivity/wx";
	public static String URLLoginCallback 	= "http://zhoukekestar.oicp.net/WXActivity/WXLoginCallback";
	public static String URLLoginCallback2 	= "http://zhoukekestar.oicp.net/WXActivity/WXLoginCallback2";
	
	public static String appID 				= "wx7d7b73a6b545f4d4";
	public static String appsecret 			= "e3ececf744f04f0eea10a15939388e21";
	public static String access_token 		= "";
	public static String menu 				= "";
	
	private static Map<String, String> stateMap = new HashMap<String, String>();
	
	public static String getAccess_token() {
		return AccossToken.get();
	}
	public static void setAccess_token(String access_token) {
		Data.access_token = access_token;
	}
	
	
	public static String getMenu() {
		return Data.menu;
	}
	public static void setMenu(String menu) {
		Data.menu = menu;
		Menu.set();
	}
	
	public static void saveURL(String key, String value)
	{
		if (null == value || value.trim().isEmpty())
			value = Data.URLHome;
		stateMap.put(key, value);
	}
	public static String getURL(String key)
	{
		try {
			String value = stateMap.get(key);
			stateMap.remove(key);
			if (null == value || value.trim().isEmpty())
				value = Data.URLHome;
			
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Data.URLHome;
	}
	
}
