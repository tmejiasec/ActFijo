/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_formas_adq")
@NamedQueries({
    @NamedQuery(name = "CFormasAdq.findAll", query = "SELECT c FROM CFormasAdq c"),
    @NamedQuery(name = "CFormasAdq.findByCFormadId", query = "SELECT c FROM CFormasAdq c WHERE c.cFormadId = :cFormadId"),
    @NamedQuery(name = "CFormasAdq.findByCFormadDesc", query = "SELECT c FROM CFormasAdq c WHERE c.cFormadDesc = :cFormadDesc")})
public class CFormasAdq implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_formad_id")
    private Integer cFormadId;
    @Size(max = 25)
    @Column(name = "c_formad_desc")
    private String cFormadDesc;
    @OneToMany(mappedBy = "cFormadId")
    private List<TBienes> tBienesList;

    public CFormasAdq() {
    }

    public CFormasAdq(Integer cFormadId) {
        this.cFormadId = cFormadId;
    }

    public Integer getCFormadId() {
        return cFormadId;
    }

    public void setCFormadId(Integer cFormadId) {
        this.cFormadId = cFormadId;
    }

    public String getCFormadDesc() {
        return cFormadDesc;
    }

    public void setCFormadDesc(String cFormadDesc) {
        this.cFormadDesc = cFormadDesc;
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cFormadId != null ? cFormadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CFormasAdq)) {
            return false;
        }
        CFormasAdq other = (CFormasAdq) object;
        if ((this.cFormadId == null && other.cFormadId != null) || (this.cFormadId != null && !this.cFormadId.equals(other.cFormadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CFormasAdq[ cFormadId=" + cFormadId + " ]";
    }
    
}
