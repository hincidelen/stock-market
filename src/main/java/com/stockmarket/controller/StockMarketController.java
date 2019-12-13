package com.stockmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockmarket.service.StockMarketService;

@RestController
public class StockMarketController {
	
	@Autowired
	private StockMarketService stockMarketService;
	
	@GetMapping("/")
	public String hello() {
		
		return stockMarketService.hello();
	}

}
