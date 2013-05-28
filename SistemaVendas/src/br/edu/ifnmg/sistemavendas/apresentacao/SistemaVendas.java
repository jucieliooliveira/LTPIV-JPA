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
        
        
        // Inserir dados 
         for(int i=1;i<=20;i++){    
            Pessoa teste = new Pessoa();
            teste.setNome("Cliente "+i);
            // Salvar dados 
            dao.Salvar(teste);
         }
        
        // Listar dados 
        for (Pessoa p : dao.Busca(0, 1000)){
            System.out.println(p);
        } 
    } 
}
