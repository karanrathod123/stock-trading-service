package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockServiceimpl;
	
	@GetMapping("/stocks")
	public ResponseEntity<Object> getAllStocks(){
		ResponseData response = stockServiceimpl.getAllStocks();
		return new ResponseEntity<>(response,response.getHttpStatus());		
	}
}
