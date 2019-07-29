package com.hcl.stocktrading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Stocks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	
	private String stockName;
	
	private Double price;
	
	private Long volume;
	
	private String stockSymbol;
	
	private String stockType;

	@OneToOne(mappedBy = "stockId")
	@JsonIgnore
	private OrderDetails orderDetails;
}
