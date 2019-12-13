package com.stockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.entity.Stock;
import com.stockmarket.entity.StockHolding;
import com.stockmarket.service.StockMarketService;
import com.stockmarket.service.StockService;

@RestController
@RequestMapping("stock-market")
public class StockMarketController {
	
	@Autowired
	private StockMarketService stockMarketService;
	
	
	@PostMapping("buy")
	public StockHolding buy(
			@RequestParam String userName,
			@RequestParam String stockCode,
			@RequestParam int amount
			) throws Exception {
		return stockMarketService.buy(userName, stockCode, amount);
	}
	
	@PostMapping("sell")
	public StockHolding sell(
			@RequestParam String userName,
			@RequestParam String stockCode,
			@RequestParam int amount
			) throws Exception {
		return stockMarketService.sell(userName, stockCode, amount);
	}

}
