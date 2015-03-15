/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.entidades;

import br.ifes.gerenciadormesada.modelo.Patrocinador;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "patrocinador")
public class PatrocinadorEntidade implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;    
    
    @Column(name = "login", length = 20, nullable = false, unique = true)
    private String login;
    
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    @Column(name = "email", length = 40, nullable = false, unique = true)
    private String email;
    
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
        
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idbeneficiado", referencedColumnName = "id")
    private BeneficiadoEntidade beneficiado;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BeneficiadoEntidade getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(BeneficiadoEntidade beneficiado) {
        this.beneficiado = beneficiado;
    }
        
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
