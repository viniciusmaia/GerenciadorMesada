/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.BeneficiadoDAO;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "beneficiadoBean")
@SessionScoped
public class BeneficiadoBean
{
    private Beneficiado beneficiado;
    private Patrocinador patrocinador;
    private final BeneficiadoDAO dao;
    private boolean desabilitaCampos;
    
    public BeneficiadoBean() 
    {
        this.beneficiado = new Beneficiado();
        this.dao = new BeneficiadoDAO();
        this.desabilitaCampos = true;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }
    
    
    
    public Beneficiado getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(Beneficiado objeto) {
        this.beneficiado = objeto;
    }   

    public boolean isDesabilitaCampos() {
        return desabilitaCampos;
    }

    public void setDesabilitaCampos(boolean habilitaCampos) {
        this.desabilitaCampos = habilitaCampos;
    }    
    
    
    public void inserir()
    {        
        try
        {
            Integer id = this.dao.inserir(this.beneficiado);
            if (id != null)
            {
                this.beneficiado.setId(id);
                EscreveMensagem.escreveInformacao("Cadastro efetuado");
            }
        }
        catch(HibernateException e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        
        }
        
    }     
}
