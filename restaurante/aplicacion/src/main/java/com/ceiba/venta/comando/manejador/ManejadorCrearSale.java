package com.ceiba.venta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.comando.fabrica.FabricaVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSale implements ManejadorComandoRespuesta<ComandoVenta, ComandoRespuesta<Long>> {

    private final FabricaVenta fabricaVenta;
    private final ServicioCrearVenta servicioCrearVenta;

    public ManejadorCrearSale(FabricaVenta fabricaVenta, ServicioCrearVenta servicioCrearVenta) {
        this.fabricaVenta = fabricaVenta;
        this.servicioCrearVenta = servicioCrearVenta;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoVenta comando) {
        Venta venta = this.fabricaVenta.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearVenta.ejecutar(venta));
    }
}
