package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Transfer;

@Repository
public interface IDemoTransferRepository extends JpaRepository<Transfer, Long> {

	List<Transfer> findAllByFromAccount(Long fromAccount);

	List<Transfer> findAllByToAccount(Long toAccount);
	
}