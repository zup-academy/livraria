package com.zupedu.livraria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LivroControllerTeste {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testeDeInclusaoDeLivro() throws Exception {

        var jsonRequest ="{\n" +
                "\t\"titulo\":\"Memórias Póstumas de Brás Cubas\",\n" +
                "\t\"valor\":20,\n" +
                "\t\"numeroPaginas\":256,\n" +
                "\t\"isbn\":222332564,\n" +
                "\t\"dataPublicacao\":\"03-01-2022\",\n" +
                "\t\"idAutor\":1\n" +
                "}";

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/livros")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

    }
}
