/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.dao;

import br.ifes.gerenciadormesada.conversores.CategoriaConverte;
import br.ifes.gerenciadormesada.entidades.CategoriaEntidade;
import br.ifes.gerenciadormesada.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class CategoriaDAO extends AbstractDAO<CategoriaEntidade>
{
    private final CategoriaConverte conversor;

    public CategoriaDAO() {
        this.conversor = new CategoriaConverte();
    }
    
    public Integer inserir(Categoria categoria)
    {
        CategoriaEntidade entidade = this.conversor.ModeloParaEntidade(categoria);
        
        return super.inserir(entidade);
    }
    
    public void remover(Categoria categoria)
    {
        CategoriaEntidade entidade = this.conversor.ModeloParaEntidade(categoria);
        
        super.remover(entidade);
    }
    
    public void alterar(Categoria categoria)
    {
        CategoriaEntidade entidade = this.conversor.ModeloParaEntidade(categoria);
        
        super.alterar(entidade);
    }
    
    public List<Categoria> buscarTodos()
    {
        List<CategoriaEntidade> categoriasEntidade = super.buscarTodos(CategoriaEntidade.class);
        
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        Categoria objCategoria;
        
        for (int i = 0; i < categoriasEntidade.size(); i++)
        {
            objCategoria = this.conversor.EntidadeParaModelo(categoriasEntidade.get(i));
            
            categorias.add(objCategoria);
        }
        
        return categorias;
    }
    
    public Categoria buscaPorId(Integer id)
    {
        CategoriaEntidade entidade = super.buscarPorId(CategoriaEntidade.class, id);
        
        return this.conversor.EntidadeParaModelo(entidade);
    }
}
