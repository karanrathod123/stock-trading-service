package com.hcl.stocktrading.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stocktrading.dto.ConfirmOrderDto;
import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.exception.ResourceNotFoundException;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.StocksRepository;
import com.hcl.stocktrading.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class ConfirmOrderServiceImplTest {
	
	@Mock
	OrderDetailsRepository orderDetailsRepository;
	
	@Mock
	StocksRepository stocksRepository;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	ConfirmOrderServiceImpl confirmOrderServiceImpl;
	
	Stocks stocks;
	User user;
	OrderDetails orderDetails;
	ConfirmOrderDto confirmOrderDto;
	List<OrderDetails> list;
	OrderHistoryDto orderHistoryDto;
	
	@Before
	public void setUp() throws Exception {
		confirmOrderDto = new ConfirmOrderDto();
		confirmOrderDto.setPurchaseVolume(100L);
		confirmOrderDto.setStockId(1L);
		confirmOrderDto.setUserId(1L);
		
		stocks = new Stocks();
		stocks.setPrice(1000.0);
		stocks.setStockId(1L);
		stocks.setStockName("SBI funds");
		stocks.setStockSymbol("SBI");
		stocks.setStockType("equity");
		stocks.setVolume(100L);
		
		user = new User();
		user.setEmail("simarkaur1295@gmail.com");
		user.setMobile("9422390512");
		user.setName("Harsimar Kaur");
		user.setUserId(1L);
		
		orderDetails = new OrderDetails();
		orderDetails.setPurchasedVolume(100L);
		orderDetails.setStatus(0);
		orderDetails.setStockId(stocks);
		orderDetails.setStockPurchasePrice(100000.0);
		orderDetails.setTotalAmount(100100.0);
		orderDetails.setUserId(user);
		orderDetails.setFees(100.00);
		orderDetails.setTimeOfTrade(LocalDate.now());
		
		list = new ArrayList<>();
		list.add(orderDetails);
		
		orderHistoryDto = new OrderHistoryDto();
		orderHistoryDto.setFees(100.00);
		orderHistoryDto.setOrderId(1L);
		orderHistoryDto.setPurchasedVolume(100L);
		orderHistoryDto.setStockPrice(1000.0);
		orderHistoryDto.setStockPurchasePrice(100000.0);
		orderHistoryDto.setTotalAmount(100100.0);
		
	}

	@Test
	public void testConfirmOrder() {
		Mockito.when(stocksRepository.findByStockId(1L)).thenReturn(stocks);
		Mockito.when(userRepository.findByUserId(1L)).thenReturn(user);
		
		ResponseData expected = confirmOrderServiceImpl.confirmOrder(confirmOrderDto);
		assertEquals(orderDetails, expected.getData());
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void testConfirmOrderStockIdNotFound() {
		confirmOrderServiceImpl.confirmOrder(confirmOrderDto);
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void testConfirmOrderUserIdNotFound() {
		confirmOrderServiceImpl.confirmOrder(confirmOrderDto);
	}

}
