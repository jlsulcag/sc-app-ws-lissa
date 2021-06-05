package com.sulcacorp.lissa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {

	/*Manejo de Fechas*/
	public static String parseDateToString(Date date, String format) {
		if(date != null) {
			SimpleDateFormat myFormat = new SimpleDateFormat(format);
			return myFormat.format(date);
		}
		return null;
	}
	
	public static Date parseStringToDate(String date, String format) {
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		Date data = null;
		try {
			if(StringUtils.isNoneBlank(date)) {
				data = myFormat.parse(date);
			}
		} catch (ParseException e) {
			log.error("Error al parsear la fecha : "+e.getMessage(), e);
		}
		return data;
	}
	
}
