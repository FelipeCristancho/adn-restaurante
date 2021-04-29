package com.ceiba.venta.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.plato.modelo.entidad.Plato;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Venta {

    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente";
    private static final String SE_DEBE_INGRESAR_EL_PLATO = "Se debe ingresar el plato";

    private Long id;
    private LocalDate fecha;
    private Plato plato;
    private Cliente cliente;
    private boolean promocion;

    public Venta(Long id, LocalDate fecha, Plato plato, Cliente cliente, boolean promocion) {
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
