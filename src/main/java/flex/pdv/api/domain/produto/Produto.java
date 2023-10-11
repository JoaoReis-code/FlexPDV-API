package flex.pdv.api.domain.produto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produtos")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private double valor;

    @NotNull
    @JsonFormat(pattern = "DD/MM/YYYY")
    private String validade;

    private String descricao;
    private Boolean ativo;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.validade = dados.validade();
        this.descricao = dados.descricao();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.valor() != 0) {
            this.valor = dados.valor();
        }
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.ativo()) {
            this.ativo = dados.ativo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
