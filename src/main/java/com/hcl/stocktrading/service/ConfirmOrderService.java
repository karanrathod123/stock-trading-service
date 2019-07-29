package com.hcl.stocktrading.service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.entity.OrderDetails;

public interface ConfirmOrderService {
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto);

}
