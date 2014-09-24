package com.otovc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	// private static final SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static final SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date string2date(String time) {
		if (null == time || time.trim().equals("")) {
			return null;
		}

		Date date = null;
		try {

			date = smf.parse(time);

		} catch (Exception ignore) {
		}
		return date;
	}

}
