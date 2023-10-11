package flex.pdv.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Retorna erro 400 quando recebe JSON vazio")
    @WithMockUser
    void cadastro() throws Exception{
        var resposta = mvc.perform(post("/produto")).andReturn().getResponse();

        assertThat(resposta.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }
}