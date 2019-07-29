package com.hcl.stocktrading.service;

import com.hcl.stocktrading.dto.ResponseData;

public interface QuoteService {

	public ResponseData quoteOrder(Long orderId);

}
