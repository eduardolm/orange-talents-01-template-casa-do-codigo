package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.repository.BookRepository;
import br.com.zup.casadocodigo.utils.builder.AuthorBuilder;
import br.com.zup.casadocodigo.utils.builder.BookBuilder;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void listBooks() throws Exception {
        Author author = new AuthorBuilder()
                .withName("Joshua Baker")
                .withEmail("josh@email.com")
                .withDescription("Test author")
                .build();

        Category category = new Category(" Terror");

        Book book = new BookBuilder()
                .withTitle("A vida de Pi")
                .withAbstract("História fantástica sobre menino que, após um naufrágio, fica preso num bote...")
                .withSummary("Markdown summary text")
                .withPrice(new BigDecimal("125.54"))
                .withPages(135).withIsbn("123654")
                .withToBePublishedAt(LocalDate.of(2021, 10, 15))
                .withCategory(category)
                .withAuthor(author)
                .build();

        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

        doReturn(Lists.newArrayList(book)).when(repository).findAll();

        var response = mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals("A vida de Pi", mapper
                .readValue(response.getContentAsString(), new TypeReference<List<Book>>() {}).get(0).getTitle());
    }
}
