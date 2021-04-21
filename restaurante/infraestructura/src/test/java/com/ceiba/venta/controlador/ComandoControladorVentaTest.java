package com.ceiba.venta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.controlador.ConsultaControladorClient;
import com.ceiba.plato.controlador.ConsultaControladorPlatoTest;
import com.ceiba.venta.comando.ComandoVenta;
import com.ceiba.venta.servicio.testdatabuilder.ComandoSaleTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest({ConsultaControladorClient.class, ConsultaControladorPlatoTest.class})
public class ComandoControladorVentaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        //arrange
        ComandoVenta comandoVenta = new ComandoSaleTestDataBuilder().build();

        //act - assert
        mocMvc.perform(post("/ventas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoVenta)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor' : 2}"));
    }
}
