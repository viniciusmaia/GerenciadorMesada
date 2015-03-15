/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.conversores;

import br.ifes.gerenciadormesada.entidades.BeneficiadoEntidade;
import br.ifes.gerenciadormesada.entidades.GastoEntidade;
import br.ifes.gerenciadormesada.entidades.MesadaEntidade;
import br.ifes.gerenciadormesada.entidades.PatrocinadorEntidade;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Gasto;
import br.ifes.gerenciadormesada.modelo.Mesada;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class MesadaConverte implements IConverte<Mesada, MesadaEntidade>
{

    @Override
    public Mesada EntidadeParaModelo(MesadaEntidade entrada)
    {
        Mesada saida = new Mesada();
        
        saida.setAno(entrada.getAno());
        saida.setMes(entrada.getMes());
        saida.setRecompensa(entrada.getRecompensa());
        saida.setValor(entrada.getValor());
        saida.setId(entrada.getId());
        saida.setMeta(entrada.getMeta());
        
        Beneficiado beneficiado = this.beneficiadoEntidadeParaModelo(entrada.getBeneficiado());
        
        saida.setBeneficiado(beneficiado);
        
        if (entrada.getPatrocinador() != null)
        {
            Patrocinador patrocinador = this.patrocinadorEntidadeParaModelo(entrada.getPatrocinador());
            saida.setPatrocinador(patrocinador);
        }
        
        return saida;
    }

    @Override
    public MesadaEntidade ModeloParaEntidade(Mesada entrada) 
    {
        MesadaEntidade saida = new MesadaEntidade();
        
        saida.setAno(entrada.getAno());
        saida.setMes(entrada.getMes());
        saida.setRecompensa(entrada.getRecompensa());
        saida.setValor(entrada.getValor());
        saida.setId(entrada.getId());
        saida.setMeta(entrada.getMeta());
        
        BeneficiadoEntidade beneficiado = this.beneficiadoModeloParaEntidade(entrada.getBeneficiado());
        
        saida.setBeneficiado(beneficiado);
        
        if (entrada.getPatrocinador() != null)
        {
            PatrocinadorEntidade patrocinador = this.patrocinadorModeloParaEntidade(entrada.getPatrocinador());
            saida.setPatrocinador(patrocinador);
        }       
        
        return saida;
    }
    
    private Beneficiado beneficiadoEntidadeParaModelo(BeneficiadoEntidade entrada)
    {
        BeneficiadoConverte conversor = new BeneficiadoConverte();
        
        return conversor.EntidadeParaModelo(entrada);
    }
    
    private BeneficiadoEntidade beneficiadoModeloParaEntidade(Beneficiado entrada)
    {
        BeneficiadoConverte conversor = new BeneficiadoConverte();
        
        return conversor.ModeloParaEntidade(entrada);
    }
    
    private Patrocinador patrocinadorEntidadeParaModelo(PatrocinadorEntidade entrada)
    {
        PatrocinadorConverte conversor = new PatrocinadorConverte();
        
        return conversor.EntidadeParaModelo(entrada);
    }
    
    private PatrocinadorEntidade patrocinadorModeloParaEntidade(Patrocinador entrada)
    {
        PatrocinadorConverte conversor = new PatrocinadorConverte();
        
        return conversor.ModeloParaEntidade(entrada);
    }
    
}
