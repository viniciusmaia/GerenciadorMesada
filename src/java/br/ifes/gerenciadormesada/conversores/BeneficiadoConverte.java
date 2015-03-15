package br.ifes.gerenciadormesada.conversores;


import br.ifes.gerenciadormesada.entidades.BeneficiadoEntidade;
import br.ifes.gerenciadormesada.entidades.MesadaEntidade;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Mesada;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class BeneficiadoConverte implements IConverte<Beneficiado, BeneficiadoEntidade>
{

    @Override
    public Beneficiado EntidadeParaModelo(BeneficiadoEntidade entrada)
    {
        Beneficiado saida = new Beneficiado();
        
        saida.setId(entrada.getId());
        saida.setNome(entrada.getNome());
        saida.setEmail(entrada.getEmail());
        saida.setLogin(entrada.getLogin());
        saida.setSenha(entrada.getSenha());      
        
        return saida;
    }

    @Override
    public BeneficiadoEntidade ModeloParaEntidade(Beneficiado entrada) 
    {
        BeneficiadoEntidade saida = new BeneficiadoEntidade();
        
        saida.setId(entrada.getId());
        saida.setNome(entrada.getNome());
        saida.setEmail(entrada.getEmail());
        saida.setLogin(entrada.getLogin());
        saida.setSenha(entrada.getSenha());   
        
        return saida;    
    }    
   
}
