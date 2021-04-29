package com.ceiba.venta.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.plato.modelo.entidad.Plato;
import com.ceiba.venta.modelo.entidad.Venta;

import java.time.LocalDate;

public class SaleTestDataBuilder {

    private Long id;
    private LocalDate saleDate;
    private Plato dish;
    private Cliente client;
    private boolean promotion;

    public SaleTestDataBuilder() {
        this.saleDate = LocalDate.parse("2021-04-16");
        this.dish = new Plato(1L,"Bandeja Paisa",15000);
        this.client = new Cliente(1L,1L,"Felipe","Cristancho","3202140604");
        this.promotion = false;
    }

    public SaleTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public SaleTestDataBuilder conClient(Cliente client){
        this.client = client;
        return this;
    }

    public SaleTestDataBuilder conDish(Plato dish){
        this.dish = dish;
        return this;
    }

    public Venta build() {
        return new Venta(id,saleDate,dish,client,promotion);
    }
}
