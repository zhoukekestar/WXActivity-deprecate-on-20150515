package com.otovc.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.otovc.system.SystemConfig;

public final class CommonValidate {

	public static void offset_pageSize_validate(int offset, int pageSize, Map put_target) {
		if (0 > offset) {
			offset = SystemConfig.DEFAULT_OFFSET;
		}

		if (1 > pageSize) {
			pageSize = SystemConfig.DEFAULT_PAGESIEZ;
		}

		if (null == put_target) {
			put_target = new HashMap();
		}

		put_target.put("offset", offset);
		put_target.put("pageSize", pageSize);
	}

	public static void start_end_time_validate(String starttime, String endtime, Map<String, Object> put_target) {
		// 时间字段校验: 简短时间
		Date st = DateUtils.string2date(starttime);
		Date et = DateUtils.string2date(endtime);

		if (null != st && null != et) {

			if (null == put_target) {
				put_target = new HashMap<String, Object>();
			}

			put_target.put("starttime", st);
			put_target.put("endtime", et);
		}

	}

	public static void start_end_time_validate(String starttimeName, String starttime, String endtimeName, String endtime,
			Map<String, Object> put_target) {
		// 时间字段校验: 简短时间
		Date st = DateUtils.string2date(starttime);
		Date et = DateUtils.string2date(endtime);

		if (null != st && null != et) {

			if (null == put_target) {
				put_target = new HashMap<String, Object>();
			}

			put_target.put(starttimeName, st);
			put_target.put(endtimeName, et);
		}

	}

	public static void map_destroy(Map map) {
		if (null != map) {
			map.clear();
			map = null;
		}
	}

	public static void list_destroy(List list) {

		if (null != list) {
			list.clear();
			list = null;
		}
	}

}
