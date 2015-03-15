/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.dao;

import br.ifes.gerenciadormesada.conversores.PatrocinadorConverte;
import br.ifes.gerenciadormesada.entidades.PatrocinadorEntidade;
import br.ifes.gerenciadormesada.modelo.Beneficiado;
import br.ifes.gerenciadormesada.modelo.Patrocinador;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Vinicius
 */
public class PatrocinadorDAO extends AbstractDAO<PatrocinadorEntidade> 
{
    private final PatrocinadorConverte conversor;

    public PatrocinadorDAO() {
        this.conversor = new PatrocinadorConverte();
    }
    
    public Integer inserir(Patrocinador patrocinador)
    {
        PatrocinadorEntidade entidade = this.conversor.ModeloParaEntidade(patrocinador);
        
        return super.inserir(entidade);
    }
    
    public void remover(Patrocinador patrocinador)
    {
        PatrocinadorEntidade entidade = this.conversor.ModeloParaEntidade(patrocinador);
        
        super.remover(entidade);
    }
    
    public void alterar(Patrocinador patrocinador)
    {
        PatrocinadorEntidade entidade = this.conversor.ModeloParaEntidade(patrocinador);
        
        super.alterar(entidade);
    }
    
    public List<Patrocinador> buscarTodos()
    {
        List<PatrocinadorEntidade> patrocinadoresEntidade = super.buscarTodos(PatrocinadorEntidade.class);
        
        List<Patrocinador> patrocinadores = new ArrayList<Patrocinador>();
        
        Patrocinador objPatrocinador;
        
        for (int i = 0; i < patrocinadoresEntidade.size(); i++)
        {
            objPatrocinador = this.conversor.EntidadeParaModelo(patrocinadoresEntidade.get(i));
            
            patrocinadores.add(objPatrocinador);
        }
        
        return patrocinadores;
    }
    
    public Patrocinador buscaPorId(Integer id)
    {
        PatrocinadorEntidade entidade = super.buscarPorId(PatrocinadorEntidade.class, id);
        
        return this.conversor.EntidadeParaModelo(entidade);
    }
    
    public Patrocinador buscaPorLogin(String login) 
    {
        PatrocinadorEntidade entidade;
        Query consulta;
        // TODO Auto-generated method stub
        String hql="select u from PatrocinadorEntidade u where u.login = :login ";
        
        this.iniciaOperacao();
        
        consulta = this.sessao.createQuery(hql);
        
        consulta.setString("login", login);
        
        entidade = (PatrocinadorEntidade) consulta.uniqueResult();
        
        if (entidade != null)
        {
            return this.conversor.EntidadeParaModelo(entidade);
        }
        
        return null;
        
    }
}
