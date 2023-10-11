package flex.pdv.api.domain.venda;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroVenda(
        @NotNull
        Long idProduto,
        @NotNull
        Long quantidade,
        @NotNull
        LocalDateTime data) {
}
