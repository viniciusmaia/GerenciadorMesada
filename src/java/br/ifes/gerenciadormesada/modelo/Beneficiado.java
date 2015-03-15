package br.ifes.gerenciadormesada.modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author 20101bsi0267
 */
public class Beneficiado extends AbstractModelo{
    
    private String login;
    private String senha;
    private String nome;
    private String email;
    private List<Mesada> mesadas;
    

    public List<Mesada> getMesadas() {
        if (this.mesadas != null)
        {
            return mesadas;
        }
        return null;
    }

    public void setMesadas(List<Mesada> mesadas) 
    {        
        this.mesadas = mesadas;
    }
    
    public void addMesada(Mesada mesada)
    {
        if (this.mesadas == null)
        {
            this.mesadas = new ArrayList<Mesada>();
        }
        
        this.mesadas.add(mesada);
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void cadastarMesada() {
        
    }
    
    public void cadastrarMeta() {
        
    }
    
    public void cadastrarGasto() {
        
    }
}
