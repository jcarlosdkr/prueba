package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.demo.repository.IDemoAccountRepository;
import com.demo.repository.IDemoTransferRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.AccountMapper;
import com.demo.mapper.TransferMapper;
import com.demo.dto.DtoResponseAccount;
import com.demo.dto.DtoAccount;
import com.demo.dto.DtoBalance;
import com.demo.dto.DtoTransfer;
import com.demo.dto.DtoTransaction;
import com.demo.entity.Account;
import com.demo.entity.Transfer;

@Service
public class DemoServiceImpl implements IDemoService {

	@Autowired
	private IDemoAccountRepository demoAccountRepository;

	@Autowired
	private IDemoTransferRepository demoTransferRepository;

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private TransferMapper transferMapper;

	@Override
	public DtoResponseAccount listAllAccounts() {
		List<Account> responseAccounts = demoAccountRepository.findAll();
		final List<DtoAccount> accounts = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(responseAccounts)) {
			responseAccounts.stream().forEach(item -> accounts.add(accountMapper.mapToOuter(item)));
		} else {
			return null;
		}
		DtoResponseAccount response = new DtoResponseAccount();
		response.setAccounts(accounts);
		return response;
	}

	@Override
	public DtoAccount createAccount(DtoAccount request) {
		Account accountDB = null;
		if (request.getAccount() != null) {
			accountDB = demoAccountRepository.findByAccount(request.getAccount());
		} 
		if (accountDB != null) {
			return accountMapper.mapToOuter(accountDB);
		}
		return accountMapper.mapToOuter(demoAccountRepository.save(accountMapper.mapToInner(request)));
	}
	
	@Override
	public DtoTransfer createTransfer(DtoTransfer request) {
		updateAccount(request);
		return transferMapper.mapToOuter(demoTransferRepository.save(transferMapper.mapToInner(request)));
	}

	@Override
	public List<DtoTransfer> listTransfers() {
		List<Transfer> transfers = demoTransferRepository.findAll();
		final List<DtoTransfer> response = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(transfers)) {
			transfers.stream().forEach(item -> response.add(transferMapper.mapToOuter(item)));
		}
		return response;
	}

	@Override
	public DtoTransaction listAllTransactions() {
		DtoTransaction transaction = null;
		List<Transfer> transfers = demoTransferRepository.findAll();
		List<DtoTransfer> response = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(transfers)) {
			transfers.stream().forEach(item -> response.add(transferMapper.mapToOuter(item)));
		}
		if (CollectionUtils.isNotEmpty(response)){
			transaction = new DtoTransaction();
			transaction.setTransactions(response);
		}
		return transaction;
	}

	@Override
	public DtoTransaction listAllSendTransactions(Long fromAccount) {
		DtoTransaction transaction = null;
		List<Transfer> transfers = demoTransferRepository.findAllByFromAccount(fromAccount);
		List<DtoTransfer> response = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(transfers)) {
			transfers.stream().forEach(item -> response.add(transferMapper.mapToOuter(item)));
		}
		if (CollectionUtils.isNotEmpty(response)){
			transaction = new DtoTransaction();
			transaction.setTransactions(response);
		}
		return transaction;
	}

	@Override
	public DtoTransaction listAllRecibeTransactions(Long toAccount) {
		DtoTransaction transaction = null;
		List<Transfer> transfers = demoTransferRepository.findAllByToAccount(toAccount);
		List<DtoTransfer> response = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(transfers)) {
			transfers.stream().forEach(item -> response.add(transferMapper.mapToOuter(item)));
		}
		if (CollectionUtils.isNotEmpty(response)){
			transaction = new DtoTransaction();
			transaction.setTransactions(response);
		}
		return transaction;
	}

	@Override
	public DtoBalance getBalance(Long account) {
		DtoBalance response = null;
		Account accountDB = null;
		if (account != null) {
			accountDB = demoAccountRepository.findByAccount(account);
		} 
		if (accountDB != null) {
			response = new DtoBalance();
			response.setBalance(accountMapper.mapToOuter(accountDB));
		}

		return response;
	}

	private void updateAccount(final DtoTransfer transfer) {
		Account accountMinus = demoAccountRepository.findByAccount(transfer.getFromAccount());
		validateExistAccount(accountMinus, "fromAccount does not exist.");
		Account accountPlus = demoAccountRepository.findByAccount(transfer.getToAccount());
		validateExistAccount(accountPlus, "toAccount does not exist.");
		Double amount = null;
		if (accountMinus.getBalance() > 0) {
			amount = accountMinus.getBalance() - transfer.getAmount();
			if (amount <= 0) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This operation cannot be performed, insufficient balance.");
			}
			accountMinus.setBalance(amount);
			demoAccountRepository.save(accountMinus);
		}  
		accountPlus.setBalance(accountPlus.getBalance() + transfer.getAmount());
		demoAccountRepository.save(accountPlus);
	}

	private void validateExistAccount(Account account, String message) {
		if (account == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
		}
	}
}