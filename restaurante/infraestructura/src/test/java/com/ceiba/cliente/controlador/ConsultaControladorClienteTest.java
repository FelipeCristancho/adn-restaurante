package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorClient.class)
public class ConsultaControladorClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        //arrange

        //act - assert
        mockMvc.perform(get("/clients")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].name", is("Ivan")))
        .andExpect(jsonPath("$[0].last_name", is("Cristancho")))
        .andExpect(jsonPath("$[0].telephone", is("1234567890")));
    }

    @Test
    public void mejorClient() throws Exception {
        //arrange

        //act - assert
        mockMvc.perform(get("/clients/mejor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Ivan")))
                .andExpect(jsonPath("$[0].last_name", is("Cristancho")))
                .andExpect(jsonPath("$[0].telephone", is("1234567890")))
                .andExpect(jsonPath("$[0].totalPurchases", is(1)));
    }
}
