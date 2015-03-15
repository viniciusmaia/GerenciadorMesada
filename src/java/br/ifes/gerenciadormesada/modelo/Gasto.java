/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.gerenciadormesada.modelo;

import java.util.Date;

/**
 *
 * @author 20101bsi0267
 */
public class Gasto extends AbstractModelo{
    private double valor;
    private String descricao;
    private Categoria gastoCategoria;
    private String data;
    private Mesada mesada;

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the gastoCategoria
     */
    public Categoria getCategoria() {
        return gastoCategoria;
    }

    /**
     * @param gastoCategoria the gastoCategoria to set
     */
    public void setCategoria(Categoria gastoCategoria) {
        this.gastoCategoria = gastoCategoria;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    public Mesada getMesada() {
        return mesada;
    }

    public void setMesada(Mesada mesada) {
        this.mesada = mesada;
    }  
}
