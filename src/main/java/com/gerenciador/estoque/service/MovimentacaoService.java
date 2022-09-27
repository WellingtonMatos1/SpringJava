package com.gerenciador.estoque.service;

import com.gerenciador.estoque.model.Movimentacao;
import java.util.List;
import java.util.Optional;

public interface MovimentacaoService {
    
    public Movimentacao salvaMovimentacao(Movimentacao movimentacao);
    
    public List<Movimentacao> listaMovimentacoes();
    
    public Optional<Movimentacao> getByIdMovimentacao(Integer cod_mov);
}
