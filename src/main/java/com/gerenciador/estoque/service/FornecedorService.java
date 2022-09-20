package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Fornecedor;
import java.util.List;
import java.util.Optional;

public interface FornecedorService {
    
    public Fornecedor salvaFornecedor(Fornecedor fornecedor);
    
    public List<Fornecedor> listaFornecedores();
    
    public Optional<Fornecedor> getByIdFornecedor(Integer cod_for);
    
    public Fornecedor atualizaFornecedor(Fornecedor fornecedor);
    
    public void deleteByIdFornecedor(Integer cod_for);
}
