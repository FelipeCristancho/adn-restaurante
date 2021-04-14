package com.ceiba.sale.puerto.repositorio;

import com.ceiba.sale.modelo.entidad.Sale;

public interface RepositorioSale {

    /**
     * Permite crear una venta
     * @param sale
     * @return el id generado
     */
    Long crear(Sale sale);
}
