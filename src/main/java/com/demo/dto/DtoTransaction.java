package com.demo.dto;

import java.util.List;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@JsonInclude(Include.NON_NULL)
public class DtoTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DtoTransfer> transactions;

}