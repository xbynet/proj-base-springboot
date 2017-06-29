package com.github.xbynet.mvc;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;

import com.github.xbynet.util.StringUtil;

public class TimestampConverter implements Converter<String, Timestamp>{

	@Override
	public Timestamp convert(String timeStr) {
		Timestamp t=null;
		if(StringUtil.checkNotEmpty(timeStr)){
			long time=Long.valueOf(timeStr);
			t=new Timestamp(time);
		}
		return t;
	}

}
