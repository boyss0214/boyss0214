package com.money.financing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;



public class DateUtils {

	Logger logger = Logger.getLogger(getClass());
	/**
	 * 按照format格式将日期格式化
	 * @param date 日期
	 * @param pattem 日期格式
	 * @return
	 */
	public static String formatDateToStr(Date date,String pattem){
		SimpleDateFormat dateformat = new SimpleDateFormat(pattem);
		return dateformat.format(date);
	}

	/**
	 * 将日期字符串格式化为日期类型
	 * @param dateTimeStr 日期字符串
	 * @param pattem 日期格式
	 * @return
	 */
	public static Date formatStrToDate(String dateTimeStr,String pattem){
		SimpleDateFormat dateformat = new SimpleDateFormat(pattem);
		Date d = null;
		try {
			d = dateformat.parse(dateTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
}
