package flex.pdv.api.domain.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosDetalhamentoProduto(Long id, String nome, double valor, String validade, String descricao) {
        public DadosDetalhamentoProduto(Produto produto){
            this(produto.getId(), produto.getNome(), produto.getValor(), produto.getValidade(), produto.getDescricao());
        }
}
