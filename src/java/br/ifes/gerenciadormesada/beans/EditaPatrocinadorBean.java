/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.PatrocinadorDAO;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import br.ifes.gerenciadormesada.util.RedirecionaLogin;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "editaPatrocinadorBean")
@RequestScoped
public class EditaPatrocinadorBean {

    private Patrocinador patrocinador;
    private final PatrocinadorDAO dao;
    private boolean desabilitaCampos;
    
    public EditaPatrocinadorBean()
    {        
        this.dao = new PatrocinadorDAO();
        this.desabilitaCampos = true;
        
        this.patrocinador = this.getPatrocinadorSessao();
        
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public boolean isDesabilitaCampos() {
        return desabilitaCampos;
    }

    public void habilitaCampos() 
    {
        this.desabilitaCampos = false;
    }
    
    private Patrocinador getPatrocinadorSessao()
    {
        FacesContext context = FacesContext.getCurrentInstance();   
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        Patrocinador p = (Patrocinador) session.getAttribute("usuario");
        
        if (p == null)
        {
            RedirecionaLogin.redireciona();
        }
        
        return  p;
    }
    
    public void remover()
    {
        try
        {
            this.dao.remover(this.patrocinador);
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
            this.dao.alterar(this.patrocinador);
            this.atualizaPatrocinadorSessao();
            this.desabilitaCampos = true;
            
            EscreveMensagem.escreveInformacao("Os dados foram atualizados");
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
    private void atualizaPatrocinadorSessao() 
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        session.setAttribute("usuario", this.patrocinador);
        
        session.setAttribute("TipoUsuario", "patrocinador");
    }
    
    
    
}
