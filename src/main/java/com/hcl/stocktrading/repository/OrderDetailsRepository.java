package com.hcl.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.Stocks;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	public Stocks findByStockId(OrderDetails orderDetails);

}
