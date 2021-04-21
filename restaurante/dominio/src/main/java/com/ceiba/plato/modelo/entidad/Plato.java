package com.ceiba.plato.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Plato {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_PLATO = "Se debe ingresar el nombre deL plato";
    private static final String PRECIO_DEBE_SER_POSITIVO = "Se debe valores ingresar valores positivos";

    private Long id;
    private String nombre;
    private float precio;

    public Plato(Long id, String nombre, float precio) {
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_PLATO);
        validarPositivo((double) precio, PRECIO_DEBE_SER_POSITIVO);
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}
