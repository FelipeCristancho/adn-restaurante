package com.ceiba.sale.servicio.testdatabuilder;

import com.ceiba.sale.modelo.entidad.Sale;

import java.time.LocalDate;

public class SaleTestDataBuilder {

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private int promotion;

    public SaleTestDataBuilder() {
        this.saleDate = LocalDate.parse("2021-04-16");
        this.dish = 1L;
        this.client = 1L;
        this.promotion = 0;
    }

    public SaleTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public SaleTestDataBuilder conClient(Long client){
        this.client = client;
        return this;
    }

    public SaleTestDataBuilder conDish(Long dish){
        this.dish = dish;
        return this;
    }

    public Sale build() {
        return new Sale(id,saleDate,dish,client,promotion);
    }
}
