package com.otovc.utils;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.model.JSONValue;

public final class JsonUtils {

	private static JsonUtils jsonUtils;

	public static JsonUtils getInstance() {
		if (null == jsonUtils) {
			jsonUtils = new JsonUtils();
		}
		return jsonUtils;
	}
	
	public static String object2Json(Object obj) {
		
		try {
			JSONValue jsonValue = JSONMapper.toJSON(obj);
			
			String json = jsonValue.render(true);
			
			return json;
			
		} catch (MapperException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	private JsonUtils() {

	}

}
