package com.hcl.stocktrading.dto;

import com.hcl.stocktrading.entity.Stocks;

import lombok.Data;

@Data
public class OrderHistoryDto {

	private Long userId;
	private Long orderId;
	private Long stockId;
	private Double stockPurchasePrice;
	private double feesAmount;
	private Double totalAmount;
	private Integer purchasedVolume;
}
