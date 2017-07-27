package com.github.xbynet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateTimeUtil {
	
	public static String fmt(Date d){
		return getSDF().format(d);
	}
	public static Date parse(String str) throws ParseException{
		return getSDF().parse(str);
	}
	public static SimpleDateFormat getSDF(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf;
	}
	public static Date toDate(LocalDateTime ldt){
		ZoneOffset zoffset=OffsetDateTime.now().getOffset();
		Date d=Date.from(ldt.toInstant(zoffset));
		return d;
	}
	public static LocalDateTime toLDT(Date d){
		LocalDateTime ldt=LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
		return ldt;
	}
	/**
	 * 获取凌晨时刻00：00：00
	 * @param ldt
	 * @return
	 */
	public static Date getStartTimeOfDay(LocalDateTime ldt){
		LocalDateTime tmp=ldt.withHour(0).withMinute(0).withSecond(0);
		return toDate(tmp);
	}
	/**
	 * 获取一天结束时刻 23:59:59
	 * @return
	 */
	public static Date getEndTimeOfDay(LocalDateTime ldt){
		LocalDateTime tmp=ldt.withHour(23).withMinute(59).withSecond(59);
		return toDate(tmp);
	}
}