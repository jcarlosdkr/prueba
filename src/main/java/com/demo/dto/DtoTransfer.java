package com.demo.dto;

import java.io.Serializable;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@JsonInclude(Include.NON_NULL)
public class DtoTransfer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fromAccount;
	private Long toAccount;
	private Double amount;
	private String sentAt;
	
}