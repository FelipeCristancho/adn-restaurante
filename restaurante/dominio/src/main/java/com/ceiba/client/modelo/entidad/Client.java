package com.ceiba.client.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Client {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_IDENTIFICACION = "Se debe ingresar la identificacion";
    private static final String SE_DEBE_INGRESAR_APELLIDO = "Se debe ingresar el apellido";

    private Long id;
    private Long dni;
    private String name;
    private String last_name;
    private String telephone;

    public Client(Long id, Long dni, String name, String last_name, String telephone) {
        validarObligatorio(dni,SE_DEBE_INGRESAR_IDENTIFICACION);
        validarObligatorio(name, SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(last_name, SE_DEBE_INGRESAR_APELLIDO);
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.last_name = last_name;
        this.telephone = telephone;
    }
}
