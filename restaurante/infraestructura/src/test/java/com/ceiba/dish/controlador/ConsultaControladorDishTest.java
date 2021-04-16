package com.ceiba.dish.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.client.controlador.ConsultaControladorClient;
import com.ceiba.sale.controlador.ConsultaControladorSale;
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
@WebMvcTest({ConsultaControladorClient.class, ConsultaControladorDish.class, ConsultaControladorSale.class})
public class ConsultaControladorDishTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception{
        //arrange

        //act - assert
        mockMvc.perform(get("/dish")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].dishId", is(1)))
        .andExpect(jsonPath("$[0].dishName", is("Bandeja Paisa")))
        .andExpect(jsonPath("$[0].price", is(15000.0)));
    }

    @Test
    public void listarByClient() throws Exception{
        //arrange

        //act - assert
        mockMvc.perform(get("/dish/mejor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].dishId", is(1)))
                .andExpect(jsonPath("$[0].dishName", is("Bandeja Paisa")))
                .andExpect(jsonPath("$[0].price", is(15000.0)));
    }
}
