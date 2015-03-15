/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.gerenciadormesada.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20101bsi0267
 */
public class Mesada extends AbstractModelo{
    private double valor;
    private int ano;
    private int mes;
    private double recompensa;
    private double meta;
    private List<Gasto> gastos;
    private Beneficiado beneficiado;
    private Patrocinador patrocinador;

    public Mesada() {
        this.gastos = new ArrayList<Gasto>();
    }
    
    public void addGasto(Gasto gasto)
    {
        this.gastos.add(gasto);
    }

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
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the recompensa
     */
    public double getRecompensa() {
        return recompensa;
    }

    /**
     * @param recompensa the recompensa to set
     */
    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }    
    
}
