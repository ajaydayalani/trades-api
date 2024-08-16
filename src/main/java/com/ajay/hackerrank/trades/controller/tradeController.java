package com.ajay.hackerrank.trades.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.hackerrank.trades.service.tradeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ajay.hackerrank.trades.model.Trade;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
public class tradeController {

    @Autowired
    private tradeService tradeService;


   @GetMapping("/trades/{id}")
   public Trade getByID(@PathVariable Integer id) {
    Trade trade = tradeService.getByID(id);
    if(trade==null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trade Not Found");}

    return trade;
    }

    @PostMapping("/trades")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMethodName(@Valid @RequestBody Trade trade) {
        tradeService.addTrade(trade);
    }
    
   @GetMapping({"/trades","/trades/"})
   public List<Trade> getMethodName(@RequestParam(required = false) String type, @RequestParam(required = false) Integer userId) {
       return tradeService.get(type, userId);
   }
   
    
}
