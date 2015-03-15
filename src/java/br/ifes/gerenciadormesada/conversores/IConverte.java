package br.ifes.gerenciadormesada.conversores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public interface IConverte<Modelo, Entidade>
{
    public Modelo EntidadeParaModelo(Entidade entidade);
    
    public Entidade ModeloParaEntidade(Modelo modelo);
}
