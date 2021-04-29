package com.ceiba.venta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plato.puerto.repositorio.RepositorioPlato;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.comando.fabrica.FabricaVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.servicio.ServicioCrearVenta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSale implements ManejadorComandoRespuesta<ComandoVenta, ComandoRespuesta<Long>> {

    private final FabricaVenta fabricaVenta;
    private final ServicioCrearVenta servicioCrearVenta;
    private final RepositorioPlato repositorioPlato;
    private final RepositorioCliente repositorioCliente;

    public ManejadorCrearSale(FabricaVenta fabricaVenta, ServicioCrearVenta servicioCrearVenta, RepositorioPlato repositorioPlato, RepositorioCliente repositorioCliente) {
        this.fabricaVenta = fabricaVenta;
        this.servicioCrearVenta = servicioCrearVenta;
        this.repositorioPlato = repositorioPlato;
        this.repositorioCliente = repositorioCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoVenta comando) {
        Venta venta = this.fabricaVenta.crear(comando,this.repositorioPlato, this.repositorioCliente);
        return new ComandoRespuesta<>(this.servicioCrearVenta.ejecutar(venta));
    }
}
