package com.hcl.stocktrading.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.repository.OrderDetailsRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderExecutionServiceImplTest {
	
	@InjectMocks
	private OrderExecutionServiceImpl orderExecutionServiceImpl;
	
	@Mock
	private OrderDetailsRepository orderDetailsRepository;
	
	private OrderDetails orderDetails;
	
	@Before
	public void setUp() {
		orderDetails = new OrderDetails();
		orderDetails.setOrderId(Long.valueOf(1));
	}
	
	@Test
	public void testExecuteOrder() {
		when(orderDetailsRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(orderDetails));
		assertNotNull(orderExecutionServiceImpl.executeOrder(Long.valueOf(1)));
	}
	
	@Test
	public void testCancelOrder() {
		when(orderDetailsRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(orderDetails));
		assertNotNull(orderExecutionServiceImpl.cancelOrder(Long.valueOf(1)));
	}
	
	@Test
	public void testExecuteOrderWhenOrderIdInvalid() {
		when(orderDetailsRepository.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		assertNotNull(orderExecutionServiceImpl.executeOrder(Long.valueOf(1)));
	}
	
	@Test
	public void testCancelOrderWhenOrderIdInvalid() {
		when(orderDetailsRepository.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		assertNotNull(orderExecutionServiceImpl.cancelOrder(Long.valueOf(1)));
	}

}
