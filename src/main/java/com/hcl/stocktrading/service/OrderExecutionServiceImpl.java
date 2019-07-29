package com.hcl.stocktrading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.enumeration.OrderStatus;
import com.hcl.stocktrading.repository.OrderDetailsRepository;

@Service
public class OrderExecutionServiceImpl implements OrderExecutionService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Override
	public ResponseData executeOrder(Long orderId) {
		ResponseData responseData = new ResponseData();
		Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findById(orderId);
		if (orderDetailsOptional.isPresent()) {
			OrderDetails details = orderDetailsOptional.get();
			details.setStatus(OrderStatus.EXECUTED.getStatus());
			orderDetailsRepository.save(details);

			responseData.setData(null);
			responseData.setMessage("Order Executed Succesfully");
			responseData.setHttpStatus(HttpStatus.ACCEPTED);
			return responseData;
		}
		responseData.setData(null);
		responseData.setHttpStatus(HttpStatus.NOT_FOUND);
		responseData.setMessage("Invalid Order ID");
		return responseData;
	}

	@Override
	public ResponseData cancelOrder(Long orderId) {
		ResponseData responseData = new ResponseData();
		Optional<OrderDetails> orderDetailsOptional = orderDetailsRepository.findById(orderId);
		if (orderDetailsOptional.isPresent()) {
			orderDetailsRepository.deleteById(orderId);
			responseData.setData(null);
			responseData.setMessage("Order Deleted Succesfully");
			responseData.setHttpStatus(HttpStatus.ACCEPTED);
			return responseData;
		}
		responseData.setData(null);
		responseData.setHttpStatus(HttpStatus.NOT_FOUND);
		responseData.setMessage("Invalid Order ID");
		return responseData;
	}

}
