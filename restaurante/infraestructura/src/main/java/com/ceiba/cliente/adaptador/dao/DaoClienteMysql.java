package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoMejorCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClienteMysql implements DaoCliente {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "listar")
    private static String sqListar;

    @SqlStatement(namespace = "cliente", value = "mejorCliente")
    private static String sqMejorCliente;

    public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCliente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqListar,  new MapeoCliente());
    }

    @Override
    public List<DtoMejorCliente> MejorCliente() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqMejorCliente, new MapeoMejorCliente());
    }
}
