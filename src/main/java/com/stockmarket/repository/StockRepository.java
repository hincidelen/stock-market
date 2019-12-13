package com.stockmarket.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmarket.entity.Stock;
import com.stockmarket.entity.User;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	Stock findAllByCode(String stockCode);

}