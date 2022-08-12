package com.demo.service;

import java.util.List;

import com.demo.dto.DtoAccount;
import com.demo.dto.DtoBalance;
import com.demo.dto.DtoTransfer;
import com.demo.dto.DtoTransaction;
import com.demo.dto.DtoResponseAccount;

public interface IDemoService {

	DtoResponseAccount listAllAccounts();

	DtoAccount createAccount(DtoAccount request);
	
	DtoTransfer createTransfer(DtoTransfer request); 

	List<DtoTransfer> listTransfers(); 	

	DtoTransaction listAllTransactions();

	DtoTransaction listAllSendTransactions(Long fromAccount);

	DtoTransaction listAllRecibeTransactions(Long toAccount);

	DtoBalance getBalance(Long account);
}