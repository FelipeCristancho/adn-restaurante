package com.ceiba.venta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.controlador.ConsultaControladorClient;
import com.ceiba.plato.controlador.ConsultaControladorPlatoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest({ConsultaControladorClient.class, ConsultaControladorPlatoTest.class})
public class ConsultaControladorVentaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception{
        mockMvc.perform(get("/ventas")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].id",is(1)))
            .andExpect(jsonPath("$[0].fecha",is(LocalDate.now().toString())))
            .andExpect(jsonPath("$[0].plato",is("Bandeja Paisa")))
            .andExpect(jsonPath("$[0].cliente",is("Ivan Cristancho")))
            .andExpect(jsonPath("$[0].promocion",is(true)));
    }

    @Test
    public void listByClient() throws Exception {
        //arrange
        Long client = 1L;

        mockMvc.perform(get("/ventas/cliente/{id}",client)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].fecha",is(LocalDate.now().toString())))
                .andExpect(jsonPath("$[0].plato",is("Bandeja Paisa")))
                .andExpect(jsonPath("$[0].cliente",is("Ivan Cristancho")))
                .andExpect(jsonPath("$[0].promocion",is(true)));
    }
}
