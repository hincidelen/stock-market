package com.stockmarket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.entity.Stock;
import com.stockmarket.repository.StockRepository;

@Service
public class StockService {

	@Autowired 
	StockRepository stockRepo;

	public Stock getStock(String stockCode) {
		return stockRepo.findAllByCode(stockCode);
	}

	public List<Stock> getStocks() {
		return stockRepo.findAll();
	}

	public Stock addStock(Stock stockRequest) throws Exception {
		if(getStock(stockRequest.getCode())!=null)
			throw new Exception(stockRequest.getCode() + " hissesi bulunmakta!");
		stockRequest.setCreateDate(new Date());
		return stockRepo.save(stockRequest);
	}

	public void deleteStock(String stockCode) throws Exception {
		if(getStock(stockCode)==null)
			throw new Exception(stockCode + " hissesi bulunmamakta!");
		stockRepo.delete(getStock(stockCode));
	}

	public Stock editStock(String stockCode, Stock stockRequest) throws Exception {
		if(getStock(stockCode)==null)
			throw new Exception(stockCode + " hissesi bulunmamakta!");
		stockRequest.setId(getStock(stockCode).getId());
		stockRequest.setLastModifiedDate(new Date());
		return stockRepo.save(stockRequest);
	}
	

}
