/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.conversores;

import br.ifes.gerenciadormesada.entidades.CategoriaEntidade;
import br.ifes.gerenciadormesada.entidades.GastoEntidade;
import br.ifes.gerenciadormesada.entidades.MesadaEntidade;
import br.ifes.gerenciadormesada.modelo.Categoria;
import br.ifes.gerenciadormesada.modelo.Gasto;
import br.ifes.gerenciadormesada.modelo.Mesada;
import java.sql.Date;

/**
 *
 * @author Vinicius
 */
public class GastoConverte implements IConverte<Gasto, GastoEntidade>{

    @Override
    public Gasto EntidadeParaModelo(GastoEntidade entrada) 
    {
        Gasto saida = new Gasto();
        
        saida.setDescricao(entrada.getDescricao());
        saida.setValor(entrada.getValor());
        
        String data = entrada.getData().toString();
        
        saida.setData(data);
        
        Categoria categoria = this.categoriaEntidadeParaModelo(entrada.getCategoria());
        
        saida.setCategoria(categoria);
        
        saida.setId(entrada.getId());
        
        Mesada mesada = this.mesadaEntidadeParaModelo(entrada.getMesada());
        
        saida.setMesada(mesada);
        
        return saida;
    }

    @Override
    public GastoEntidade ModeloParaEntidade(Gasto entrada) 
    {
        GastoEntidade saida = new GastoEntidade();
        
        saida.setDescricao(entrada.getDescricao());
        saida.setValor(entrada.getValor());
        
        String data = entrada.getData();
        
        saida.setData(Date.valueOf(data));
        
        CategoriaEntidade categoria = new CategoriaEntidade();
        
        categoria = this.categoriaModeloParaEntidade(entrada.getCategoria());
        
        saida.setCategoria(categoria);
        
        saida.setId(entrada.getId());
        
        MesadaEntidade mesada = this.mesadaModeloParaEntidade(entrada.getMesada());
        
        saida.setMesada(mesada);
        
        return saida;
    }
    
    private Mesada mesadaEntidadeParaModelo(MesadaEntidade entrada)
    {
        MesadaConverte conversor = new MesadaConverte();
        
        return conversor.EntidadeParaModelo(entrada);
    }
    
    private MesadaEntidade mesadaModeloParaEntidade(Mesada entrada)
    {
        MesadaConverte conversor = new MesadaConverte();
        
        return conversor.ModeloParaEntidade(entrada);
    }
    
    private Categoria categoriaEntidadeParaModelo(CategoriaEntidade entrada)
    {
        CategoriaConverte conversor = new CategoriaConverte();
        
        return conversor.EntidadeParaModelo(entrada);
    }
    
    private CategoriaEntidade categoriaModeloParaEntidade(Categoria entrada)
    {
        CategoriaConverte conversor = new CategoriaConverte();
        
        return conversor.ModeloParaEntidade(entrada);
    }
    
}
