package com.toomao.wx.model.conf;

import java.util.UUID;


public class App {
	public static void main(String[] args) {
		 String body =
		 "{\"button\": [{ \"type\": \"click\", \"name\": \"公司简介\",  \"key\": \"V1001_TODAY_MUSIC\"},{ \"type\": \"view\", \"name\": \"产品介绍\",  \"url\": \"http://zhoukekestar.oicp.net/WXActivity/index2.jsp\"},{ \"type\": \"view\", \"name\": \"大礼包\",  \"url\": \"http://zhoukekestar.oicp.net/WXActivity/index.jsp\"}]}";
		 //System.out.println(Data.getAccess_token());
		 
		 
		 
		//String str = null;
		//System.out.println(str.isEmpty());
		 
		 Data.setMenu(body);
		// System.out.println(MMenu.set(body));
		// System.out.println(HttpRequest.get("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
		// + Data.access_token).body());
	}
}
