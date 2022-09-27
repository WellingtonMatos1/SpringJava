package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Movimentacao;
import com.gerenciador.estoque.repository.MovimentacaoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
    
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    
    @Override
    public Movimentacao salvaMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @Override
    public List<Movimentacao> listaMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    @Override
    public Optional<Movimentacao> getByIdMovimentacao(Integer cod_mov) {
        return movimentacaoRepository.findById(cod_mov);
    }
    
}

