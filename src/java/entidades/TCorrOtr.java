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
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_corr_otr")
@NamedQueries({
    @NamedQuery(name = "TCorrOtr.findAll", query = "SELECT t FROM TCorrOtr t"),
    @NamedQuery(name = "TCorrOtr.findByTOtrocId", query = "SELECT t FROM TCorrOtr t WHERE t.tOtrocId = :tOtrocId"),
   // @NamedQuery(name = "TCorrOtr.findByTOtrocDesc", query = "SELECT t FROM TCorrOtr t WHERE t.tOtrocDesc = :tOtrocDesc"),
    @NamedQuery(name = "TCorrOtr.findByTOtrocAnio", query = "SELECT t FROM TCorrOtr t WHERE t.tOtrocId = :tOtrocId AND t.tOtrocAnio = :tOtrocAnio"),
    @NamedQuery(name = "TCorrOtr.findByTOtrocCorrel", query = "SELECT t FROM TCorrOtr t WHERE t.tOtrocCorrel = :tOtrocCorrel")})
public class TCorrOtr implements Serializable {
    @JoinColumn(name = "c_otrosm_id", referencedColumnName = "c_otrosm_id")
    @ManyToOne
    private COtrosMov cOtrosmId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_otroc_id")
    private Integer tOtrocId;
    
    @Column(name = "t_otroc_anio")
    private Integer tOtrocAnio;
    @Column(name = "t_otroc_correl")
    private Integer tOtrocCorrel;

    public TCorrOtr() {
    }

    public TCorrOtr(Integer tOtrocId) {
        this.tOtrocId = tOtrocId;
    }

    public Integer getTOtrocId() {
        return tOtrocId;
    }

    public void setTOtrocId(Integer tOtrocId) {
        this.tOtrocId = tOtrocId;
    }

    public Integer getTOtrocAnio() {
        return tOtrocAnio;
    }

    public void setTOtrocAnio(Integer tOtrocAnio) {
        this.tOtrocAnio = tOtrocAnio;
    }

    public Integer getTOtrocCorrel() {
        return tOtrocCorrel;
    }

    public void setTOtrocCorrel(Integer tOtrocCorrel) {
        this.tOtrocCorrel = tOtrocCorrel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tOtrocId != null ? tOtrocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCorrOtr)) {
            return false;
        }
        TCorrOtr other = (TCorrOtr) object;
        if ((this.tOtrocId == null && other.tOtrocId != null) || (this.tOtrocId != null && !this.tOtrocId.equals(other.tOtrocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TCorrOtr[ tOtrocId=" + tOtrocId + " ]";
    }

    public COtrosMov getCOtrosmId() {
        return cOtrosmId;
    }

    public void setCOtrosmId(COtrosMov cOtrosmId) {
        this.cOtrosmId = cOtrosmId;
    }
    
}
