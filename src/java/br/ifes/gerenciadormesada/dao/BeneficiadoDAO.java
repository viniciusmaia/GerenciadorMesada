/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.dao;

import br.ifes.gerenciadormesada.conversores.BeneficiadoConverte;
import br.ifes.gerenciadormesada.entidades.BeneficiadoEntidade;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Property;


/**
 *
 * @author Vinicius
 */
public class BeneficiadoDAO extends AbstractDAO<BeneficiadoEntidade>
{
    private BeneficiadoConverte conversor;

    public BeneficiadoDAO() {
        this.conversor = new BeneficiadoConverte();
    }
    
    public Integer inserir(Beneficiado beneficiado)throws ExceptionInInitializerError, HibernateException
    {
        BeneficiadoEntidade entidade = this.conversor.ModeloParaEntidade(beneficiado);
        
        return super.inserir(entidade);
    }
    
    public void remover(Beneficiado beneficiado)
    {
        BeneficiadoEntidade entidade = this.conversor.ModeloParaEntidade(beneficiado);
        
        super.remover(entidade);
    }
    
    public void alterar(Beneficiado beneficiado)
    {        
        BeneficiadoEntidade entidade = this.conversor.ModeloParaEntidade(beneficiado);
        
        super.alterar(entidade);
    }
    
    public List<Beneficiado> buscarTodos()
    {
        List<BeneficiadoEntidade> beneficiadosEntidade = super.buscarTodos(BeneficiadoEntidade.class);
        
        List<Beneficiado> beneficiados = new ArrayList<Beneficiado>();
        
        Beneficiado objBeneficiado;
        
        for (int i = 0; i < beneficiadosEntidade.size(); i++)
        {
            objBeneficiado = this.conversor.EntidadeParaModelo(beneficiadosEntidade.get(i));
            
            beneficiados.add(objBeneficiado);
        }
        
        return beneficiados;
    }
    
    public Beneficiado buscaPorId(Integer id)
    {
        BeneficiadoEntidade entidade = super.buscarPorId(BeneficiadoEntidade.class, id);
        
        return this.conversor.EntidadeParaModelo(entidade);
    }
    
   
    public Beneficiado buscaPorLogin(String login) 
    {
        BeneficiadoEntidade entidade;
        String hql;
        Query consulta;
        
        hql="select u from BeneficiadoEntidade u where u.login = :login ";
        
        this.iniciaOperacao();
        
        consulta = this.sessao.createQuery(hql);
        
        consulta.setString("login", login);
        
        entidade = (BeneficiadoEntidade) consulta.uniqueResult();
        
        if (entidade != null)
        {
            return this.conversor.EntidadeParaModelo(entidade);
        }
        
        return null;
    }
    
}
