package com.hcl.stocktrading.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.User;
import com.hcl.stocktrading.repository.UserRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData getPastOrders(Long userId) {
		ResponseData response = new ResponseData();
		Optional<User> userOptional = userRepository.findById(userId);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("The list of purchsded stuck");
			response.setData(user.getOrderDetails());
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Incorrect UserId");
		}
		return response;

	}
}
