package com.hcl.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmOrderRepository extends JpaRepository<OrderDetails, Long>{
	
	

}
