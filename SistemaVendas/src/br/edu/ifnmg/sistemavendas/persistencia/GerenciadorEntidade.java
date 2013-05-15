/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author JUCIELIO
 */
public class GerenciadorEntidade {
     public static EntityManager gerenciadorEntidade =
       Persistence.createEntityManagerFactory("SistemaVendasPU").createEntityManager();
     
     public static   EntityManager getGerenciadorEntidade() {
       return  gerenciadorEntidade; 
     }    
    
}
