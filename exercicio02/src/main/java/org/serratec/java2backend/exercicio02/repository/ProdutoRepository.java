package org.serratec.java2backend.exercicio02.repository;

import org.serratec.java2backend.exercicio02.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
