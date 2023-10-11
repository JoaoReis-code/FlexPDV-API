package flex.pdv.api.domain.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        double valor,
        String descricao,
        boolean ativo) {

}
