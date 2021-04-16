package com.ceiba.sale.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoSale {

    private Long id;
    private LocalDate saleDate;
    private String dish;
    private float price;
    private String client;
    private int promotion;
}
