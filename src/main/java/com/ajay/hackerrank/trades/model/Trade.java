package com.ajay.hackerrank.trades.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;

@Table("TRADES")
public record Trade(
    @Id
    Integer id,

    @NotBlank
    String type,
    
    Integer userId,

    @NotBlank
    String symbol,

    Integer shares,

    Integer price,

    Long timestamp
) {}
