package com.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@JsonInclude(Include.NON_NULL)
public class DtoAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long account;
	private Double balance;
	private Long owner;
	private String createdAt;

}