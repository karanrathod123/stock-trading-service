package com.hcl.stocktrading.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceImplTest {
	
	@InjectMocks
	private HistoryServiceImpl historyServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	private User user;
	
	private OrderDetails orderDetails;
	
	private List<OrderDetails> orderDetailsList;
	
	private Stocks stock;
	
	
	@Before
	public void setUp() {
		user = new User();
		user.setUserId(Long.valueOf(1));
		
		orderDetails = new OrderDetails();
		orderDetails.setOrderId(Long.valueOf(1));
		orderDetailsList = new ArrayList<OrderDetails>();
		orderDetailsList.add(orderDetails);
		user.setOrderDetails(orderDetailsList);
		
		stock = new Stocks();
		stock.setStockId(Long.valueOf(1));
		stock.setPrice(Double.valueOf(100));
		
		orderDetails.setStockId(stock);
	}
	
	@Test
	public void testPastOrder() {
		when(userRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(user));
		assertNotNull(historyServiceImpl.getPastOrders(Long.valueOf(1)));
	}
	
	@Test
	public void testPastOrderInvalidUserId() {
		when(userRepository.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		assertNotNull(historyServiceImpl.getPastOrders(Long.valueOf(1)));
	}

}
