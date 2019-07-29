package com.hcl.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.ConfirmOrderService;

@RestController
@RequestMapping("/")
public class ConfirmOrderController {

	@Autowired
	private ConfirmOrderService confirmOrderServiceImpl;
	
	@PostMapping()
	public ResponseEntity<ResponseData> confirmOrder(ConfirmOrderDto confirmOrderDto){
		return new ResponseEntity<>(confirmOrderServiceImpl.confirmOrder(confirmOrderDto) ,HttpStatus.OK);
	}
	
}
