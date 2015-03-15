/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.entidades;

import java.io.Serializable;
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
@Table(name = "mesada")
public class MesadaEntidade implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "idbeneficiado", referencedColumnName = "id", nullable = false)
    private BeneficiadoEntidade beneficiado;
    
    @ManyToOne
    @JoinColumn(name = "idpatrocinador", referencedColumnName = "id", nullable = true)
    private PatrocinadorEntidade patrocinador;
    
    @Column(name = "ano", nullable = false)
    private int ano;
    
    @Column(name = "meta", nullable = true)
    private double meta;
    
    @Column(name = "mes", nullable = false)
    private int mes;
    
    @Column(name = "valor", nullable = false)
    private Double valor;
    
    @Column(name = "recompensa", nullable = true)
    private Double recompensa;

    public BeneficiadoEntidade getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoEntidade beneficiado) {
        this.beneficiado = beneficiado;
    }

    public PatrocinadorEntidade getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(PatrocinadorEntidade patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }    
    
}
