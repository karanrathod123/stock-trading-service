package com.hcl.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.repository.ConfirmOrderRepository;
import com.hcl.stocktrading.repository.StockRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	ConfirmOrderRepository confirmOrderRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto) {
		
		OrderDetails orderDetails = new OrderDetails();

		Stocks stocks = stockRepository.findByStockId(confirmOrderDto.getStockId());
		
		User user = userRepository.findByUserId(confirmOrderDto.getUserId());
		
		orderDetails.setStockId(stocks);
		orderDetails.setPurchasedVolume(confirmOrderDto.getPurchaseVolume());
		orderDetails.setUserId(user);
		
		
		return orderDetails; 
		
	}

	
	
}
