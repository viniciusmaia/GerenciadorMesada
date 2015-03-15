/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.BeneficiadoDAO;
import br.ifes.gerenciadormesada.dao.PatrocinadorDAO;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 20101bsi0267
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

    private String login;
    private String senha;
    private PatrocinadorDAO daoPatrocinador;
    private BeneficiadoDAO daoBeneficiado;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        daoBeneficiado = new BeneficiadoDAO();
        daoPatrocinador = new PatrocinadorDAO();
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void logar()
    {
        //Tente buscar um beneficiado
        Beneficiado beneficiado = daoBeneficiado.buscaPorLogin(this.login);
        
        
        //Verifica se encontrou um beneficiado
        if (beneficiado != null)
        {
            //Caso o beneficiado exista no sistema, verifica se a senha foi inserida corretamente
            if(beneficiado.getSenha().equals(this.senha))
            {
                //Caso os dados estejam corretos, efetua o login do beneficiado
                this.logaBeneficiado(beneficiado);
            }
            else
            {
                EscreveMensagem.escreveErro("Senha incorreta");
            }
        }
        
        //Se não foi encontrado um beneficiado, tenta encontrar um patrocinador
        Patrocinador patrocinador = daoPatrocinador.buscaPorLogin(this.login);
        
        if (patrocinador != null)
        {
            //Verifica se a senha do patrocinador está correta
            if(patrocinador.getSenha().equals(this.senha))
            {
                //loga o patrocinador
                this.logaPatrocinador(patrocinador);
            }
            else
            {
               EscreveMensagem.escreveErro("Senha incorreta"); 
            }
            
        }
        
        EscreveMensagem.escreveErro("O usuário não está cadastrado");
        
    }
    
    private void logaBeneficiado(Beneficiado beneficiado)
    {
        FacesContext context = FacesContext.getCurrentInstance();      
        
        HttpServletRequest request = ((HttpServletRequest) context.getExternalContext().getRequest());
        HttpServletResponse response = ((HttpServletResponse) context.getExternalContext().getResponse());
        
        //Insere o beneficiado na sessão
        this.setBeneficiadoSessao(beneficiado);
        
        try
        {
            //Direciona o usuário para a área de usuários logados do sistema
            response.sendRedirect((request.getContextPath()+"/templatelogado.jsf"));
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }       
    }
    
    private void setBeneficiadoSessao(Beneficiado beneficiado) 
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        session.setAttribute("usuario", beneficiado);
        
        session.setAttribute("TipoUsuario", "beneficiado");
    }
    
    
    
    private void logaPatrocinador(Patrocinador patrocinador)
    {
        FacesContext context = FacesContext.getCurrentInstance();      
        
        HttpServletRequest request = ((HttpServletRequest) context.getExternalContext().getRequest());
        HttpServletResponse response = ((HttpServletResponse) context.getExternalContext().getResponse());
        
        //Insere o beneficiado na sessão
        this.setPatrocinadorSessao(patrocinador);
        
        try
        {
            //Direciona o usuário para a área de usuários logados do sistema
            response.sendRedirect((request.getContextPath()+"/templatelogado.jsf"));
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
    private void setPatrocinadorSessao(Patrocinador patrocinador) 
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        session.setAttribute("usuario", patrocinador);
        
        session.setAttribute("TipoUsuario", "patrocinador");
    }
}
