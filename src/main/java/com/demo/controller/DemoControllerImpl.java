package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import com.demo.dto.DtoAccount;
import com.demo.dto.DtoBalance;
import com.demo.dto.DtoTransfer;
import com.demo.dto.DtoTransaction;
import com.demo.util.Validator;
import com.demo.dto.DtoResponseAccount;
import com.demo.service.IDemoService;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoControllerImpl implements IDemoController {

	@Autowired
	private IDemoService demoService;

	@Autowired
	private Validator validator;

	@Override
	@GetMapping("/accounts")
	public ResponseEntity<DtoResponseAccount> listAllAccounts() {
		DtoResponseAccount response = demoService.listAllAccounts();
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.noContent().build();
	}

	@Override
	@PostMapping("/createAccount")
	public ResponseEntity<DtoAccount> createAccount(@RequestBody final DtoAccount request) {
		DtoAccount response = null;
		if (request != null) 
			response = demoService.createAccount(request);
		if (response != null) 
			return ResponseEntity.status(HttpStatus.CREATED).build();
		return ResponseEntity.noContent().build();
	}
	
	@Override
	@PostMapping("/createTransfer")
	public ResponseEntity<DtoTransfer> createTransfer(@RequestBody final DtoTransfer request) {
		DtoTransfer response = null;
		if (request != null) {
			validator.validateAccount(request);
			response = demoService.createTransfer(request);
			return new ResponseEntity<DtoTransfer>(response, HttpStatus.CREATED);
		}
		return ResponseEntity.noContent().build();
	}

	@Override
	@GetMapping("/transfers")
	public ResponseEntity<List<DtoTransfer>> listTransfers() {
		List<DtoTransfer> response = demoService.listTransfers();
		return ResponseEntity.ok(response);
	}

	@Override
	@GetMapping("/transactions")
	public ResponseEntity<DtoTransaction> listAllTransactions() {
		DtoTransaction response = demoService.listAllTransactions();
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.noContent().build();
	}

	@Override
	@GetMapping("/send-transactions/{fromAccount}")
	public ResponseEntity<?> listAllSendTransactions(@PathVariable(name = "fromAccount") Long fromAccount) {
		DtoTransaction response = demoService.listAllSendTransactions(fromAccount);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@GetMapping("/recibe-transactions/{toAccount}")
	public ResponseEntity<?> listAllRecibeTransactions(@PathVariable(name = "toAccount") Long toAccount) {
		DtoTransaction response = demoService.listAllRecibeTransactions(toAccount);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@GetMapping("/balance/{account}")
	public ResponseEntity<DtoBalance> getBalance(@PathVariable(name = "account") Long account) {
		DtoBalance response = demoService.getBalance(account);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();	
	}
}