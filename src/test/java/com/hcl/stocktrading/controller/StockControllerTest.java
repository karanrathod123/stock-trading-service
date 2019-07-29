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
import com.hcl.stocktrading.service.HistoryServiceImpl;
import com.hcl.stocktrading.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

	@InjectMocks
	private StockController stockController;
	
	@Mock
	private StockServiceImpl stockServiceImpl;
	
	@Mock
	private HistoryServiceImpl historyServiceImpl;
	
	@Test
	public void testGetAllStocks() {
		when(stockServiceImpl.getAllStocks()).thenReturn(new ResponseData("", HttpStatus.ACCEPTED, ""));
		assertNotNull(stockController.getAllStocks());
	}
	
	@Test
	public void testGetPastOrders() {
		when(historyServiceImpl.getPastOrders(Long.valueOf(1))).thenReturn(new ResponseData("", HttpStatus.ACCEPTED, ""));
		assertNotNull(stockController.getPastOrder(Long.valueOf(1)));
	}
	

}
