/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.persistencia;


import br.edu.ifnmg.sistemavendas.entidade.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author JUCIELIO
 */
public class VendaDAO {
    EntityManager manager;
    
  public  VendaDAO () {
      EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaVendasPU");
       manager = fabrica.createEntityManager();
  
  }  
    
  public void Salvar (Venda v)  {
      EntityTransaction tran = manager.getTransaction();
      try{
          tran.begin();
          manager.persist(v);
          tran.commit();
      }
      catch(Exception ex){
          tran.rollback();
      }
  }
  
  public void Apagar(Venda v) {  
      EntityTransaction tran = manager.getTransaction();
      try{
          tran.begin();
          manager.remove(v);
          tran.commit();
      }
      catch(Exception ex){
          tran.rollback();
      }  
  }
  
  public Venda Abrir(Long id){
      return (Venda)manager.find(Venda.class, id);  
  }
  
  public List<Venda> Busca(int inicio,int qtd){
      Query consulta = (Query) manager.createQuery("select v from Venda v  "
              + "order by p.nome");
      consulta.setFirstResult(inicio);
      consulta.setMaxResults(qtd);
      List<Venda> lista = consulta.getResultList();
      return lista;
  }
  
}
