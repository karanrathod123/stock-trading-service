package com.hcl.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stocktrading.entity.OrderDetails;

@Repository
public interface ConfirmOrderRepository extends JpaRepository<OrderDetails, Long>{
	
	

}
