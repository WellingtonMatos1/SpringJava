package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Funcionario;
import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    
    public Funcionario salvaFuncionario(Funcionario funcionario);
    
    public List<Funcionario> listaFuncionarios();
    
    /*Optional evita exceções como ponteiros nulos por exemplo */
    public Optional<Funcionario> getByIdFuncionario(Integer cod_fun);
    
    public Funcionario atualizaFuncionario(Funcionario funcionario);
    
    public void deleteByIdFuncionario(Integer cod_fun);
}
