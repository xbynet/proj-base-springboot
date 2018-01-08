package com.github.xbynet.mvc;

import com.github.xbynet.util.StringUtil;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

//@Component
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
