/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.dao;

import br.ifes.gerenciadormesada.conversores.MesadaConverte;
import br.ifes.gerenciadormesada.entidades.MesadaEntidade;
import br.ifes.gerenciadormesada.modelo.Mesada;
import br.ifes.gerenciadormesada.util.EscreveMensagem;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Vinicius
 */
public class MesadaDAO extends AbstractDAO<MesadaEntidade>
{
    private final MesadaConverte conversor;

    public MesadaDAO() {
        this.conversor = new MesadaConverte();
    }
    
    public Integer inserir(Mesada gasto)
    {
        MesadaEntidade entidade = this.conversor.ModeloParaEntidade(gasto);
        
        return super.inserir(entidade);
    }
    
    public void remover(Mesada gasto)
    {
        MesadaEntidade entidade = this.conversor.ModeloParaEntidade(gasto);
        
        super.remover(entidade);
    }
    
    public void alterar(Mesada gasto)
    {
        MesadaEntidade entidade = this.conversor.ModeloParaEntidade(gasto);
        
        super.alterar(entidade);
    }
    
    public List<Mesada> buscarTodos()
    {
        List<MesadaEntidade> mesadasEntidade = super.buscarTodos(MesadaEntidade.class);
        
        List<Mesada> mesadas = new ArrayList<Mesada>();
        
        Mesada objMesada;
        
        for (int i = 0; i < mesadasEntidade.size(); i++)
        {
            objMesada = this.conversor.EntidadeParaModelo(mesadasEntidade.get(i));
            
            mesadas.add(objMesada);
        }
        
        return mesadas;
    }
    
    public Mesada buscaPorId(Integer id)
    {
        MesadaEntidade entidade = super.buscarPorId(MesadaEntidade.class, id);
        
        return this.conversor.EntidadeParaModelo(entidade);
    }
    
    public List<Mesada> buscaPorMesAno(int mes, int ano)
    {
        List<Mesada> saida = new ArrayList<Mesada>();
        
        List<MesadaEntidade> resultado = new ArrayList<MesadaEntidade>();
        
        this.sessao = null;
        this.transacao = null;
        
        try
        {
            this.iniciaOperacao();
            
            Criteria criteria = this.sessao.createCriteria(MesadaEntidade.class);
            
            Criterion criterioMes = Restrictions.eq("mes", mes);
            Criterion criterioAno = Restrictions.eq("ano", ano);
            
            LogicalExpression andExp = Restrictions.and(criterioMes, criterioAno);
            
            criteria.add(andExp);
            
            resultado = criteria.list();
            
            for (MesadaEntidade entidade : resultado)
            {
                saida.add(this.conversor.EntidadeParaModelo(entidade));
            }
            
            return saida;
        }
        catch(HibernateException e)
        {
            EscreveMensagem.escreveErro(e.getMessage());
        }
        return null;
    }
}
