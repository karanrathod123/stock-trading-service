package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.service.QuoteService;

@RestController
@RequestMapping("/requote")
public class QuoteOrderController {

	@Autowired
	private QuoteService QuoteService;

	@PutMapping("/")
	public ResponseEntity<Object> quoteOrder(@RequestParam Long orderId) {
		return new ResponseEntity<Object>(QuoteService.quoteOrder(orderId), HttpStatus.OK);

	}
}
