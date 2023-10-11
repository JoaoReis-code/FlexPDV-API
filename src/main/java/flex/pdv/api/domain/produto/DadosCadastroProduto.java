package flex.pdv.api.domain.produto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotNull
        double valor,
        @NotNull
        @Future
        LocalDateTime validade,
        String descricao) {
}
