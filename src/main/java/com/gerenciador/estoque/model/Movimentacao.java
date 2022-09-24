package com.gerenciador.estoque.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_mov")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "cod_for")
    private Fornecedor fornecedor;
      
    @ManyToOne
    @JoinColumn(name = "cod_fun")
    private Funcionario funcionario;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_prod")
    private List<Produto> produtos;

    public Movimentacao(){
    }
    
    public Movimentacao(Integer id, Funcionario funcionario, List<Produto> produtos) {
        this.id = id;
        this.funcionario = funcionario;
        this.produtos = produtos;
    }

    public Movimentacao(Integer id, Fornecedor fornecedor, List<Produto> produtos) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProdutos(Produto produto) {
        this.produtos.add(produto);
    }
    
    public void removeProdutos(Produto produto) {
        this.produtos.remove(produto);
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
