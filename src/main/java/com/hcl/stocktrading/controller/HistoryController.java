package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.HistoryService;

@RestController
public class HistoryController {

	@Autowired
	private HistoryService historyServiceImpl;

	@GetMapping("/pastorders")
	public ResponseEntity<Object> getPastOrder(@RequestParam Long userId) {
		ResponseData response = historyServiceImpl.getPastOrders(userId);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}
