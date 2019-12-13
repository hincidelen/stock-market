package com.stockmarket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.entity.Stock;
import com.stockmarket.entity.StockHolding;
import com.stockmarket.entity.User;
import com.stockmarket.repository.StockHoldingRepository;
import com.stockmarket.repository.StockRepository;

@Service
public class StockMarketService {

	@Autowired 
	UserService userService;
	
	@Autowired 
	StockService stockService;
	
	@Autowired
	StockHoldingRepository stockHoldingRepo;
	

	public StockHolding buy(String userName, String stockCode, int amount) throws Exception {
		if(amount<=0)
			throw new Exception("miktar 0'dan büyük olmalı!");
		
		User user = userService.getUser(userName);
		if(user==null)
			throw new Exception(userName + " kullanıcısı bulunmamakta!");
		
		Stock stock = stockService.getStock(stockCode);
		if(stock==null)
			throw new Exception(stock + " hissesi bulunmamakta!");
		
		return stockHoldingRepo.save(new StockHolding(0, stock, user, amount, new Date()));
	}

	public StockHolding sell(String userName, String stockCode, int amount) throws Exception{
		if(amount<=0)
			throw new Exception("miktar 0'dan büyük olmalı!");
		
		User user = userService.getUser(userName);
		if(user==null)
			throw new Exception(userName + " kullanıcısı bulunmamakta!");
		
		Stock stock = stockService.getStock(stockCode);
		if(stock==null)
			throw new Exception(stock + " hissesi bulunmamakta!");
		
		return stockHoldingRepo.save(new StockHolding(0, stock, user, -amount, new Date()));
	}
}
