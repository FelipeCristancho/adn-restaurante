package com.ceiba.venta.puerto.repositorio;

import com.ceiba.venta.modelo.entidad.Venta;

public interface RepositorioVenta {

    /**
     * Permite crear una venta
     * @param venta
     * @return el id generado
     */
    Long crear(Venta venta);

    /*
     *  Retorna el numero total de ventas de un cliente
     */
    int obtenerCantidadVentas(Long dni);

    /*
     * Retorna toda la cantidad de dinero gastado en el restaurante por un cliente
     */
    float obtenerCantidadGastada(Long dni);

    float obtenerValorPlato(Long id);

}
