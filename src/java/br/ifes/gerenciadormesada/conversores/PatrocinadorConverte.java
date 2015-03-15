/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.conversores;

import br.ifes.gerenciadormesada.entidades.BeneficiadoEntidade;
import br.ifes.gerenciadormesada.entidades.PatrocinadorEntidade;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Patrocinador;

/**
 *
 * @author Vinicius
 */
public class PatrocinadorConverte implements IConverte<Patrocinador, PatrocinadorEntidade>{

    @Override
    public Patrocinador EntidadeParaModelo(PatrocinadorEntidade entrada)
    {
        Patrocinador saida = new Patrocinador();
        
        saida.setId(entrada.getId());
        saida.setNome(entrada.getNome());
        saida.setEmail(entrada.getEmail());
        saida.setLogin(entrada.getLogin());
        saida.setSenha(entrada.getSenha());
        
       Beneficiado beneficiado = this.beneficiadoEntidadeParaModelo(entrada.getBeneficiado());
        
        saida.setBeneficiado(beneficiado);
        
        return saida;
    }

    @Override
    public PatrocinadorEntidade ModeloParaEntidade(Patrocinador entrada) 
    {
        PatrocinadorEntidade saida = new PatrocinadorEntidade();
        
        saida.setId(entrada.getId());
        saida.setNome(entrada.getNome());
        saida.setEmail(entrada.getEmail());
        saida.setLogin(entrada.getLogin());
        saida.setSenha(entrada.getSenha());     
        
        BeneficiadoEntidade beneficiadoEntidade = this.beneficiadoModeloParaEntidade(entrada.getBeneficiado());
        
        saida.setBeneficiado(beneficiadoEntidade);
        
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
}
