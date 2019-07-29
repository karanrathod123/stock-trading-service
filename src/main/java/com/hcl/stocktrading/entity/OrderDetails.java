package com.hcl.stocktrading.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderDetails {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@OneToOne
	private User userId;
	
	@OneToOne
	private Stocks stockId;
	
	private String status;
	
	private Long purchasedVolume;
	
	private Double fees;
	
	private Double stockPurchasePrice;
	
	private Double totalAmount;
	
	private LocalDate timeOfTrade;
}
