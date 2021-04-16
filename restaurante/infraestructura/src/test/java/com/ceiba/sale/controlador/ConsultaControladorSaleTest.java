package com.ceiba.sale.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.client.controlador.ConsultaControladorClient;
import com.ceiba.dish.controlador.ConsultaControladorDish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
@WebMvcTest({ConsultaControladorClient.class, ConsultaControladorDish.class})
public class ConsultaControladorSaleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception{
        mockMvc.perform(get("/sale")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].id",is(1)))
            .andExpect(jsonPath("$[0].saleDate",is(LocalDate.now().toString())))
            .andExpect(jsonPath("$[0].dish",is("Bandeja Paisa")))
            .andExpect(jsonPath("$[0].client",is("Ivan Cristancho")))
            .andExpect(jsonPath("$[0].promotion",is(1)));
    }

    @Test
    public void listByClient() throws Exception {
        //arrange
        Long client = 1L;

        mockMvc.perform(get("/sale/client/{id}",client)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].saleDate",is(LocalDate.now().toString())))
                .andExpect(jsonPath("$[0].dish",is("Bandeja Paisa")))
                .andExpect(jsonPath("$[0].client",is("Ivan Cristancho")))
                .andExpect(jsonPath("$[0].promotion",is(1)));
    }
}
