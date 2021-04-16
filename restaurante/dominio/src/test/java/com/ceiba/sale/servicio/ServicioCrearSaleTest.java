package com.ceiba.sale.servicio;

import com.ceiba.dish.puerto.repositorio.RepositorioDish;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;
import com.ceiba.sale.servicio.testdatabuilder.SaleTestDataBuilder;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearSaleTest {

    private static final int VENTAS_TOTALES =  4;
    private static final int PROMOCION = 1;
    private static final float PRECIO_BANDEJA_PAISA = 15000;
    private static final float CANTIDAD_GASTADA = 35000;

    /*
     * Valida que la 5ta compra que hace un cliente tenga promocion,
     * cuando aplica la promocion, su valor va a ser 1, de no ser así
     * su valor va a ser 0
     */
    @Test
    public void validarPromocionCantidadVentas(){
        //Arrange
        Sale sale = new SaleTestDataBuilder().build();
        RepositorioSale repositorioSale = Mockito.mock(RepositorioSale.class);
        RepositorioDish repositorioDish = Mockito.mock(RepositorioDish.class);
        Mockito.when(repositorioSale.retornarCantidadVentas(Mockito.anyLong())).thenReturn(VENTAS_TOTALES);
        ServicioCrearSale servicioCrearSale = new ServicioCrearSale(repositorioSale, repositorioDish);
        servicioCrearSale.ejecutar(sale);

        //act - assert
        assertEquals(PROMOCION,sale.getPromotion());
    }

    /*
     * Valida que que la compra tenga promocion cuando el cliente supera los
     * 50000 en compras.
     */
    @Test
    public void validarPromocionCantidadDinero(){
        Sale sale = new SaleTestDataBuilder().build();
        RepositorioSale repositorioSale = Mockito.mock(RepositorioSale.class);
        RepositorioDish repositorioDish = Mockito.mock(RepositorioDish.class);
        Mockito.when(repositorioDish.retornarPrecio(Mockito.anyLong())).thenReturn(PRECIO_BANDEJA_PAISA);
        Mockito.when(repositorioSale.retornarCantidadGastada(Mockito.anyLong())).thenReturn(CANTIDAD_GASTADA);
        ServicioCrearSale servicioCrearSale = new ServicioCrearSale(repositorioSale, repositorioDish);
        servicioCrearSale.ejecutar(sale);

        //act - assert
        assertEquals(PROMOCION,sale.getPromotion());
    }

}
