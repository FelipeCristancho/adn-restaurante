package com.ceiba.dish.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
@Setter
public class Dish {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_PLATO = "Se debe ingresar el nombre deL plato";
    private static final String PRECIO_DEBE_SER_POSITIVO = "Se debe valores ingresar valores positivos";

    private Long dishId;
    private String name;
    private float price;

    public Dish(Long dishId, String name, float price) {
        validarObligatorio(name,SE_DEBE_INGRESAR_EL_NOMBRE_DE_PLATO);
        validarPositivo((double) price, PRECIO_DEBE_SER_POSITIVO);
        this.dishId = dishId;
        this.name = name;
        this.price = price;
    }
}
