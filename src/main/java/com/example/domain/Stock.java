package com.example.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;

	@NotNull
	private StockType stockType;

	@Column(unique=true)
	@NotNull
	private StockSymbol stockSymbol;

	@NotNull
	private BigDecimal lastDividend;

	private BigDecimal fixedDividend;

	@NotNull
	private BigDecimal parValue;
	
	@NotNull
	private double stockPrice;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="tradeId", cascade = CascadeType.ALL)
	private Set<Trade> trades = new HashSet<>();

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Long getStockId() {
		return stockId;
	}

	public StockType getStockType() {
		return stockType;
	}

	public StockSymbol getStockSymbol() {
		return stockSymbol;
	}

	public BigDecimal getLastDividend() {
		return lastDividend;
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public BigDecimal getParValue() {
		return parValue;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public void setStockSymbol(StockSymbol stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public void setLastDividend(BigDecimal lastDividend) {
		this.lastDividend = lastDividend;
	}

	public void setFixedDividend(BigDecimal fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public void setParValue(BigDecimal parValue) {
		this.parValue = parValue;
	}

}
