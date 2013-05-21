/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.apresentacao;

import br.edu.ifnmg.sistemavendas.entidade.Pessoa;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
      EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaVendasPU");
      EntityManager manager = fabrica.createEntityManager();
      Pessoa p = new Pessoa();
      p.setNome("Jucielio");
      
      EntityTransaction tran = manager.getTransaction();
        tran.begin();
            manager.persist(p);
        tran.commit() ;
        
    }
}
