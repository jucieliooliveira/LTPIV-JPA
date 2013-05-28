/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.apresentacao;

import br.edu.ifnmg.sistemavendas.entidade.Pessoa;
import br.edu.ifnmg.sistemavendas.entidade.Produto;
import br.edu.ifnmg.sistemavendas.persistencia.PessoaDAO;
import br.edu.ifnmg.sistemavendas.persistencia.ProdutoDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.print.attribute.standard.DateTimeAtCompleted;
import org.eclipse.persistence.jpa.internal.jpql.parser.DateTime;

/**
 *
 * @author JUCIELIO
 */
public class SistemaVendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
        PessoaDAO dao = new PessoaDAO();
        
        Pessoa teste = new Pessoa();
        teste.setNome("Pessoa1");
        
        dao.Salvar(teste);
        for (Pessoa p : dao.Busca(0, 1000)){
            System.out.println(p);
        }
        
        
        
        
      /*     
      Pessoa p = new Pessoa();
      p.setNome("Jucielio");
      
      EntityTransaction tran = manager.getTransaction();
        tran.begin();
            manager.persist(p);
        tran.commit() ; 
      Query consulta = manager.createQuery("select p from Pessoa p ");             
        //consulta.setFirstResult(9); // n primeiros registrsos 
        consulta.setMaxResults(3); //quantiades de regitros  a serem exixbidos   
        List<Pessoa>  lista = consulta.getResultList();      
      for (Pessoa p: lista){
          System.out.println(p);
      } 
        
      
      Query consulta = manager.createQuery("select p from Produto p "
              + "where p.preco < :preco"
              + "order by p.nome" );             
      
        consulta.setFirstResult(3); // n primeiros registrsos 
        consulta.setMaxResults(3); //quantiades de regitros  a serem exixbidos   
        consulta.setParameter("preco", 10); 
        
        List<Produto>  lista = consulta.getResultList();              
            for (Produto p: lista){
                System.out.println(p);
            }     
      
      */
      
      
    }
}
