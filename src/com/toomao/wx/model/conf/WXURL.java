package com.toomao.wx.model.conf;

import java.net.URLEncoder;

import com.toomao.wx.model.UserAccessToken;
import com.toomao.wx.utils.HttpRequest.HttpRequestException;

public class WXURL {
	 /**
	   * return wx's login api url
	   *
	   * @param scopeid 1->snsapi_base  2->snsapi_userinfo
	   * @return string
	   */
	public static String Login(int scopeid, String state, String callback)
	{
		String scope = "snsapi_base";
		if (scopeid != 1)
			scope = "snsapi_userinfo";
		return "https://open.weixin.qq.com/connect/oauth2/authorize?"
				+ "appid=" + Data.appID
				+ "&redirect_uri=" + URLEncoder.encode(callback)
				+ "&response_type=" + "code"
				+ "&scope=" + scope
				+ "&state=" + state
				+ "#wechat_redirect";
	}
	
	public static String LoginCallback(String code)
	{
		return "https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid=" + Data.appID
				+ "&secret="+Data.appsecret
				+ "&code="+code
				+ "&grant_type=authorization_code";
	}
	
	public static String UserInfo(UserAccessToken uToken)
	{
		return "https://api.weixin.qq.com/sns/userinfo?"
				+"access_token="+ uToken.access_token
				+"&openid="+ uToken.openid
				+"&lang=zh_CN";
	}
}
