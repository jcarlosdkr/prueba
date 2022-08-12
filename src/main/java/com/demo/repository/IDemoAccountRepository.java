package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Account;

@Repository
public interface IDemoAccountRepository extends JpaRepository<Account, Long> {

	Account findByAccount(Long account);
	
}