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
@Api(value = "Funcionários", tags = {"Funcionário"}, description = " ")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping("/funcionarios")
    @ApiOperation("Obter detalhes de todos Funcionários")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Os funcionários foram encontrados com sucesso!"),
        @ApiResponse(code = 404, message = "Nenhum funcionário foi encontrado!")
    })
    public ResponseEntity<List<Funcionario>> listaFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.listaFuncionarios());
    }
    
    @GetMapping("funcionario/{cod_fun}")
    @ApiOperation("Obter detalhes de um Funcionário")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O funcionário foi encontrado com sucesso!"),
        @ApiResponse(code = 404, message = "O funcionário não foi encontrado!")
    })
    public ResponseEntity<Optional<Funcionario>> getByIdFuncionario(@PathVariable Integer cod_fun){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.getByIdFuncionario(cod_fun));
    }

    @PostMapping("funcionario")
    @ApiOperation("Cadastrar um Funcionário")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O funcionário foi cadastrado com sucesso!"),
        @ApiResponse(code = 404, message = "O funcionário não pôde ser cadastrado!")
    })
    public ResponseEntity<Funcionario> salvaFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvaFuncionario(funcionario));
    }

    @PutMapping("funcionario")
    @ApiOperation("Atualizar um Funcionário")
    @ApiResponses({
        @ApiResponse(code = 200, message = "O funcionário foi atualizado com sucesso!"),
        @ApiResponse(code = 404, message = "O funcionário não pôde ser atualizado!")
    })
    public ResponseEntity<Funcionario> atualizaFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.atualizaFuncionario(funcionario));
    }
    
    /* @PathVariable vincula o parâmetro passado pelo método com a variável do path */
    @DeleteMapping("funcionario/{cod_fun}")
    @ApiOperation("Remover um Funcionário")
    public ResponseEntity<String> deleteByIdFuncionario(@PathVariable Integer cod_fun){
        funcionarioService.deleteByIdFuncionario(cod_fun);
        return ResponseEntity.status(HttpStatus.OK).body("O funcionario foi removido com sucesso");
    }    
}
