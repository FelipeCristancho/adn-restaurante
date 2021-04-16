package com.ceiba.dish.adaptador.dao;

import com.ceiba.dish.modelo.dto.DtoDish;
import com.ceiba.dish.modelo.dto.DtoDishMasVendido;
import com.ceiba.dish.puerto.dao.DaoDish;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDishMysql implements DaoDish {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "dish", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "dish", value = "masVendido")
    private static String sqlMasVendido;

    public DaoDishMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDish> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDish());
    }

    @Override
    public List<DtoDishMasVendido> masVendido() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlMasVendido, new MapeoDishMasVendido());
    }
}
