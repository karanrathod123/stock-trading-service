package com.hcl.stocktrading.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ResponseData;

@RestController
public class OrderExecutionController {
	
	@PutMapping("/execute")
	public ResponseEntity<ResponseData> executeOrder(@RequestParam Long orderId){
		return null;
	}

}
