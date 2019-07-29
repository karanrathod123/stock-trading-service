package com.hcl.stocktrading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.QuoteOrderDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.repository.OrderDetailsRepository;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public ResponseData quoteOrder(Long orderId) {
		Optional<OrderDetails> ordeOptional = orderDetailsRepository.findById(orderId);
		ResponseData responseData = new ResponseData();
		if (ordeOptional.isPresent()) {
			OrderDetails orderDetails = ordeOptional.get();
			QuoteOrderDto quoteOrderDto = new QuoteOrderDto();
			quoteOrderDto.setFees(orderDetails.getFees());
			quoteOrderDto.setPurchaseVolume(orderDetails.getPurchasedVolume());
			quoteOrderDto.setTotalAmount(orderDetails.getTotalAmount());
			quoteOrderDto.setStockPurchasePrice(orderDetails.getStockPurchasePrice());
			quoteOrderDto.setOrderId(orderDetails.getOrderId());
			quoteOrderDto.setStockPrice(orderDetails.getStockId().getPrice());
			orderDetailsRepository.save(orderDetails);
			responseData.setData(quoteOrderDto);
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Updated Stocks are as shown");
		} else {
			responseData.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseData.setMessage("Incorrect order Id...! ");
		}

		return responseData;
	}

}
