package flex.pdv.api.domain.produto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotNull
        double valor,
        @NotNull
        @JsonFormat(pattern = "DD-MM-YYYY")
        String validade,
        String descricao) {
}
