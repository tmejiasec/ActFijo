/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_corr_mov")
@NamedQueries({
    @NamedQuery(name = "TCorrMov.findAll", query = "SELECT t FROM TCorrMov t"),
    @NamedQuery(name = "TCorrMov.findByTCorrId", query = "SELECT t FROM TCorrMov t WHERE t.tCorrId = :tCorrId"),
    @NamedQuery(name = "TCorrMov.findByTCorrAnio", query = "SELECT t FROM TCorrMov t WHERE t.tCorrAnio = :tCorrAnio"),
    @NamedQuery(name = "TCorrMov.findByTCorrCorrel", query = "SELECT t FROM TCorrMov t WHERE t.tCorrCorrel = :tCorrCorrel")})
public class TCorrMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_corr_id")
    private Integer tCorrId;
    @Column(name = "t_corr_anio")
    private Short tCorrAnio;
    @Column(name = "t_corr_correl")
    private Integer tCorrCorrel;
    @JoinColumn(name = "c_tipm_id", referencedColumnName = "c_tipm_id")
    @ManyToOne(optional = false)
    private CTiposMov cTipmId;

    public TCorrMov() {
    }

    public TCorrMov(Integer tCorrId) {
        this.tCorrId = tCorrId;
    }

    public Integer getTCorrId() {
        return tCorrId;
    }

    public void setTCorrId(Integer tCorrId) {
        this.tCorrId = tCorrId;
    }

    public Short getTCorrAnio() {
        return tCorrAnio;
    }

    public void setTCorrAnio(Short tCorrAnio) {
        this.tCorrAnio = tCorrAnio;
    }

    public Integer getTCorrCorrel() {
        return tCorrCorrel;
    }

    public void setTCorrCorrel(Integer tCorrCorrel) {
        this.tCorrCorrel = tCorrCorrel;
    }

    public CTiposMov getCTipmId() {
        return cTipmId;
    }

    public void setCTipmId(CTiposMov cTipmId) {
        this.cTipmId = cTipmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tCorrId != null ? tCorrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCorrMov)) {
            return false;
        }
        TCorrMov other = (TCorrMov) object;
        if ((this.tCorrId == null && other.tCorrId != null) || (this.tCorrId != null && !this.tCorrId.equals(other.tCorrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TCorrMov[ tCorrId=" + tCorrId + " ]";
    }
    
}
