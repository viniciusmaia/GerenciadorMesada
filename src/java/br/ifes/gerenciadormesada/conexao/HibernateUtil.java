/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifes.gerenciadormesada.conexao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Vinicius
 */
public class HibernateUtil 
{
    //objeto que fabrica uma ou mais instância de sessões de acesso ao banco a partir da
    //configurações do objeto serviceRegistry
    private static SessionFactory sessionFactory;
    
    //objeto responsável pela configurações do hibernate.cfg.xml
    private static ServiceRegistry serviceRegistry;
    
    @SuppressWarnings("unused")
    
    private static SessionFactory buildSessionFactory()
    {
        try
        {
            //objeto que armazena configurações do hibernate.cfg.xml
            Configuration configuration = new Configuration();

            //método que lê e valida as configurações em hibernate.cfg.xml
            configuration.configure();
            
            //aplica e carrega as configurações no objeto serviceRegistry
            //serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            //cria uma ou mais instâncias de sessão da configuração. Geralmente
            //uma aplicação tem uma única instância de sessão e threads servindo pedidos de clientes
            //obtendo instâncias da sessão do factory (fábrica)
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            return sessionFactory;
        }
        catch(Exception e)
        {
            throw new ExceptionInInitializerError("Criacao do objeto falhou: " + e);
        }        
    }
    
    public static SessionFactory getSessionFactory()
    {
        return buildSessionFactory();
    }
    
    public static Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
