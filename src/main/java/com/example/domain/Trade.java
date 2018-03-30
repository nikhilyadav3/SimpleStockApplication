package com.example.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tradeId;

	@NotNull
	private BigDecimal quantity;
		
	@Column(name = "TimeOfTrade", insertable = false, updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeOfTrade;	

	@NotNull
	private TradeType tradeType;

	@NotNull
	private BigDecimal tradePrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stockId")
	private Stock stock;

	public Stock getStockId() {
		return stock;
	}

	public void setTimeOfTrade(Date timeOfTrade) {
		this.timeOfTrade = timeOfTrade;
	}

	public void setStockId(Stock stock) {
		this.stock = stock;
	}

	public Trade() {
	}

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public Date getTimeOfTrade() {
		return timeOfTrade;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

}
