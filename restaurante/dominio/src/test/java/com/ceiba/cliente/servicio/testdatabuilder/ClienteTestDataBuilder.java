package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private Long dni;
    private String name;
    private String last_name;
    private String telephone;

    public ClienteTestDataBuilder(){
        dni = 123456L;
        name = "Carlos";
        last_name = "Cristancho";
        telephone = "3214569780";
    }

    public ClienteTestDataBuilder conDni(Long dni){
        this.dni = dni;
        return this;
    }

    public ClienteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public Cliente build(){
        return new Cliente(id,dni,name,last_name,telephone);
    }
}
