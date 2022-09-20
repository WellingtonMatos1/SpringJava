package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Produto;
import com.gerenciador.estoque.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public Produto salvaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> getByIdProduto(Integer cod_prod) {
        return produtoRepository.findById(cod_prod);
    }

    @Override
    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteByIdProduto(Integer cod_prod) {
        produtoRepository.deleteById(cod_prod);
    }
    
}

