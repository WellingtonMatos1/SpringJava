package com.gerenciador.estoque.controller;

import com.gerenciador.estoque.model.Movimentacao;
import com.gerenciador.estoque.service.MovimentacaoService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api("Api Movimentação")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;
    
    @GetMapping("/movimentacao")
    public ResponseEntity<List<Movimentacao>> listaMovimentacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.listaMovimentacoes());
    }

    @GetMapping("movimentacao/{cod_mov}")
    public ResponseEntity<Optional<Movimentacao>> getByIdMovimentacao(@PathVariable Integer cod_mov){
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.getByIdMovimentacao(cod_mov));
    }

    @PostMapping("movimentacao")
    public ResponseEntity<Movimentacao> salvaProduto(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.salvaMovimentacao(movimentacao));
    }

}
