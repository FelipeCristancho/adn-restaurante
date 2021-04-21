package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.venta.comando.ComandoVenta;

import java.time.LocalDate;

public class ComandoSaleTestDataBuilder {

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private boolean promotion;

    public ComandoSaleTestDataBuilder(){
        saleDate = LocalDate.parse("2021-04-16");
        dish = 1L;
        client = 1L;
        promotion = true;
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

    private ComandoSaleTestDataBuilder conPromotion(boolean promotion){
        this.promotion = promotion;
        return this;
    }

    public ComandoVenta build(){
        return new ComandoVenta(id, saleDate, dish, client,promotion);
    }
}
