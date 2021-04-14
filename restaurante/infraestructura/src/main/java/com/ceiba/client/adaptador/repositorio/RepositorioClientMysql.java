package com.ceiba.client.adaptador.repositorio;

import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientMysql implements RepositorioClient {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "client",value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace="client", value="existe")
    private static String sqlExiste;

    public RepositorioClientMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Client client) {
        return this.customNamedParameterJdbcTemplate.crear(client, sqlCrear);
    }

    @Override
    public boolean existe(Long dni) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("dni",dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource,Boolean.class);
    }
}
