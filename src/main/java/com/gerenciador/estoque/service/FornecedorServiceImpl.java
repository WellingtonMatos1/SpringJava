package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Fornecedor;
import com.gerenciador.estoque.repository.FornecedorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorServiceImpl implements FornecedorService{
    
    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    @Override
    public Fornecedor salvaFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> listaFornecedores() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Optional<Fornecedor> getByIdFornecedor(Integer cod_for) {
        return fornecedorRepository.findById(cod_for);
    }

    @Override
    public Fornecedor atualizaFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void deleteByIdFornecedor(Integer cod_for) {
        fornecedorRepository.deleteById(cod_for);
    }
    
}

