package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "id")
	private Account account;
	
	private BigDecimal salary;
}
