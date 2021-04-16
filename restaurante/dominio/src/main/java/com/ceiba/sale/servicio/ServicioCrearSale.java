package com.ceiba.sale.servicio;

import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.dish.puerto.repositorio.RepositorioDish;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;

public class ServicioCrearSale {

    private final RepositorioSale repositorioSale;
    private final RepositorioDish repositorioDish;
    private final RepositorioClient repositorioClient;

    private static final String LLEGAR_CANTIDAD_COMPRAS = "Por llegar a las 5 compras esta venta es gratis";
    private static final String LLEGAR_CANTIDAD_DINERO = "Por llegar a $20000 en compras esta venta es gratis";
    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema, debe registrarse primero";
    private static final float PRECIO_MENOR_PLATO = 15000;
    private static int CANTIDAD_PROMOCION = 4;
    private static float CANTIDAD_DINERO = 50000;
    private static int UNO = 1;

    public ServicioCrearSale(RepositorioSale repositorioSale, RepositorioDish repositorioDish, RepositorioClient repositorioClient) {
        this.repositorioSale = repositorioSale;
        this.repositorioDish = repositorioDish;
        this.repositorioClient = repositorioClient;
    }

    public Long ejecutar(Sale sale){
        validarPromocionporCantidadCompras(sale);
        validarPromocionCantidadDinero(sale);
        validarExistenciaPrevia(sale);
        return this.repositorioSale.crear(sale);
    }

    private int retornarVentas(Long dni){
        return this.repositorioSale.retornarCantidadVentas(dni);
    }
    private float retornarCantidadDinero(Long dni){ return this.repositorioSale.retornarCantidadGastada(dni); }
    private float retornarPrecio(Long id){ return  this.repositorioSale.retornarValorPlato(id); }
    private float retornarPrecioDish(Long id){ return  this.repositorioDish.retornarPrecio(id); }

    private void validarPromocionporCantidadCompras(Sale sale){
        int cantidadVentas = retornarVentas(sale.getClient());
        if (cantidadVentas == CANTIDAD_PROMOCION)
            sale.setPromotion(UNO);
    }

    private void validarPromocionCantidadDinero(Sale sale){
          float cantidadDinero = retornarCantidadDinero(sale.getClient());
          float precioPlato = retornarPrecioDish(sale.getDish());
          if(cantidadDinero < CANTIDAD_DINERO && (cantidadDinero + precioPlato) >= CANTIDAD_DINERO)
                sale.setPromotion(UNO);
    }

    private void validarExistenciaPrevia(Sale sale){
        boolean existe = this.repositorioClient.existe(sale.getClient());
        if(!existe){
            throw new ExcepcionValorInvalido(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
