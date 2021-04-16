package com.ceiba.client.adaptador.dao;

import com.ceiba.client.modelo.dto.DtoBestClient;
import com.ceiba.client.modelo.dto.DtoClient;
import com.ceiba.client.puerto.dao.DaoClient;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClientMysql implements DaoClient {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "client", value = "listar")
    private static String sqListar;

    @SqlStatement(namespace = "client", value = "mejorCliente")
    private static String sqMejorCliente;

    public DaoClientMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoClient> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqListar,  new MapeoClient());
    }

    @Override
    public List<DtoBestClient> MejorCliente() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqMejorCliente, new MapeoMejorCliente());
    }
}
