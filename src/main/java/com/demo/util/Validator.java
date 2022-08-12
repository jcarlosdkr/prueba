package com.demo.util;

import com.demo.dto.DtoTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Component;
import org.apache.commons.collections4.CollectionUtils;

@Component
public class Validator {
	
	public void validateAccount(DtoTransfer transfer) {
		if (transfer != null) {
			if (transfer.getFromAccount() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fromAccount must not be null");
			}
			if (transfer.getToAccount() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "toAccount must not be null");
			}
			if (transfer.getAmount() != null) {
				if (transfer.getAmount() <= 0) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "amount must be greater than 0"); 
				}
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "amount must not be null");
			}
		}
	} 

}