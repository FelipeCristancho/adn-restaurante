package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_IDENTIFICACION = "Se debe ingresar la identificacion";
    private static final String SE_DEBE_INGRESAR_APELLIDO = "Se debe ingresar el apellido";

    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente(Long id, Long dni, String nombre, String apellido, String telefono) {
        validarObligatorio(dni,SE_DEBE_INGRESAR_IDENTIFICACION);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_APELLIDO);
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
}
