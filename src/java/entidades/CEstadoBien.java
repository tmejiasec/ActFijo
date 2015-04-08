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
@Table(name = "c_estado_bien")
@NamedQueries({
    @NamedQuery(name = "CEstadoBien.findAll", query = "SELECT c FROM CEstadoBien c"),
    @NamedQuery(name = "CEstadoBien.findByCEstadbId", query = "SELECT c FROM CEstadoBien c WHERE c.cEstadbId = :cEstadbId"),
    @NamedQuery(name = "CEstadoBien.findByCEstadbDesc", query = "SELECT c FROM CEstadoBien c WHERE c.cEstadbDesc = :cEstadbDesc")})
public class CEstadoBien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_estadb_id")
    private Integer cEstadbId;
    @Size(max = 25)
    @Column(name = "c_estadb_desc")
    private String cEstadbDesc;
    @OneToMany(mappedBy = "cEstadbId")
    private List<TBienes> tBienesList;

    public CEstadoBien() {
    }

    public CEstadoBien(Integer cEstadbId) {
        this.cEstadbId = cEstadbId;
    }

    public Integer getCEstadbId() {
        return cEstadbId;
    }

    public void setCEstadbId(Integer cEstadbId) {
        this.cEstadbId = cEstadbId;
    }

    public String getCEstadbDesc() {
        return cEstadbDesc;
    }

    public void setCEstadbDesc(String cEstadbDesc) {
        this.cEstadbDesc = cEstadbDesc;
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
        hash += (cEstadbId != null ? cEstadbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstadoBien)) {
            return false;
        }
        CEstadoBien other = (CEstadoBien) object;
        if ((this.cEstadbId == null && other.cEstadbId != null) || (this.cEstadbId != null && !this.cEstadbId.equals(other.cEstadbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CEstadoBien[ cEstadbId=" + cEstadbId + " ]";
    }
    
}
