package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Trade;

public interface TradeRepository extends CrudRepository<Trade, Long> {

}
