package com.hcl.stocktrading.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Stocks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	private String stockName;
	private Double price;
	private Integer number;
	private String stockSymbol;
	private String stockType;

}
