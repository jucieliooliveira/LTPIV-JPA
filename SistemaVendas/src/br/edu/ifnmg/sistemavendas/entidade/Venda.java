/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false,length=50)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;
    
    @Column(nullable=false,length=50)
    @ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
    @JoinColumn(name="pessoa")
    private Pessoa cliente;  
    
    @Column(nullable=false,length=50)
    @OneToMany (cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="venda")
    private List<Produto> itens;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
