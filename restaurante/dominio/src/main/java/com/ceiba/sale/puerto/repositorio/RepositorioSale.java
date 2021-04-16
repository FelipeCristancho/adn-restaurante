package com.ceiba.sale.puerto.repositorio;

import com.ceiba.sale.modelo.entidad.Sale;

public interface RepositorioSale {

    /**
     * Permite crear una venta
     * @param sale
     * @return el id generado
     */
    Long crear(Sale sale);

    /*
     *  Retorna el numero total de ventas de un cliente
     */
    int retornarCantidadVentas(Long dni);

    /*
     * Retorna toda la cantidad de dinero gastado en el restaurante por un cliente
     */
    float retornarCantidadGastada(Long dni);
    float retornarValorPlato(Long id);

}
