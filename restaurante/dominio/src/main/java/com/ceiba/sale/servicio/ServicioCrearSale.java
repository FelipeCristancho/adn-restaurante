package com.ceiba.sale.servicio;

import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;

public class ServicioCrearSale {

    private final RepositorioSale repositorioSale;

    public ServicioCrearSale(RepositorioSale repositorioSale) {
        this.repositorioSale = repositorioSale;
    }

    public Long ejecutar(Sale sale){
        return this.repositorioSale.crear(sale);
    }
}
