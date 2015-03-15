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
import br.ifes.gerenciadormesada.util.RedirecionaLogin;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "editaBeneficiadoBean")
@SessionScoped
public class EditaBeneficiadoBean {

    private Beneficiado beneficiado;
    private final BeneficiadoDAO dao;
    private boolean desabilitaCampos;
    
    public EditaBeneficiadoBean() 
    {
        this.beneficiado = this.getBeneficiadoSessao();
        
        this.dao = new BeneficiadoDAO();
        this.desabilitaCampos = true;
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

    public void habilitaCampos() 
    {
        this.desabilitaCampos = false;
    }
    
    private Beneficiado getBeneficiadoSessao()
    {
        FacesContext context = FacesContext.getCurrentInstance();   
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        Beneficiado b = (Beneficiado) session.getAttribute("usuario");
        
        if (b == null)
        {
            RedirecionaLogin.redireciona();
        }
        
        return  b;
    }
    
    public void remover()
    {
        try
        {
            this.dao.remover(this.beneficiado);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
    public void alterar()
    {
        try
        {
            this.dao.alterar(this.beneficiado);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
}
