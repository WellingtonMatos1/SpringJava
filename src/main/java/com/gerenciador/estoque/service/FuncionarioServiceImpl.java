package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Funcionario;
import com.gerenciador.estoque.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Override
    public Funcionario salvaFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> listaFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> getByIdFuncionario(Integer cod_fun) {
        return funcionarioRepository.findById(cod_fun);
    }

    @Override
    public Funcionario atualizaFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteByIdFuncionario(Integer cod_fun) {
        funcionarioRepository.deleteById(cod_fun);
    }
    
}

