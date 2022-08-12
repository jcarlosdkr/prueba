package com.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

import com.demo.dto.DtoAccount;
import com.demo.entity.Account;

@Mapper(componentModel = "spring",
	implementationPackage = "com.demo.mapper.impl")
public interface AccountMapper {

	@Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "setTimestamp")
	Account mapToInner(DtoAccount outer);

	@Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "setTime")
	DtoAccount mapToOuter(Account inner);
	
	@Named("setTimestamp")
	public static Timestamp setTimestamp(final String dateTime) {
		Timestamp timestamp = null;
		try {
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSS");
    		Date parsedDate = dateFormat.parse(dateTime);
    		timestamp = new Timestamp(parsedDate.getTime());
		} catch(Exception e) {  
		}
		return timestamp;
	}

	@Named("setTime")
	public static String setTime(final Timestamp dateTime) {
		String date = null;
		if (dateTime != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.ms");
			date = dtf.format(dateTime.toLocalDateTime());
		}
		return date;
	}
}