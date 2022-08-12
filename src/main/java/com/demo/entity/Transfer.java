package com.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_transfers")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Transfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "from_account")
	private Long fromAccount;
	@Column(name = "to_account")
	private Long toAccount;
	private Double amount;
	@Column(name = "date_at")
	private Timestamp sentAt;

	@PrePersist
  	private void createdAt(){ 
  		Long datetime = System.currentTimeMillis();
        this.sentAt = new Timestamp(datetime);
	}

}