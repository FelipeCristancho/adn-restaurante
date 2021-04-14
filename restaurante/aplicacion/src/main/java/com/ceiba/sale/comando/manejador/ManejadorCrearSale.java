package com.ceiba.sale.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.sale.comando.ComandoSale;
import com.ceiba.sale.comando.fabrica.FabricaSale;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.servicio.ServicioCrearSale;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSale implements ManejadorComandoRespuesta<ComandoSale, ComandoRespuesta<Long>> {

    private final FabricaSale fabricaSale;
    private final ServicioCrearSale servicioCrearSale;

    public ManejadorCrearSale(FabricaSale fabricaSale, ServicioCrearSale servicioCrearSale) {
        this.fabricaSale = fabricaSale;
        this.servicioCrearSale = servicioCrearSale;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSale comando) {
        Sale sale = this.fabricaSale.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearSale.ejecutar(sale));
    }
}
