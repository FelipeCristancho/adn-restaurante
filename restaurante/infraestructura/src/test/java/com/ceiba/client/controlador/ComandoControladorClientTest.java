package com.ceiba.client.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.client.comando.ComandoClient;
import com.ceiba.client.servicio.testdatabuilder.ComandoClientTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorClient.class)
public class ComandoControladorClientTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        //arrange
        ComandoClient client = new ComandoClientTestDataBuilder().build();

        //act - assert
        mocMvc.perform(post("/clients")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(client)))
        .andExpect(status().isOk())
        .andExpect(content().json("{valor : 2}"));
    }
}
