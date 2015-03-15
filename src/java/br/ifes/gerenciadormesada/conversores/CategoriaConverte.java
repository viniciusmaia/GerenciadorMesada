package br.ifes.gerenciadormesada.conversores;


import br.ifes.gerenciadormesada.entidades.CategoriaEntidade;
import br.ifes.gerenciadormesada.modelo.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class CategoriaConverte implements IConverte<Categoria, CategoriaEntidade>
{

    @Override
    public Categoria EntidadeParaModelo(CategoriaEntidade entrada) 
    {
        Categoria saida = new Categoria();
        
        saida.setTitulo(entrada.getTitulo());
        saida.setId(entrada.getId());
        
        return saida;
    }

    @Override
    public CategoriaEntidade ModeloParaEntidade(Categoria entrada)
    {
        CategoriaEntidade saida = new CategoriaEntidade();
        
        saida.setTitulo(entrada.getTitulo());
        saida.setId(entrada.getId());
        
        return saida;
    }
    
}
