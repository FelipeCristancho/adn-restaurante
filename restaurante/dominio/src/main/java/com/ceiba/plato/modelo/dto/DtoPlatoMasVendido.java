package com.ceiba.plato.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPlatoMasVendido {

    private Long id;
    private String nombre;
    private float precio;
    private int totalVentas;
}
