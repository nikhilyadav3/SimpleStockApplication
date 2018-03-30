package com.example.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.JpMorganStockApplication;
import com.example.domain.Stock;
import com.example.domain.StockSymbol;
import com.example.domain.StockType;
import com.example.domain.Trade;
import com.example.domain.TradeType;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = JpMorganStockApplication.class)
public class StockRepositoryTest {

	@Autowired
	private StockRepository stockRepository;

	@Test
	public void whenFindStockBySymbol() {
		Stock stock = this.getStock();
		stockRepository.save(stock);
		Stock repoStock = stockRepository.findByStockSymbol(StockSymbol.ALE);
		assertNotNull(repoStock);
	}

	@Test
	public void createStockTest() {
		Stock savedStocks = stockRepository.save(this.getStock());
		assertNotNull(savedStocks);
	}

	private Stock getStock() {
		Trade trade = new Trade();
		trade.setQuantity(BigDecimal.ONE);
		trade.setTradeType(TradeType.BUY);
		trade.setTradePrice(BigDecimal.TEN);

		Set<Trade> trades = new HashSet<>();
		trades.add(trade);

		Stock stock = new Stock();
		stock.setStockType(StockType.COMMON);
		stock.setFixedDividend(BigDecimal.TEN);
		stock.setStockSymbol(StockSymbol.ALE);
		stock.setLastDividend(BigDecimal.TEN);
		stock.setParValue(BigDecimal.TEN);
		stock.setStockPrice(12.34);
		stock.setTrades(trades);
		return stock;
	}

}
