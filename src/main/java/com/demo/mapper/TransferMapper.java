package com.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

import com.demo.dto.DtoTransfer;
import com.demo.entity.Transfer;

@Mapper(componentModel = "spring",
	implementationPackage = "com.demo.mapper.impl")
public interface TransferMapper {

	@Mapping(source = "sentAt", target = "sentAt", qualifiedByName = "setTimestamp")
	Transfer mapToInner(DtoTransfer outer);

	@Mapping(source = "sentAt", target = "sentAt", qualifiedByName = "setTime")
	DtoTransfer mapToOuter(Transfer inner);

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