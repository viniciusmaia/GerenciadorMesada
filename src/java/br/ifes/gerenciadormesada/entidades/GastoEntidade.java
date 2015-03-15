/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.entidades;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "gasto")
public class GastoEntidade implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Column(name = "descricao", nullable = true)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false, referencedColumnName = "id")
    private CategoriaEntidade categoria;
    
    @ManyToOne
    @JoinColumn(name = "idmesada", nullable = false, referencedColumnName = "id")
    private MesadaEntidade mesada;
    
    @Column(name = "datagasto", nullable = false)
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public MesadaEntidade getMesada() {
        return mesada;
    }

    public void setMesada(MesadaEntidade mesada) {
        this.mesada = mesada;
    }

    public CategoriaEntidade getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntidade categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
