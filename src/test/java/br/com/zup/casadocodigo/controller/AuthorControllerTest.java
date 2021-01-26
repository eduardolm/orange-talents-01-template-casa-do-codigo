package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.AuthorDto;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void createAuthor() throws Exception {
        URI uri = new URI("/api/v1/authors");
        AuthorDto authorDto = new AuthorDto("Joshua Baker", "josh@email.com", "Test author");
        Author author = authorDto.toAuthor();

        var result = mockMvc.perform(post(uri)
                                        .contentType("application/json")
                                        .content(mapper.writeValueAsString(author)))
                                        .andExpect(status().isOk());

        System.out.println(result);
    }

}

