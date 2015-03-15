/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.BeneficiadoDAO;
import br.ifes.gerenciadormesada.dao.PatrocinadorDAO;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.HibernateException;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "patrocinadorBean")
@SessionScoped
public class PatrocinadorBean
{
    private Patrocinador patrocinador;
    private final PatrocinadorDAO dao; 
    private Beneficiado beneficiado;
    
    public PatrocinadorBean() 
    {
        this.patrocinador = new Patrocinador();
        this.dao = new PatrocinadorDAO();
    }    
    
    public Patrocinador getPatrocinador()
    {
        return this.patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    } 

    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado beneficiado) {
        this.beneficiado = beneficiado;
    }    
    
    public void inserir()
    {
        if (this.beneficiado == null)
        {
            EscreveMensagem.escreveErro("Favor cadastrar um beneficiado");
        }
        else
        {            
            try
            {
                this.insereBeneficiado();
                
                this.patrocinador.setBeneficiado(this.beneficiado);
                Integer id = this.dao.inserir(this.patrocinador);
                
                if (id != null)
                {
                    this.patrocinador.setId(id);
                    EscreveMensagem.escreveInformacao("Cadastro efetuado");
                }
                else
                {
                    EscreveMensagem.escreveErro("Falha não identificada");
                }
            }
            catch(HibernateException e)
            {
                EscreveMensagem.escreveErro(e.getMessage());
            }
        }
    }
    
    private void insereBeneficiado()
    {
        BeneficiadoDAO beneficiadoDao = new BeneficiadoDAO();
        
        Integer id = beneficiadoDao.inserir(this.beneficiado);
        
        this.beneficiado.setId(id);
    }
    
}
