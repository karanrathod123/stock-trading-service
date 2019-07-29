package com.hcl.stocktrading.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.service.OrderExecutionService;


@RunWith(MockitoJUnitRunner.class)
public class OrderExecutionControllerTest {

	@InjectMocks
	private OrderExecutionController orderExecutionController;
	
	@Mock
	private OrderExecutionService executionService;
	
	@Test
	public void testExecuteOrder() {
		when(executionService.executeOrder(Long.valueOf(1))).thenReturn(new ResponseData("",HttpStatus.ACCEPTED, null));
		assertNotNull(orderExecutionController.executeOrder(Long.valueOf(1)));	
	}
	
	@Test
	public void testCancelOrder() {
		when(executionService.executeOrder(Long.valueOf(1))).thenReturn(new ResponseData("",HttpStatus.ACCEPTED, null));
		assertNotNull(orderExecutionController.executeOrder(Long.valueOf(1)));	
	}
	
}
