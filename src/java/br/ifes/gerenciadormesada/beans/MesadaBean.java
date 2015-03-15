/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;


import br.ifes.gerenciadormesada.dao.MesadaDAO;
import br.ifes.gerenciadormesada.modelo.Mesada;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "mesadaBean")
@RequestScoped
public class MesadaBean{

    private Mesada mesada;
    private MesadaDAO dao;  
    
    public MesadaBean() 
    {
        this.mesada = new Mesada();
        this.dao = new MesadaDAO();
    }    
    
    public Mesada getMesada()
    {
        return this.mesada;
    }

    public void setMesada(Mesada mesada) {
        this.mesada = mesada;
    }

    public MesadaDAO getDao() {
        return dao;
    }

    public void setDao(MesadaDAO dao) {
        this.dao = dao;
    }
    
    public void inserir()
    {
        try
        {
            Integer id = this.dao.inserir(this.mesada);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
    public void remover()
    {
        try
        {
            this.dao.remover(this.mesada);
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
            this.dao.alterar(this.mesada);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
}
