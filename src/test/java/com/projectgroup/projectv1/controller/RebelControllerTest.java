package com.projectgroup.projectv1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class RebelControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    void mustCreateARabelWithSucess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rebel")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "\t\"name\": \"Yoda\", \n"+
                        "\t\"age\": \"900\", \n"+
                        "\t\"gender\":\"MALE\", \n"+
                        "\t\"inventory\": {\n"+
                            "\t\t\"gun\": 10, \n"+
                            "\t\t\"ammo\": 10, \n"+
                            "\t\t\"water\": 10, \n"+
                            "\t\t\"food\": 10, \n"+
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.inventory").value(true));
    }
}
