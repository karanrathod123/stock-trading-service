package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.HistoryService;
import com.hcl.stocktrading.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockServiceimpl;
	
	@Autowired
	private HistoryService historyServiceImpl;
	
	@GetMapping("/stocks")
	public ResponseEntity<Object> getAllStocks(){
		ResponseData response = stockServiceimpl.getAllStocks();
		return new ResponseEntity<>(response,response.getHttpStatus());		
	}

	@GetMapping("/pastorders")
	public ResponseEntity<Object> getPastOrder(@RequestParam Long userId) {
		ResponseData response = historyServiceImpl.getPastOrders(userId);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
}
