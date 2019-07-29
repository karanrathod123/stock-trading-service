package com.hcl.stocktrading.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.repository.OrderDetailsRepository;

@RunWith(MockitoJUnitRunner.class)
public class QuoteServiceImplTest {

	@InjectMocks
	private QuoteServiceImpl quoteServiceImpl;

	@Mock
	private OrderDetailsRepository orderDetailsRepository;

	private OrderDetails orderDetails = new OrderDetails();

	@Before
	public void setUp() {
		orderDetails.setOrderId(1l);
		orderDetails.setFees(2334.00);
		orderDetails.setStockId(new Stocks());

	}

	@Test
	public void quoteOrder() {
		Mockito.when(orderDetailsRepository.findById(1l)).thenReturn(Optional.of(orderDetails));
		Mockito.when(orderDetailsRepository.save(Mockito.any())).thenReturn(orderDetails);
		ResponseData response = quoteServiceImpl.quoteOrder(1l);
		assertNotNull(response);
	}

	@Test
	public void quoteOrderNegative() {
		Mockito.when(orderDetailsRepository.findById(1l)).thenReturn(Optional.empty());
		ResponseData response = quoteServiceImpl.quoteOrder(1l);
		assertNotNull(response);
	}

}
