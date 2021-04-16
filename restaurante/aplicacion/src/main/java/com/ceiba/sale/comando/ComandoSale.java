package com.ceiba.sale.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSale {

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private int promotion;
}
