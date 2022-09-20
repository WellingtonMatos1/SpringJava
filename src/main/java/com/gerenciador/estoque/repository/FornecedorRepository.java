package com.gerenciador.estoque.repository;

import com.gerenciador.estoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    
}
