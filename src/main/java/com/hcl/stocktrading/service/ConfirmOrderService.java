package com.hcl.stocktrading.service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.dto.ResponseData;

public interface ConfirmOrderService {
	
	public ResponseData confirmOrder(ConfirmOrderDto confirmOrderDto);

}
