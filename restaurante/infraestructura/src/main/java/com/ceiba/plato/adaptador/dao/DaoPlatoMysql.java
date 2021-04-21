package com.ceiba.plato.adaptador.dao;

import com.ceiba.plato.modelo.dto.DtoPlato;
import com.ceiba.plato.modelo.dto.DtoPlatoMasVendido;
import com.ceiba.plato.puerto.dao.DaoPlato;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPlatoMysql implements DaoPlato {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "plato", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "plato", value = "masVendido")
    private static String sqlMasVendido;

    public DaoPlatoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPlato> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPlato());
    }

    @Override
    public List<DtoPlatoMasVendido> masVendido() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlMasVendido, new MapeoPlatoMasVendido());
    }
}
