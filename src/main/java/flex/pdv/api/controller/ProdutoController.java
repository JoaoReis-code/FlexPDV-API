package flex.pdv.api.controller;

import flex.pdv.api.domain.produto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/produto")
@SecurityRequirement(name = "bearer-key")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar um produto")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
        var produto = new Produto(dados);
        repository.save(produto);

        var uri = uriBuilder.path("/produto/id/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping("all")
    @Operation(summary = "Listar todos produtos")
    public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("ativos")
    @Operation(summary = "Listar produtos ativos")
    public ResponseEntity<Page<DadosListagemProduto>> listarAtivos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("inativos")
    @Operation(summary = "Listar produtos inativos")
    public ResponseEntity<Page<DadosListagemProduto>> listarInativos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoFalse(paginacao).map(DadosListagemProduto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar produto")
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados){
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Excluir um produto por id")
    public ResponseEntity excluir(@PathVariable Long id){
        var produto = repository.getReferenceById(id);
        produto.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("id/{id}")
    @Operation(summary = "Buscar um produto por id")
    public ResponseEntity detalhar(@PathVariable Long id){
        var produto = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping("nome/{nome}")
    @Operation(summary = "Buscar um produto por nome")
    public ResponseEntity detalhar(@PathVariable String nome){
        var produto = repository.getReferenceByNome(nome);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }
}
