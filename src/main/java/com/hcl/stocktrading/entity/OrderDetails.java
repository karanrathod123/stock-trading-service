package com.hcl.stocktrading.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class OrderDetails {
 
	private Long orderId;
	private User userId;
	private Stocks stockId;
	private String status;
	private Integer purchasedVolume;
	private Double fees;
	private Double stockPurchasePrice;
	private Double totalAmount;
	private LocalDate timeOfTrade;
}
