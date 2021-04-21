package com.ceiba.venta.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Venta {

    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente";
    private static final String SE_DEBE_INGRESAR_EL_PLATO = "Se debe ingresar el plato";

    private Long id;
    private LocalDate fecha;
    private Long plato;
    private Long cliente;
    private boolean promocion;

    public Venta(Long id, LocalDate fecha, Long plato, Long cliente, boolean promocion) {
        validarObligatorio(plato, SE_DEBE_INGRESAR_EL_PLATO);
        validarObligatorio(cliente, SE_DEBE_INGRESAR_EL_CLIENTE);
        this.id = id;
        this.fecha = fecha;
        this.plato = plato;
        this.cliente = cliente;
        this.promocion = promocion;
    }

    public void asignarVentaGratuita(){
        this.promocion = true;
    }

}
