package com.hcl.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.repository.ConfirmOrderRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	ConfirmOrderRepository confirmOrderRepository;
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto) {
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.set(confirmOrderDto.get);
		
		
		return orderDetails; 
		
	}

	
	
}
