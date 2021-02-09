package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.utils.builder.AuthorBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldCreateAuthor() throws Exception {
    Author author = new AuthorBuilder()
            .withName("Joshua Baker")
            .withEmail("josh@email.com")
            .withDescription("Test author")
            .build();

    when(repository.save(author)).thenReturn(author);

        mockMvc.perform(post("/api/v1/authors")
                .content(mapper.writeValueAsString(author))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

