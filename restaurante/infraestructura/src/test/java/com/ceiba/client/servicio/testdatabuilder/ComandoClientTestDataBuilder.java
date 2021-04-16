package com.ceiba.client.servicio.testdatabuilder;

import com.ceiba.client.comando.ComandoClient;
import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoClientTestDataBuilder {

    private Long id;
    private Long dni;
    private String name;
    private String last_name;
    private String telephone;


    public ComandoClientTestDataBuilder() {
        this.dni = 12345L;
        this.name = "Carlos";
        this.last_name = "Cristancho";
        this.telephone = "0987654321";
    }

    public ComandoClientTestDataBuilder conDni(Long dni){
        this.dni = dni;
        return this;
    }

    public ComandoClientTestDataBuilder conName(String name){
        this.name = name;
        return this;
    }

    public ComandoClientTestDataBuilder conLastName(String lastName){
        this.last_name = lastName;
        return this;
    }

    public ComandoClientTestDataBuilder conTelephone(String telephone){
        this.telephone = telephone;
        return this;
    }

    public ComandoClient build(){
        return new ComandoClient(id,dni,name,last_name,telephone);
    }
}
