/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.dao;

import br.ifes.gerenciadormesada.conexao.HibernateUtil;
import br.ifes.gerenciadormesada.conversores.IConverte;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Vinicius
 * @param <Entidade>
 */
public abstract class AbstractDAO<Entidade extends Serializable>
{
    protected Session sessao;
    protected Transaction transacao;
    
    protected void iniciaOperacao()
    {
        //abre um sessão com o banco de dados.
        sessao = HibernateUtil.getSessionFactory().openSession();
        //inicia um transacao
        transacao = sessao.beginTransaction();
    }
    
    public Integer inserir(Entidade entidade) throws ExceptionInInitializerError, HibernateException
    {
        Integer id;
        this.sessao= null;
        this.transacao = null;
        try
        {
            this.iniciaOperacao();
                        
            //salva o usuário
            id = (Integer)sessao.save(entidade);
            //confirma a transacao
            transacao.commit();
            
            return id;

        }
        catch(HibernateException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                //fecha a sessao com o banco de dados
                this.sessao.close();
            }
            catch(Throwable e)
            {
                throw new ExceptionInInitializerError("Erro no acesso ao banco de dados. Erro:"+ e.getMessage());
            }
        }
    }
    
    public void remover(Entidade entidade) throws ExceptionInInitializerError, HibernateException
    {
        try {
            this.iniciaOperacao();
            this.sessao.delete(entidade);
            this.transacao.commit();
        }
        catch (HibernateException e) 
        {
            throw(e);
        }
        finally
        {
            try
            {
                //fecha a sessao com o banco de dados
                this.sessao.close();
            }
            catch(Throwable e)
            {
                throw new ExceptionInInitializerError("Erro no acesso ao banco de dados. Erro:"+ e.getMessage());
            }
        }
    }
    
    public void alterar(Entidade objeto) throws ExceptionInInitializerError, HibernateException
    {
        try {
            this.iniciaOperacao();
            this.sessao.update(objeto);
            this.transacao.commit();
        }
        catch (HibernateException e) 
        {
            throw e;
        } 
        finally
        {
            try
            {
                //fecha a sessao com o banco de dados
                this.sessao.close();
            }
            catch(Throwable e)
            {
                throw new ExceptionInInitializerError("Erro no acesso ao banco de dados. Erro:"+ e.getMessage());
            }
        }
    }
    
    public List<Entidade> buscarTodos(Class<Entidade> clazz) throws ExceptionInInitializerError, HibernateException
    {
        List<Entidade> objetos = null;
        
        try
        {
            this.iniciaOperacao();
            
            Query query = this.sessao.createQuery("from " + clazz.getName());
            
            objetos = query.list();
            
            this.transacao.commit();
            
            return objetos;
        }
        catch(HibernateException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                //fecha a sessao com o banco de dados
                this.sessao.close();
            }
            catch(Throwable e)
            {
                throw new ExceptionInInitializerError("Erro no acesso ao banco de dados. Erro:"+ e.getMessage());
            }
        }
    }
    
    public Entidade buscarPorId(Class clazz, Integer id) throws ExceptionInInitializerError, HibernateException
    {
        Entidade objeto = null;
        
        try
        {
            this.iniciaOperacao();
            
            objeto = (Entidade)this.sessao.get(clazz, id);
            
            this.transacao.commit();
            
            return objeto;
        }
        catch(HibernateException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                //fecha a sessao com o banco de dados
                this.sessao.close();
            }
            catch(Throwable e)
            {
                throw new ExceptionInInitializerError("Erro no acesso ao banco de dados. Erro:"+ e.getMessage());
            }
        }
    }
    
}
