package com.hcl.stocktrading.service;

import java.util.Optional;

import org.hibernate.type.OrderedSetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class HistoryServiceImpl {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public  ResponseData getPastOrders(OrderHistoryDto orderHistoryDto)
	{     
		ResponseData response=new ResponseData();
		Optional<User> user =userRepository.findById(orderHistoryDto.getUserId());
		
		if(!user.isPresent()) {
			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Wrong UserId");
			
		}
		
		return response;
		
		
	}
	
	
}
