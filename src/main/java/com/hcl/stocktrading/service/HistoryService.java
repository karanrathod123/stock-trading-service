package com.hcl.stocktrading.service;

import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;


public interface HistoryService {

	public ResponseData getPastOrders(OrderHistoryDto orderHistoryDto);
}
