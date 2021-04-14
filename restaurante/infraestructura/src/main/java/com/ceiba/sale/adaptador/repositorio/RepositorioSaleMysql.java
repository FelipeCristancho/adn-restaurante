package com.ceiba.sale.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSaleMysql implements RepositorioSale {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "sale", value = "crear")
    private static String sqlCrear;

    public RepositorioSaleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Sale sale) {
        return this.customNamedParameterJdbcTemplate.crear(sale,sqlCrear);
    }
}
