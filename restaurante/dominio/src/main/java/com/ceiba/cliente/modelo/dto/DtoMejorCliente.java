package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMejorCliente {

    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private int totalCompras;
}
