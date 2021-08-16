package br.com.springboot.sistemadecompras.service;

import br.com.springboot.sistemadecompras.entity.Produto;
import br.com.springboot.sistemadecompras.repository.RepositoryProduto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceProduto {
    private final RepositoryProduto repositoryProduto;

    public List<Produto> listAll() {
        List<Produto> allProduto = repositoryProduto.findAll();
        return allProduto;
    }

}
