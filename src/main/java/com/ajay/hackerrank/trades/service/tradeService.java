package com.ajay.hackerrank.trades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.hackerrank.trades.model.Trade;
import com.ajay.hackerrank.trades.repository.tradeRepo;

@Service
public class tradeService {

    @Autowired
    private tradeRepo tradeRepo;

    public Trade getByID(Integer id) {
        return tradeRepo.findById(id).orElse(null);
    }

    public List<Trade> get(String type, Integer userId){
        if(type!=null && userId!=null){
            return tradeRepo.findAllByTypeAndUserId(type, userId);
        }
        else if( type==null && userId!=null){
            return tradeRepo.findAllByUserId(userId);
        }else if(type!=null && userId==null){
            return tradeRepo.findAllByType(type);
        }
        return tradeRepo.findAll();
    }

    public void addTrade(Trade trade){
       
        tradeRepo.save(trade);
    }
    
}
