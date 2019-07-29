package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.HistoryServiceImpl;

@RestController
public class HistoryController {

	@Autowired
	HistoryServiceImpl historyServiceImpl;

	@GetMapping("/pastorders")
	public ResponseEntity<Object> getPastOrder(@RequestBody OrderHistoryDto orderHistoryDto) {
		ResponseData response = historyServiceImpl.getPastOrders(orderHistoryDto);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
<<<<<<< HEAD

}
=======
	
	
}
>>>>>>> 7a057dd8c84e91de66c5714ba5c3eb497a6e10ed
