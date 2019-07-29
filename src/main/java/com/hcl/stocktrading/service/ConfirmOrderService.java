package com.hcl.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.StocksRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	OrderDetailsRepository confirmOrderRepository;
	
	@Autowired
	StocksRepository stockRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto) {
		
		OrderDetails orderDetails = new OrderDetails();
		
		
		return orderDetails; 
		
	}

	
	
}
