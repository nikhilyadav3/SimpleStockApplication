package com.example.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Stock;
import com.example.domain.StockSymbol;
import com.example.domain.StockType;
import com.example.domain.Trade;
import com.example.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/createstock")
	public ResponseEntity<?> createStock(@RequestBody Stock stock) {
		Stock newStock = null;
		newStock = stockService.createStock(stock);
		if (newStock == null) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity(newStock, HttpStatus.OK);
		}
	}

	@GetMapping("/dividendyield")
	public BigDecimal calculateDividendYield(@RequestParam StockSymbol stockSymbol,
			@RequestParam BigDecimal marketPrice) {
		return stockService.calculateDividendYield(stockSymbol, marketPrice);
	}

	@GetMapping("/priceearning")
	public BigDecimal calculatePriceEarningRation(@RequestParam StockSymbol stockSymbol,
			@RequestParam BigDecimal marketPrice) {
		return stockService.calculatePriceEarningRatio(stockSymbol, marketPrice);
	}

	@GetMapping("/volumeweighted")
	public BigDecimal calculateVolumeWeightedStock(@RequestParam StockType stockType,
			@RequestParam BigDecimal marketPrice) {
		return stockService.calculateVolumeWeightedStock(stockType, marketPrice);
	}

	@PostMapping("/trade")
	public ResponseEntity<?> recordTrade(@RequestBody Trade trade) {
		Trade newTrade = null;
		newTrade = stockService.recordTrade(trade);
		if (newTrade == null) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity(newTrade, HttpStatus.OK);
		}
	}

	@GetMapping("/geometricmean")
	public double calculateGeometricMean() {
		return stockService.calculateGeometricMean();
	}

	@GetMapping("/getTrades")
	public List<Trade> getTrades() {
		return stockService.getTrades();
	}

	@GetMapping("/getStocks")
	public List<Stock> getStocks() {
		return stockService.getStocks();
	}

}
