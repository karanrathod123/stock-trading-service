package com.hcl.stocktrading.service;

import com.hcl.stocktrading.dto.ResponseData;

public interface OrderExecutionService {
	
	public ResponseData executeOrder(Long orderId);
	
	public ResponseData cancelOrder(Long orderId);

}
