package br.com.springboot.sistemadecompras.Controller;

import br.com.springboot.sistemadecompras.Entity.Produto;
import br.com.springboot.sistemadecompras.repository.RepositoryProduto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/produto")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

    private RepositoryProduto repositoryProduto;

    @RequestMapping(value="/api/v1/produto", method=RequestMethod.GET)
    public List<Produto> getAllProduto() {
        return repositoryProduto.findAll();
    }

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

}
