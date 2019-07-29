package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.OrderExecutionService;

@RestController
public class OrderExecutionController {
	
	@Autowired
	private OrderExecutionService orderExecutionService;
	
	@PutMapping("/execute")
	public ResponseEntity<ResponseData> executeOrder(@RequestParam Long orderId){
		ResponseData responseData = orderExecutionService.executeOrder(orderId);
		return new ResponseEntity<>(responseData, responseData.getHttpStatus());
	}
	
	@DeleteMapping("/execute")
	public ResponseEntity<ResponseData> cancelOrder(@RequestParam Long orderId){
		ResponseData responseData = orderExecutionService.cancelOrder(orderId);
		return new ResponseEntity<>(responseData, responseData.getHttpStatus());
	}

}
