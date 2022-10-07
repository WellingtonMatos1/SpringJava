package com.gerenciador.estoque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_mov")
    private Integer codMov;
    
    @ManyToOne
    @JoinColumn(name = "cod_for")
    private Fornecedor fornecedor;
      
    @ManyToOne
    @JoinColumn(name = "cod_fun")
    private Funcionario funcionario;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_prod")
    private Produto produto;

    public Movimentacao(){
    }
    
    public Movimentacao(Integer codMov, Funcionario funcionario, Produto produto) {
        this.codMov = codMov;
        this.funcionario = funcionario;
        this.produto = produto;
    }

    public Movimentacao(Integer codMov, Fornecedor fornecedor, Produto produto) {
        this.codMov = codMov;
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public Integer getCodMov() {
        return codMov;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    public void addQuantidadeProduto(Fornecedor fornecedor, Produto produto, Integer quantidade){
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }
    
    public void removeQuantidadeProduto(Funcionario funcionario, Produto produto, Integer quantidade){
           produto.setQuantidade(produto.getQuantidade() - quantidade);
    }
    
    @Override
    public String toString() {
        return "";
    }
}
