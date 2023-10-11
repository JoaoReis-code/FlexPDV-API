package flex.pdv.api.domain.produto;

//Records servem para declarar objetos imutáveis de uma forma mais simples. Nesse caso, estão sendo usados apenas para passar dados.

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosListagemProduto(Long id, String nome, double valor, LocalDateTime validade) {

    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getValidade());
    }

}
