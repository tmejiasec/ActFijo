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
@Table(name = "c_cond_bien")
@NamedQueries({
    @NamedQuery(name = "CCondBien.findAll", query = "SELECT c FROM CCondBien c"),
    @NamedQuery(name = "CCondBien.findByCCondbId", query = "SELECT c FROM CCondBien c WHERE c.cCondbId = :cCondbId"),
    @NamedQuery(name = "CCondBien.findByCCondbDesc", query = "SELECT c FROM CCondBien c WHERE c.cCondbDesc = :cCondbDesc")})
public class CCondBien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_condb_id")
    private Integer cCondbId;
    @Size(max = 25)
    @Column(name = "c_condb_desc")
    private String cCondbDesc;
    @OneToMany(mappedBy = "cCondbId")
    private List<TBienes> tBienesList;

    public CCondBien() {
    }

    public CCondBien(Integer cCondbId) {
        this.cCondbId = cCondbId;
    }

    public Integer getCCondbId() {
        return cCondbId;
    }

    public void setCCondbId(Integer cCondbId) {
        this.cCondbId = cCondbId;
    }

    public String getCCondbDesc() {
        return cCondbDesc;
    }

    public void setCCondbDesc(String cCondbDesc) {
        this.cCondbDesc = cCondbDesc;
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
        hash += (cCondbId != null ? cCondbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCondBien)) {
            return false;
        }
        CCondBien other = (CCondBien) object;
        if ((this.cCondbId == null && other.cCondbId != null) || (this.cCondbId != null && !this.cCondbId.equals(other.cCondbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CCondBien[ cCondbId=" + cCondbId + " ]";
    }
    
}
