package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.demo.constant.CartDetailStatus;
import com.example.demo.constant.UnitType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "UNIQUE_CART_AND_PRODUCT", columnNames = {"cart_id", "product_id"})})
public class CartDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cart cart;
	
	@Enumerated(EnumType.STRING)
	private CartDetailStatus status;
	
	@Enumerated(EnumType.STRING)
	private UnitType unit;
	
	private double quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Account account;
}
