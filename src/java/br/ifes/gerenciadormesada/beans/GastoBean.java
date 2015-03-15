/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.CategoriaDAO;
import br.ifes.gerenciadormesada.dao.GastoDAO;
import br.ifes.gerenciadormesada.modelo.Categoria;
import br.ifes.gerenciadormesada.modelo.Gasto;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "gastoBean")
@RequestScoped
public class GastoBean{

    private Gasto gasto;
    private GastoDAO dao;  
    
    public GastoBean() 
    {
        this.gasto = new Gasto();
        this.dao = new GastoDAO();
    }    
    
    public Gasto getGasto()
    {
        return this.gasto;
    }

    public void setBeneficiado(Gasto gasto) {
        this.gasto = gasto;
    }

    public GastoDAO getDao() {
        return dao;
    }

    public void setDao(GastoDAO dao) {
        this.dao = dao;
    }
    
    public void inserir()
    {
        try
        {
            Integer id = this.dao.inserir(this.gasto);
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
            this.dao.remover(this.gasto);
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
            this.dao.alterar(this.gasto);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
    
}
