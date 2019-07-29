package com.hcl.stocktrading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.stocktrading.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
