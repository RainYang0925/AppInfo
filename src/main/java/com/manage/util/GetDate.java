package com.manage.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.annotations.Test;

/**
 * 得到日期
 * @author sun
 *
 */
public class GetDate {
	private SimpleDateFormat format;	
	private Calendar cal;
	
	public GetDate() {
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public String getToday() {
		cal = Calendar.getInstance();
		return format.format(cal.getTime());
	}
	
	public String getYesterday() {
		cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return format.format(cal.getTime());
	}
	
	public String getWeek() {
		cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -7);
		return format.format(cal.getTime());
	}
	
	public String getMonth() {
		cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		return format.format(cal.getTime());
	}
	
	@Test
	public void f() {
		System.out.println("今天：" + getToday());
		System.out.println("昨天：" + getYesterday());
		System.out.println("一周前：" + getWeek());
		System.out.println("一月前：" + getMonth());
	}
}
