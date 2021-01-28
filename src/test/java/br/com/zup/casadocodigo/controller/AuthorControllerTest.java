package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import br.com.zup.casadocodigo.utils.builder.AuthorBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    public void listAuthors() throws Exception {
        Author author = new AuthorBuilder()
                .withName("Joshua Baker")
                .withEmail("josh@email.com")
                .withDescription("Test author")
                .build();

        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        doReturn(Lists.newArrayList(author)).when(repository).findAll();

        var response = mockMvc.perform(get("/api/v1/authors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals("Joshua Baker", mapper
                .readValue(response.getContentAsString(), new TypeReference<List<Author>>() {}).get(0).getName());
        assertEquals("josh@email.com", mapper
                .readValue(response.getContentAsString(), new TypeReference<List<Author>>() {}).get(0).getEmail());
        assertEquals("Test author", mapper
                .readValue(response.getContentAsString(), new TypeReference<List<Author>>() {}).get(0).getDescription());
    }

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

