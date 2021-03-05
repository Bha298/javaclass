package com.JavaCampus.Utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	private final static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static java.sql.Date parsestrDateToSqlDate(String date) {
		try {
			return new Date(DATE_FORMAT.parse(date).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static java.sql.Timestamp parseTimestamp(String timestamp) {
		try {
			return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void main(String[] args) {

		String strDate = "2013-09-29";
		System.out.println("Sql Date:" + DateUtils.parsestrDateToSqlDate(strDate));
		
		String strTimeDate = "2020-05-01 12:30:00";
		System.out.println("Sql DateTime:" + DateUtils.parseTimestamp(strTimeDate));

	}

}
