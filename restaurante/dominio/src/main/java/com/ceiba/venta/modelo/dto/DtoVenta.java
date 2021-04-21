package com.ceiba.venta.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoVenta {

    private Long id;
    private LocalDate fecha;
    private String plato;
    private float precio;
    private String cliente;
    private boolean promocion;
}
