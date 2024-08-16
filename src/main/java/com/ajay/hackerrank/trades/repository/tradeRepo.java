package com.ajay.hackerrank.trades.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.ajay.hackerrank.trades.model.Trade;
import java.util.List;


public interface tradeRepo extends ListCrudRepository<Trade,Integer> {

public List<Trade> findAllByType(String type);
public List<Trade> findAllByUserId(Integer id);
public List<Trade> findAllByTypeAndUserId(String type, Integer id);


    
}
