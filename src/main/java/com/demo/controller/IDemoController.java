package com.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.dto.DtoAccount;
import com.demo.dto.DtoBalance;
import com.demo.dto.DtoTransfer;
import com.demo.dto.DtoTransaction;
import com.demo.dto.DtoResponseAccount;

public interface IDemoController {

	ResponseEntity<DtoResponseAccount> listAllAccounts();

	ResponseEntity<DtoAccount> createAccount(DtoAccount request);
	
	ResponseEntity<DtoTransfer> createTransfer(DtoTransfer request);

	ResponseEntity<List<DtoTransfer>> listTransfers();

	ResponseEntity<DtoTransaction> listAllTransactions();

	ResponseEntity<?> listAllSendTransactions(Long fromAccount);

	ResponseEntity<?> listAllRecibeTransactions(Long fromAccount);

	ResponseEntity<DtoBalance> getBalance(Long account);
}