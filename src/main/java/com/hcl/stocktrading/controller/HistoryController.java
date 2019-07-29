package com.hcl.stocktrading.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.User;

@RestController
public class HistoryController {

	@RequestMapping("/pastorders")
	public ResponseEntity<Object> getPastOrder(@RequestBody OrderHistoryDto orderHistoryDto )
	{
		ResponseData response=new ResponseData();
	
		return null;
		
		
	}
	
	
}
