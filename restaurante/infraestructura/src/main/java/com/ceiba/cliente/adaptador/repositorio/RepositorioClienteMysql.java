package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import java.util.logging.Level;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String CLIENTE_NO_ENCONTRADO = "Cliente no encontrado.";
    private static final Logger LOGGER = Logger.getLogger(RepositorioClienteMysql.class.getName());
    private static final Cliente clienteDefault = new Cliente(-1L,-1L,"DEFAULT","DEFAULT","-1");

    @SqlStatement(namespace = "cliente",value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "cliente", value = "buscar")
    private static String sqlBuscarPorDni;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cliente cliente) {
        return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
    }

    @Override
    public boolean existe(Long dni) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("dni",dni);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource,Boolean.class);
    }

    @Override
    public Cliente buscarClientePorId(long dni) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dni",dni);
        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorDni,parameterSource,new MapeoCliente());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            LOGGER.log(Level.FINE,CLIENTE_NO_ENCONTRADO,emptyResultDataAccessException);
            return clienteDefault;
        }
    }
}
