package br.com.springboot.sistemadecompras.controller;

import br.com.springboot.sistemadecompras.entity.Produto;
import br.com.springboot.sistemadecompras.repository.RepositoryProduto;
import br.com.springboot.sistemadecompras.service.ServiceProduto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

    private ServiceProduto serviceProduto;

    @GetMapping
    public List<Produto> getAllProduto() {
        return serviceProduto.listAll();
    }

    /*
    @RequestMapping(value="/api/v1/produto/{id}", method=RequestMethod.GET)
    public ResponseEntity<Produto> getById(@PathVariable(value="id") Long id) {
        Optional<Produto> produto = repositoryProduto.findById(id);
        if(produto.isPresent())
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/api/v1/produto", method=RequestMethod.POST)
    public Produto post(@Valid @RequestBody Produto produto) {
        return repositoryProduto.save(produto);
    }

    @RequestMapping(value="/api/v1/produto/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Produto> put(@PathVariable(value="id") Long id, @Valid @RequestBody Produto newProduto) {
        Optional<Produto> oldProduto = repositoryProduto.findById(id);
        if(oldProduto.isPresent()){
            Produto produto = oldProduto.get();
            produto.setNome(newProduto.getNome());
            produto.setMarca(newProduto.getMarca());
            produto.setPrecoUnitario(newProduto.getPrecoUnitario());
            produto.setNumeroDeSerie(newProduto.getNumeroDeSerie());
            repositoryProduto.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/api/v1/produto/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Produto> delete(@PathVariable(value="id") Long id) {
        Optional<Produto> produto = repositoryProduto.findById(id);
        if(produto.isPresent()){
            repositoryProduto.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
     */
}
