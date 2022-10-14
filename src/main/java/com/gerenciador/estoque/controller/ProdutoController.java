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
@Api(value = "Produto", tags = {"Produto"}, description = " ")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/produtos")
    @ApiOperation("Obter detalhes de todos Produtos")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Os produtos foram encontrados!"),
        @ApiResponse(code = 404, message = "Nenhum produto não foi encontrado!")
    })
    public ResponseEntity<List<Produto>> listaProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProdutos());
    }

    @GetMapping("produto/{cod_prod}")
    @ApiOperation("Obter detalhes de um Produto")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O produto foi encontrado!"),
        @ApiResponse(code = 404, message = "O produto não foi encontrado!")
    })
    public ResponseEntity<Optional<Produto>> getByIdProduto(@PathVariable Integer cod_prod){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getByIdProduto(cod_prod));
    }

    @PostMapping("produto")
    @ApiOperation("Cadastrar um Produto")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O produto foi cadastrado com sucesso!"),
        @ApiResponse(code = 404, message = "O produto não pôde ser cadastrado!")
    })
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvaProduto(produto));
    }

    @PutMapping("produto")
    @ApiOperation("Atualizar um Produto")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O produto foi atualizado com sucesso!"),
        @ApiResponse(code = 404, message = "O produto não pôde ser atualizado!")
    })
    public ResponseEntity<Produto> atualizaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizaProduto(produto));
    }
    
    @DeleteMapping("produto/{cod_prod}")
    @ApiOperation("Remover um Produto")
    public ResponseEntity<String> deleteByIdProduto(@PathVariable Integer cod_prod){
        produtoService.deleteByIdProduto(cod_prod);
        return ResponseEntity.status(HttpStatus.OK).body("O produto foi removido com sucesso");
    }    
}
