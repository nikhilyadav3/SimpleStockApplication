package com.example.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Stock;
import com.example.domain.StockSymbol;
import com.example.domain.StockType;
import com.example.domain.Trade;
import com.example.repository.StockRepository;
import com.example.repository.TradeRepository;

@Component
public class StockService {

	private static final Logger log = LoggerFactory.getLogger(StockService.class);

	@Autowired
	private TradeRepository tradeRepository;

	@Autowired
	private StockRepository stockRepository;

	public BigDecimal calculateDividendYield(StockSymbol stockSymbol, BigDecimal marketPrice) {
		BigDecimal dividendYield = BigDecimal.ZERO;
		Stock obj = null;
		obj = stockRepository.findByStockSymbol(stockSymbol);
		if (obj.getStockType() == StockType.COMMON) {
			dividendYield = obj.getLastDividend().divide(marketPrice, RoundingMode.UP);
		} else if (obj.getStockType() == StockType.PREFERRED) {
			dividendYield = obj.getLastDividend().multiply(obj.getParValue()).divide(marketPrice, RoundingMode.UP);
		}
		return dividendYield;
	}

	public BigDecimal calculatePriceEarningRatio(StockSymbol stockSymbol, BigDecimal marketPrice) {
		BigDecimal peRatio = BigDecimal.ZERO;
		Stock obj = null;
		obj = stockRepository.findByStockSymbol(stockSymbol);
		peRatio = marketPrice.divide(obj.getLastDividend(), RoundingMode.UP);
		return peRatio;
	}

	public BigDecimal calculateVolumeWeightedStock(StockType stockType, BigDecimal marketPrice) {
		BigDecimal volumeWeightedStock = BigDecimal.ZERO;
		log.info("inside service calculateVolumeWeightedStock info is " + stockType + " and " + marketPrice);
		return volumeWeightedStock;
	}

	public Trade recordTrade(Trade tradeRequest) {
		Trade tradeObj = null;
		try {
			tradeObj = tradeRepository.save(tradeRequest);
		} catch (Exception ex) {
			log.info("trade Not Saved Successfully." + ex.getMessage());
			return tradeObj;
		}
		return tradeObj;
	}

	public Stock createStock(Stock stockRequest) {
		Stock stockObj = null;
		try {
			stockObj = stockRepository.save(stockRequest);
		} catch (Exception ex) {
			log.info("trade Not Saved Successfully." + ex.getMessage());
			return stockObj;
		}
		return stockObj;
	}

	public double calculateGeometricMean() {
		double geomMeatricProduct = 1.0;
		log.info("inside service calculateGeometricMean info is ");
		List<Stock> list = this.getStocks();
		for (int i = 0; i < list.size(); i++) {
			geomMeatricProduct = geomMeatricProduct * list.get(i).getStockPrice();
		}
		return Math.pow(geomMeatricProduct, 1.0 / list.size());
	}

	public List<Trade> getTrades() {
		return (List<Trade>) tradeRepository.findAll();
	}

	public List<Stock> getStocks() {
		return (List<Stock>) stockRepository.findAll();
	}

}
