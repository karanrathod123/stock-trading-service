package com.hcl.stocktrading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.repository.OrderDetailsRepository;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class HistoryServiceImpl {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private UserRepository userRepository;
<<<<<<< HEAD

	public ResponseData getPastOrders(OrderHistoryDto orderHistoryDto) {
		ResponseData response = new ResponseData();
		Optional<User> userOptional = userRepository.findById(orderHistoryDto.getUserId());

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("The list of purchsded stuck");
			response.setData(user.getOrderDetails());
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Incorrect UserId");
=======
	
	public  ResponseData getPastOrders(OrderHistoryDto orderHistoryDto)
	{     
		ResponseData response=new ResponseData();
		Optional<User> user =userRepository.findById(orderHistoryDto.getUserId());
		
		if(!user.isPresent()) {
			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Wrong UserId");
			
>>>>>>> 7a057dd8c84e91de66c5714ba5c3eb497a6e10ed
		}
		return response;
	}
<<<<<<< HEAD

}
=======
		
}
>>>>>>> 7a057dd8c84e91de66c5714ba5c3eb497a6e10ed
