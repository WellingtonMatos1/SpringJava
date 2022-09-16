package com.gerenciador.estoque.repository;

import com.gerenciador.estoque.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
}
