package com.ceiba.sale.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.client.servicio.ServicioCrearClient;
import com.ceiba.client.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dish.puerto.repositorio.RepositorioDish;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.sale.modelo.entidad.Sale;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;
import com.ceiba.sale.servicio.testdatabuilder.SaleTestDataBuilder;
import org.junit.Test;
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
        RepositorioClient repositorioClient = Mockito.mock(RepositorioClient.class);
        Mockito.when(repositorioSale.retornarCantidadVentas(Mockito.anyLong())).thenReturn(VENTAS_TOTALES);
        Mockito.when(repositorioClient.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearSale servicioCrearSale = new ServicioCrearSale(repositorioSale, repositorioDish, repositorioClient);
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
        RepositorioClient repositorioClient = Mockito.mock(RepositorioClient.class);
        Mockito.when(repositorioDish.retornarPrecio(Mockito.anyLong())).thenReturn(PRECIO_BANDEJA_PAISA);
        Mockito.when(repositorioSale.retornarCantidadGastada(Mockito.anyLong())).thenReturn(CANTIDAD_GASTADA);
        Mockito.when(repositorioClient.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearSale servicioCrearSale = new ServicioCrearSale(repositorioSale, repositorioDish, repositorioClient);
        servicioCrearSale.ejecutar(sale);

        //act - assert
        assertEquals(PROMOCION,sale.getPromotion());
    }

    @Test
    public void ValidarExistenciaPreviaTest(){
        //arrange
        Sale sale = new SaleTestDataBuilder().build();
        RepositorioClient repositorioClient = Mockito.mock(RepositorioClient.class);
        RepositorioSale repositorioSale = Mockito.mock(RepositorioSale.class);
        RepositorioDish repositorioDish = Mockito.mock(RepositorioDish.class);
        Mockito.when(repositorioClient.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearSale servicioCrearSale = new ServicioCrearSale(repositorioSale, repositorioDish, repositorioClient);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearSale.ejecutar(sale), ExcepcionValorInvalido.class, "El cliente no existe en el sistema, debe registrarse primero");
    }
}
