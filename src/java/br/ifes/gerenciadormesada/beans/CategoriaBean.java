/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.beans;

import br.ifes.gerenciadormesada.dao.AbstractDAO;
import br.ifes.gerenciadormesada.dao.BeneficiadoDAO;
import br.ifes.gerenciadormesada.dao.CategoriaDAO;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Categoria;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean
{

    private Categoria categoria;
    private CategoriaDAO dao;  
    
    public CategoriaBean() 
    {
        this.categoria = new Categoria();
        this.dao = new CategoriaDAO();
    }    
    
    public Categoria getCategoria()
    {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO getDao() {
        return dao;
    }

    public void setDao(CategoriaDAO dao) {
        this.dao = dao;
    }
    
    public void inserir()
    {
        try
        {
            Integer id = this.dao.inserir(this.categoria);
            if (id != null)
            {
                this.categoria.setId(id);
            }
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
            this.dao.remover(this.categoria);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());;
        }
    }
    
    public void alterar()
    {
        try
        {
            this.dao.alterar(this.categoria);
        }
        catch(Exception e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
    }
    
}
