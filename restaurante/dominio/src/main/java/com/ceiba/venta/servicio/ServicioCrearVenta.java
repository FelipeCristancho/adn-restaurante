package com.ceiba.venta.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.plato.puerto.repositorio.RepositorioPlato;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;

public class ServicioCrearVenta {

    private final RepositorioVenta repositorioVenta;
    private final RepositorioPlato repositorioPlato;
    private final RepositorioCliente repositorioCliente;

    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema, debe registrarse primero";
    private static int CANTIDAD_PROMOCION = 4;
    private static float CANTIDAD_DINERO = 50000;

    public ServicioCrearVenta(RepositorioVenta repositorioVenta, RepositorioPlato repositorioPlato, RepositorioCliente repositorioCliente) {
        this.repositorioVenta = repositorioVenta;
        this.repositorioPlato = repositorioPlato;
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Venta venta){
        validarPromocionporCantidadCompras(venta);
        validarPromocionCantidadDinero(venta);
        validarExistenciaPrevia(venta);
        return this.repositorioVenta.crear(venta);
    }

    private void validarPromocionporCantidadCompras(Venta venta){
        int cantidadVentas = this.repositorioVenta.obtenerCantidadVentas(venta.getCliente().getDni());
        if (cantidadVentas == CANTIDAD_PROMOCION)
            venta.asignarVentaGratuita();
    }

    private void validarPromocionCantidadDinero(Venta venta){
          float cantidadDinero = this.repositorioVenta.obtenerCantidadGastada(venta.getCliente().getDni());
          float precioPlato = this.repositorioPlato.obtenerPrecio(venta.getPlato().getId());
          if(cantidadDinero < CANTIDAD_DINERO && (cantidadDinero + precioPlato) >= CANTIDAD_DINERO)
                venta.asignarVentaGratuita();
    }

    private void validarExistenciaPrevia(Venta venta){
        boolean existe = this.repositorioCliente.existe(venta.getCliente().getDni());
        if(!existe){
            throw new ExcepcionValorInvalido(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
