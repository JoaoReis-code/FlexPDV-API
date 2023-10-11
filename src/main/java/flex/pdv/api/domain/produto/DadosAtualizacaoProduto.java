package flex.pdv.api.domain.produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        double valor,
        String descricao,
        boolean ativo) {

}
