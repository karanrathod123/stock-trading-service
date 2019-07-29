package com.hcl.stocktrading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
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
			orderDetailsRepository.save(orderDetails);
			responseData.setData(orderDetails);
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Updated Stocks are as shown");
		}

		return responseData;
	}

}
