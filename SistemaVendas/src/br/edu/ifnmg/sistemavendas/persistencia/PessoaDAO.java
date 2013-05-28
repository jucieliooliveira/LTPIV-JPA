/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.persistencia;

import br.edu.ifnmg.sistemavendas.entidade.Pessoa;
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
public class PessoaDAO {
    EntityManager manager;
    
  public  PessoaDAO () {
      EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaVendasPU");
      EntityManager manager = fabrica.createEntityManager();
  
  }  
    
  public void Salvar (Pessoa p)  {
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
  
  public void Apagar(Pessoa p) {  
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
  
  public Pessoa Abrir(Long id){
      return (Pessoa)manager.find(Pessoa.class, id);  
  }
  
  public List<Pessoa> Busca(int inicio,int qtd){
      Query consulta = (Query) manager.createQuery("select p from p  "
              + "order by p.nome");
      consulta.setFirstResult(inicio);
      consulta.setMaxResults(qtd);
      List<Pessoa> lista = consulta.getResultList();
      return lista;
  }
}
