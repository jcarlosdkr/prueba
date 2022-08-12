package com.demo.dto;

import java.util.List;

import com.demo.dto.DtoAccount;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@JsonInclude(Include.NON_NULL)
public class DtoResponseAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DtoAccount> accounts;
	
}