package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    
    public Produto salvaProduto(Produto fornecedor);
    
    public List<Produto> listaProdutos();
    
    public Optional<Produto> getByIdProduto(Integer cod_prod);
    
    public Produto atualizaProduto(Produto produto);
    
    public void deleteByIdProduto(Integer cod_prod);
}
