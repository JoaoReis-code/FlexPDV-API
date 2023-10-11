package flex.pdv.api.domain.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Os repositorys no Spring são interfaces que permitem a manipulação e o acesso aos dados de uma maneira mais fácil e organizada.

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findAllByAtivoTrue(Pageable paginacao);
}
