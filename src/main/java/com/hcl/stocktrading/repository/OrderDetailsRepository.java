package com.hcl.stocktrading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stocktrading.dto.OrderHistoryDto;
import com.hcl.stocktrading.entity.OrderDetails;
import com.hcl.stocktrading.entity.User;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

	public List<OrderDetails> findByUserId(OrderHistoryDto userId);

	public Object findById(int i);

}
