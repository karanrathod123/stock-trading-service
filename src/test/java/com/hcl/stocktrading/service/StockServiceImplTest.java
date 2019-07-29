package com.hcl.stocktrading.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.repository.StocksRepository;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@InjectMocks
	private StockServiceImpl stockServiceImpl;
	
	@Mock
	private StocksRepository stocksRepository;
	
	private List<Stocks> stockList = new ArrayList<>();
	
	@Before
	public void setUp() {
		Stocks stock = new Stocks();
		stock.setStockId(1l);
		stock.setPrice(80.5);
		stockList.add(stock);
	}
	
	@Test
	public void testGetAllStocksForPostive() {
		when(stocksRepository.findAll()).thenReturn(stockList);
		ResponseData response = stockServiceImpl.getAllStocks();
		assertNotNull(response);
	}
	
	@Test
	public void testGetAllStocksForNegative() {
		when(stocksRepository.findAll()).thenReturn(null);
		ResponseData response = stockServiceImpl.getAllStocks();
		assertNotNull(response);
	}
}
