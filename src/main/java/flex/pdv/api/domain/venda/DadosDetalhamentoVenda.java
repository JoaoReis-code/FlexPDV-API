package flex.pdv.api.domain.venda;

import flex.pdv.api.domain.produto.Produto;

import java.time.LocalDateTime;

public record DadosDetalhamentoVenda(Long id, Long idProduto, Long quantidade, double valor, LocalDateTime data) {
    public DadosDetalhamentoVenda(Venda venda) {
        this(venda.getId(), venda.getProduto().getId(), venda.getQuantidade(),  venda.getValor(), venda.getData());
    }
}

