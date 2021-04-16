package com.ceiba.sale.servicio.testdatabuilder;

import com.ceiba.sale.comando.ComandoSale;

import java.time.LocalDate;

public class ComandoSaleTestDataBuilder {

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private int promotion;

    public ComandoSaleTestDataBuilder(){
        saleDate = LocalDate.parse("2021-04-16");
        dish = 1L;
        client = 1L;
        promotion = 1;
    }

    private ComandoSaleTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    private ComandoSaleTestDataBuilder conDish(Long dish){
        this.dish = dish;
        return this;
    }

    private ComandoSaleTestDataBuilder conClient(Long client){
        this.client = client;
        return this;
    }

    private ComandoSaleTestDataBuilder conPromotion(int promotion){
        this.promotion = promotion;
        return this;
    }

    public ComandoSale build(){
        return new ComandoSale(id, saleDate, dish, client,promotion);
    }
}
