package flex.pdv.api.domain.venda;

import flex.pdv.api.infra.exception.ValidacaoException;
import flex.pdv.api.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarVenda {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public DadosDetalhamentoVenda vender(DadosCadastroVenda dados){
        if(!produtoRepository.existsById(dados.idProduto())){
            throw new ValidacaoException("Id do produto inexistente");
        }
        var produto = produtoRepository.findById(dados.idProduto()).get();
        double valor = produto.getValor() * dados.quantidade();

        var venda = new Venda(null, produto, dados.quantidade(), dados.data(), valor);

        vendaRepository.save(venda);

        return new DadosDetalhamentoVenda(venda);
    }
}
