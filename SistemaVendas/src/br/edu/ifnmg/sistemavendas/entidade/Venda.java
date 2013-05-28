
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author JUCIELIO
 */
@Entity
@Table(name="Vendas")
public class Venda implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false,length=50)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataVenda;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="cliente")
    private Pessoa cliente;  
    
    @OneToMany (cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="venda")
    private List<ItemVenda> itens;
    
    // criar lista vazia
    public Venda(){
        itens = new LinkedList<>();
    }
    
    // Adicionar Produtos 
    public void add(ItemVenda item){
        if (!itens.contains(item));
         item.setVenda(this);
         itens.add(item);
    }
    
    // Remover  Produtos 
    public void remove(ItemVenda item){
        if (!itens.contains(item));
         itens.remove(item);
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.sistemavendas.entidade.Venda[ id=" + id + " ]";
    }
    
}
