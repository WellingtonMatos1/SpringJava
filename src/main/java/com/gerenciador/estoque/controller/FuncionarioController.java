package com.gerenciador.estoque.controller;

import com.gerenciador.estoque.model.Funcionario;
import com.gerenciador.estoque.service.FuncionarioService;
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
@Api("Api funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> listaFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listaFuncionarios());
    }
    
    @GetMapping("funcionario/{cod_fun}")
    @ApiOperation("Obter detalhes de um Funcionário")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Funcionário encontrado"),
        @ApiResponse(code = 404, message = "Funcionário não encontrado")
    })
    public ResponseEntity<Optional<Funcionario>> getByIdFuncionario(@PathVariable Integer cod_fun){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getByIdFuncionario(cod_fun));
    }

    @PostMapping("funcionario")
    public ResponseEntity<Funcionario> salvaFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvaFuncionario(funcionario));
    }

    @PutMapping("funcionario")
    public ResponseEntity<Funcionario> atualizaFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.atualizaFuncionario(funcionario));
    }
    
    /* @PathVariable vincula o parâmetro passado pelo método com a variável do path */
    @DeleteMapping("funcionario/{cod_fun}")
    public ResponseEntity<String> deleteByIdFuncionario(@PathVariable Integer cod_fun){
        funcionarioService.deleteByIdFuncionario(cod_fun);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario removido com sucesso");
    }    
}
