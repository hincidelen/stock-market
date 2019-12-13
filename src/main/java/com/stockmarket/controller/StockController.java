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
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.entity.Stock;
import com.stockmarket.service.StockService;

@RestController
@RequestMapping("stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/{stockCode}")
	public Stock getStock(@PathVariable String stockCode) {
		
		return stockService.getStock(stockCode);
	}
	
	@GetMapping
	public List<Stock> getStocks() {
		return stockService.getStocks();
	}
	
	@PostMapping
	public Stock addStock(@RequestBody Stock stockRequest) throws Exception {
		return stockService.addStock(stockRequest);
	}
	@PutMapping("/{stockCode}")
	public Stock editStock(@PathVariable String stockCode, @RequestBody Stock stockRequest) throws Exception {
		return stockService.editStock(stockCode, stockRequest);
	}
	@DeleteMapping
	public void deleteStock(String stockCode) throws Exception {
		stockService.deleteStock(stockCode);
	}

}
