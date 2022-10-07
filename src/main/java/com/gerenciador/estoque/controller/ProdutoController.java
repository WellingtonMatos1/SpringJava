package com.gerenciador.estoque.controller;

import com.gerenciador.estoque.model.Produto;
import com.gerenciador.estoque.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api("Api produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listaProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProdutos());
    }

    @GetMapping("produto/{cod_prod}")
    @ApiOperation("Obter detalhes de um Produto")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Produto encontrado"),
        @ApiResponse(code = 404, message = "Produto não encontrado")
    })
    public ResponseEntity<Optional<Produto>> getByIdProduto(@PathVariable Integer cod_prod){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getByIdProduto(cod_prod));
    }

    @PostMapping("produto")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvaProduto(produto));
    }

    @PutMapping("produto")
    public ResponseEntity<Produto> atualizaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizaProduto(produto));
    }
    
    @DeleteMapping("produto/{cod_prod}")
    public ResponseEntity<String> deleteByIdProduto(@PathVariable Integer cod_prod){
        produtoService.deleteByIdProduto(cod_prod);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
    }    
}
