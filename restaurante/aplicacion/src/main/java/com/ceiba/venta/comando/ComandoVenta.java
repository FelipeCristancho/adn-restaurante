package com.ceiba.venta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVenta {

    private Long id;
    private LocalDate fecha;
    private Long plato;
    private Long cliente;
    private boolean promocion;
}
