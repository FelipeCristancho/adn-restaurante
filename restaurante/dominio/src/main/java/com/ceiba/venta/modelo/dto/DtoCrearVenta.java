package com.ceiba.venta.modelo.dto;

import com.ceiba.plato.modelo.entidad.Plato;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCrearVenta {

    private Long id;
    private LocalDate fecha;
    private long plato;
    private Long cliente;
    private boolean promocion;
}
