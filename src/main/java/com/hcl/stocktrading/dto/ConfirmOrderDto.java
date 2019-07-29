package com.hcl.stocktrading.dto;

import lombok.Data;

@Data
public class ConfirmOrderDto {

	Long userId;
	Long stockId;
	Long purchaseVolume;
	
	
}
