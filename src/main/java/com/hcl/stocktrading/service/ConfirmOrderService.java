package com.hcl.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.exception.ResourceNotFoundException;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.StocksRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	OrderDetailsRepository confirmOrderRepository;
	
	@Autowired
	StocksRepository stocksRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto) {
		
		OrderDetails orderDetails = new OrderDetails();

		Stocks stocks = stocksRepository.findByStockId(confirmOrderDto.getStockId());
		
		User user = userRepository.findByUserId(confirmOrderDto.getUserId());
		
		orderDetails.setStockId(stocks);
		orderDetails.setPurchasedVolume(confirmOrderDto.getPurchaseVolume());
		orderDetails.setUserId(user);
		
		Double marketPrice = stocks.getPrice();
		
		if(confirmOrderDto.getPurchaseVolume()<500) {
			Double percentage = (marketPrice*0.10)/100;
			Double fees = percentage*confirmOrderDto.getPurchaseVolume();
			orderDetails.setFees(fees);
		}
		else if(confirmOrderDto.getPurchaseVolume()>=500) {
			Double percentage = (marketPrice*0.15)/100;
			Double per100Shares = confirmOrderDto.getPurchaseVolume()/100*1.0;
			Double fees = percentage*stocks.getPrice()*per100Shares;
			orderDetails.setFees(fees);
		}
		else {
			throw new ResourceNotFoundException("Please enter valid purchaseVolume");
		}
		
		orderDetails.getStatus();
		
		
		return orderDetails; 
		
	}

	
	
}
