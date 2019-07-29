package com.hcl.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stocktrading.entity.Stocks;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Long>{

}
