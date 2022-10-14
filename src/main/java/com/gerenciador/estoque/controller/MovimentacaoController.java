package com.gerenciador.estoque.controller;

import com.gerenciador.estoque.model.Movimentacao;
import com.gerenciador.estoque.service.MovimentacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Movimentação", tags = {"Movimentação"}, description = " ")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;
    
    @GetMapping("/movimentacoes")
    @ApiOperation("Obter detalhes de todas Movimentações")
    @ApiResponses({
        @ApiResponse(code = 200, message = "As movimentação foram encontradas com sucesso!"),
        @ApiResponse(code = 404, message = "Nenhuma movimentação foi encontrada!")
    })
    public ResponseEntity<List<Movimentacao>> listaMovimentacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.listaMovimentacoes());
    }

    @GetMapping("movimentacao/{cod_mov}")
    @ApiOperation("Obter detalhes de uma Movimentação")
    @ApiResponses({
        @ApiResponse(code = 200, message = "A movimentação foi encontrada com sucesso!"),
        @ApiResponse(code = 404, message = "A movimentação não foi encontrada!")
    })
    public ResponseEntity<Optional<Movimentacao>> getByIdMovimentacao(@PathVariable Integer cod_mov){
        return ResponseEntity.status(HttpStatus.OK).body(movimentacaoService.getByIdMovimentacao(cod_mov));
    }

    @PostMapping("movimentacao")
    @ApiOperation("Cadastrar uma Movimentação")
    @ApiResponses({
        @ApiResponse(code = 200, message = "A movimentação foi cadastrada com sucesso!"),
        @ApiResponse(code = 404, message = "A movimentação não pôde ser cadastrada!")
    })
    public ResponseEntity<Movimentacao> salvaMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.salvaMovimentacao(movimentacao));
    }
}
