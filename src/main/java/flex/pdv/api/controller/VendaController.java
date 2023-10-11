package flex.pdv.api.controller;

import flex.pdv.api.domain.venda.*;
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


@RestController
@RequestMapping("/venda")
@SecurityRequirement(name = "bearer-key")
public class VendaController {
    @Autowired
    private VendaRepository repository;

    @Autowired
    private CriarVenda venda;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar uma venda")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVenda dados){
        var dto = venda.vender(dados);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Listar vendas")
    public ResponseEntity<Page<DadosDetalhamentoVenda>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosDetalhamentoVenda::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venda por id")
    public ResponseEntity detalhar(@PathVariable Long id){
        var venda = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoVenda(venda));
    }
}
