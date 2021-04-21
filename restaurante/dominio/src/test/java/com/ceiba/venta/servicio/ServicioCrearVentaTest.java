package com.ceiba.venta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.plato.puerto.repositorio.RepositorioPlato;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.testdatabuilder.SaleTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearVentaTest {

    private static final int VENTAS_TOTALES =  4;
    private static final boolean PROMOCION = true;
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
        Venta venta = new SaleTestDataBuilder().build();
        RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);
        RepositorioPlato repositorioPlato = Mockito.mock(RepositorioPlato.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioVenta.obtenerCantidadVentas(Mockito.anyLong())).thenReturn(VENTAS_TOTALES);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearVenta servicioCrearVenta = new ServicioCrearVenta(repositorioVenta, repositorioPlato, repositorioCliente);
        servicioCrearVenta.ejecutar(venta);

        //act - assert
        assertEquals(PROMOCION, venta.isPromocion());
    }

    /*
     * Valida que que la compra tenga promocion cuando el cliente supera los
     * 50000 en compras.
     */
    @Test
    public void validarPromocionCantidadDinero(){
        Venta venta = new SaleTestDataBuilder().build();
        RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);
        RepositorioPlato repositorioPlato = Mockito.mock(RepositorioPlato.class);
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioPlato.obtenerPrecio(Mockito.anyLong())).thenReturn(PRECIO_BANDEJA_PAISA);
        Mockito.when(repositorioVenta.obtenerCantidadGastada(Mockito.anyLong())).thenReturn(CANTIDAD_GASTADA);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearVenta servicioCrearVenta = new ServicioCrearVenta(repositorioVenta, repositorioPlato, repositorioCliente);
        servicioCrearVenta.ejecutar(venta);

        //act - assert
        assertEquals(PROMOCION, venta.isPromocion());
    }

    @Test
    public void ValidarExistenciaPreviaTest(){
        //arrange
        Venta venta = new SaleTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        RepositorioVenta repositorioVenta = Mockito.mock(RepositorioVenta.class);
        RepositorioPlato repositorioPlato = Mockito.mock(RepositorioPlato.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearVenta servicioCrearVenta = new ServicioCrearVenta(repositorioVenta, repositorioPlato, repositorioCliente);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearVenta.ejecutar(venta), ExcepcionValorInvalido.class, "El cliente no existe en el sistema, debe registrarse primero");
    }
}
