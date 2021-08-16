package br.com.springboot.sistemadecompras.repository;

import br.com.springboot.sistemadecompras.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Long> { }
