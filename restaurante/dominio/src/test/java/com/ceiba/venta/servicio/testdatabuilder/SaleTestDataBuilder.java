package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.venta.modelo.entidad.Venta;

import java.time.LocalDate;

public class SaleTestDataBuilder {

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private boolean promotion;

    public SaleTestDataBuilder() {
        this.saleDate = LocalDate.parse("2021-04-16");
        this.dish = 1L;
        this.client = 1L;
        this.promotion = false;
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

    public Venta build() {
        return new Venta(id,saleDate,dish,client,promotion);
    }
}
