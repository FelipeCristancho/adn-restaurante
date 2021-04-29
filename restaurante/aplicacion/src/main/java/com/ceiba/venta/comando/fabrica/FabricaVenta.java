package com.ceiba.venta.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.plato.modelo.entidad.Plato;
import com.ceiba.plato.puerto.repositorio.RepositorioPlato;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FabricaVenta {

    public Venta crear(ComandoVenta comandoVenta, RepositorioPlato repositorioPlato, RepositorioCliente repositorioCliente){
        Plato plato = repositorioPlato.buscarPlatoPorId(comandoVenta.getPlato());
        Cliente cliente = repositorioCliente.buscarClientePorId(comandoVenta.getCliente());
        return new Venta(
          comandoVenta.getId(),
          LocalDate.now(),
          plato,
          cliente,
          comandoVenta.isPromocion()
        );
    }
}
