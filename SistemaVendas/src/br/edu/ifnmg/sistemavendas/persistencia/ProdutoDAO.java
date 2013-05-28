/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.persistencia;
import br.edu.ifnmg.sistemavendas.entidade.Produto;
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
public class ProdutoDAO {
    EntityManager manager;
    
  public  ProdutoDAO () {
      EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaVendasPU");
      EntityManager manager = fabrica.createEntityManager();
  
  }  
    
  public void Salvar (Produto p)  {
      EntityTransaction tran = manager.getTransaction();
      try{
          tran.begin();
          manager.persist(p);
          tran.commit();
      }
      catch(Exception ex){
          tran.rollback();
      }
  }
  
  public void Apagar(Produto p) {  
      EntityTransaction tran = manager.getTransaction();
      try{
          tran.begin();
          manager.remove(p);
          tran.commit();
      }
      catch(Exception ex){
          tran.rollback();
      }  
  }
  
  public Produto Abrir(Long id){
      return (Produto)manager.find(Produto.class, id);  
  }
  
  public List<Produto> Busca(int inicio,int qtd){
      Query consulta = (Query) manager.createQuery("select p from p  "
              + "order by p.nome");
      consulta.setFirstResult(inicio);
      consulta.setMaxResults(qtd);
      List<Produto> lista = consulta.getResultList();
      return lista;
  }
    
    
    
}
