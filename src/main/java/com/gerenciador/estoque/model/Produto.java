package com.gerenciador.estoque.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_prod")
    private Integer codProduto;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor",referencedColumnName = "cod_for")
    private Fornecedor fornecedor;
    
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_mov", referencedColumnName = "cod_mov")
    private Integer codMov;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name="quantidade")
    private Integer quantidade;

    public Produto() {
    }

    public Produto(Integer codProduto, Fornecedor fornecedor, Integer codMov, String nome, String descricao, String tipo, int quantidade) {
        this.codProduto = codProduto;
        this.fornecedor = fornecedor;
        this.codMov = codMov;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public Integer getCodProduto() {
        return codProduto;
    }
    
     public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
     public Integer getCodMov() {
        return codMov;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    
    protected void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", fornecedor=" + fornecedor + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + ", quantidade=" + quantidade + '}';
    }
     
}