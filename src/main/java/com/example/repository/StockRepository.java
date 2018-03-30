package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Stock;
import com.example.domain.StockSymbol;

public interface StockRepository extends CrudRepository<Stock, Long> {

	Stock findByStockSymbol(StockSymbol stockSymbol);

}
