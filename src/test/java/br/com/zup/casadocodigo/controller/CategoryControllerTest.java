package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.repository.CategoryRepository;
import br.com.zup.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryRepository repository;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void shouldCreateCategory() throws Exception {
        Category category = new Category("Terror");

        when(repository.save(category)).thenReturn(category);

        mockMvc.perform(post("/api/v1/categories")
                .content(mapper.writeValueAsString(category))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
