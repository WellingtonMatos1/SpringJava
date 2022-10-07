package com.gerenciador.estoque.controller;

import com.gerenciador.estoque.model.Fornecedor;
import com.gerenciador.estoque.service.FornecedorService;
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
@Api("Api fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;
    
    @GetMapping("/fornecedores")
    public ResponseEntity<List<Fornecedor>> listaFornecedores(){
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.listaFornecedores());
    }

    @GetMapping("fornecedor/{cod_for}")
    @ApiOperation("Obter detalhes de um Fornecedor")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Fornecedor encontrado"),
        @ApiResponse(code = 404, message = "Fornecedor não encontrado")
    })
    public ResponseEntity<Optional<Fornecedor>> getByIdFornecedor(@PathVariable Integer cod_for){
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.getByIdFornecedor(cod_for));
    }

    @PostMapping("fornecedor")
    public ResponseEntity<Fornecedor> salvaFornecedor(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorService.salvaFornecedor(fornecedor));
    }

    @PutMapping("fornecedor")
    public ResponseEntity<Fornecedor> atualizaFornecedor(@RequestBody Fornecedor fornecedor){
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.atualizaFornecedor(fornecedor));
    }
    
    @DeleteMapping("fornecedor/{cod_for}")
    public ResponseEntity<String> deleteByIdFuncionario(@PathVariable Integer cod_for){
        fornecedorService.deleteByIdFornecedor(cod_for);
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor removido com sucesso");
    }    
}
