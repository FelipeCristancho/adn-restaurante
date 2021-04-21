package com.ceiba.plato.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPlato {
    private Long id;
    private String nombre;
    private float precio;
}
