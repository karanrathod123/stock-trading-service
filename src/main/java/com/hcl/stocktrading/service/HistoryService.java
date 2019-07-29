package com.hcl.stocktrading.service;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;

public interface HistoryService {

	public ResponseData getPastOrders(Long userId);
}
