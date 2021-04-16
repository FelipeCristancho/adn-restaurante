package com.ceiba.sale.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Sale {

    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente";
    private static final String SE_DEBE_INGRESAR_EL_PLATO = "Se debe ingresar el plato";

    private Long id;
    private LocalDate saleDate;
    private Long dish;
    private Long client;
    private int promotion;

    public Sale(Long id, LocalDate saleDate, Long dish, Long client, int promotion) {
        validarObligatorio(dish, SE_DEBE_INGRESAR_EL_PLATO);
        validarObligatorio(client, SE_DEBE_INGRESAR_EL_CLIENTE);
        this.id = id;
        this.saleDate = saleDate;
        this.dish = dish;
        this.client = client;
        this.promotion = promotion;
    }
}
