/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.util.RedirecionaLogin;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "menuLogadoBean")
@RequestScoped
public class MenuLogadoBean {

    
    public MenuLogadoBean() {
    }
    
    public String redirecionaUsuario()
    { 
        
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        String tipoUsuario = (String) session.getAttribute("TipoUsuario");
        
        if (tipoUsuario != null)
        {
            return "edita" + tipoUsuario;
        }
        
        return "home";
    }
}
