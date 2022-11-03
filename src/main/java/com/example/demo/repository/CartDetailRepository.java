package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
