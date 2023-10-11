package flex.pdv.api.domain.produto;

import java.time.LocalDateTime;

public record DadosListagemProduto(Long id, String nome, double valor, LocalDateTime validade) {

    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getValidade());
    }

}
