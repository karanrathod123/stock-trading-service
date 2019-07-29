package com.hcl.stocktrading.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.enumeration.OrderStatus;
import com.hcl.stocktrading.exception.ResourceNotFoundException;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.StocksRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	StocksRepository stocksRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public OrderDetails confirmOrder(ConfirmOrderDto confirmOrderDto) {
		
		OrderDetails orderDetails = new OrderDetails();

		Stocks stocks = stocksRepository.findByStockId(confirmOrderDto.getStockId());
		if(null == stocks) {
			throw new ResourceNotFoundException("Stock doesn't found for stock id: "+ confirmOrderDto.getStockId());
		}
		
		User user = userRepository.findByUserId(confirmOrderDto.getUserId());
		if(null == user) {
			throw new ResourceNotFoundException("User doesn't found for user id: "+ confirmOrderDto.getUserId());
		}
		
		orderDetails.setStockId(stocks);
		orderDetails.setPurchasedVolume(confirmOrderDto.getPurchaseVolume());
		orderDetails.setUserId(user);
		
		Double marketPrice = stocks.getPrice();
		Double fees= 0.0 ; 
		
		if(confirmOrderDto.getPurchaseVolume()<500) {
			Double percentage = (marketPrice*0.10)/100;
			fees = percentage*confirmOrderDto.getPurchaseVolume();
			orderDetails.setFees(fees);
		}
		else if(confirmOrderDto.getPurchaseVolume()>=500) {
			Double percentage = (marketPrice*0.15)/100;
			Double per100Shares = confirmOrderDto.getPurchaseVolume()/100*1.0;
			fees = percentage*stocks.getPrice()*per100Shares;
			orderDetails.setFees(fees);
		}
		else {
			throw new ResourceNotFoundException("Please enter valid purchaseVolume");
		}
		
		orderDetails.setStatus(OrderStatus.PENDING.getStatus());
		Double stockPurchasePrice = marketPrice*confirmOrderDto.getPurchaseVolume();
		orderDetails.setStockPurchasePrice(stockPurchasePrice);
		orderDetails.setTotalAmount(fees+stockPurchasePrice);
		orderDetails.setTimeOfTrade(LocalDate.now());
		
		orderDetailsRepository.save(orderDetails);
		
		ResponseData responseData = new ResponseData();
		responseData.setData(orderDetails);
		responseData.setHttpStatus(HttpStatus.OK);
		return orderDetails; 
		
	}
	
}
