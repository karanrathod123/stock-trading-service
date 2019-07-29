package com.hcl.stocktrading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.OrderDetails;
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
			List<OrderDetails> orderDetails = user.getOrderDetails();
			List<OrderHistoryDto> historyDto = new ArrayList<>();

			orderDetails.stream().filter(order -> order.getStatus() != 0).forEach(order -> {
				OrderHistoryDto orderDto = new OrderHistoryDto();
				orderDto.setOrderId(order.getOrderId());
				orderDto.setStockPrice(order.getStockId().getPrice());
				orderDto.setFees(order.getFees());
				orderDto.setPurchasedVolume(order.getPurchasedVolume());
				orderDto.setTotalAmount(order.getTotalAmount());
				orderDto.setStockPurchasePrice(order.getStockPurchasePrice());
				historyDto.add(orderDto);
			});
			
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("The list of purchsded stock");
			response.setData(historyDto);
		} else {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Incorrect UserId");
		}
		return response;

	}
}
