package com.hcl.stocktrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.stocktrading.dto.ResponseData;
import com.hcl.stocktrading.entity.Stocks;
import com.hcl.stocktrading.repository.StocksRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StocksRepository stocksRepository;

	@Override
	public ResponseData getAllStocks() {
		List<Stocks> stocks = stocksRepository.findAll();
		ResponseData response = new ResponseData();
		if (ObjectUtils.isEmpty(stocks)) {
			response.setHttpStatus(HttpStatus.NO_CONTENT);
			response.setMessage("No Stocks found.... Something is Wrong");
		} else {
			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Available Stocks Are :");
			response.setData(stocks);
		}
		return response;
	}

}
