package com.ceiba.client.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.client.modelo.entidad.Client;
import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.client.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearClienteTest {

    @Test
    public void ValidarExistenciaPreviaTest(){
        //arrange
        Client client = new ClienteTestDataBuilder().build();
        RepositorioClient repositorioClient = Mockito.mock(RepositorioClient.class);
        Mockito.when(repositorioClient.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearClient servicioCrearClient = new ServicioCrearClient(repositorioClient);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearClient.ejecutar(client), ExcepcionDuplicidad.class, "El cliente ya existe en el sistema");
    }
}
