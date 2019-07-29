package com.hcl.stocktrading.dto;

import lombok.Data;

@Data
public class OrderHistoryDto {

	private Long orderId;
	private Double stockPrice;
	private Double stockPurchasePrice;
	private Double fees;
	private Double totalAmount;
	private Long purchasedVolume;
}
