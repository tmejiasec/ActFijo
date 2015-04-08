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
@Table(name = "c_estado_proc")
@NamedQueries({
    @NamedQuery(name = "CEstadoProc.findAll", query = "SELECT c FROM CEstadoProc c"),
    @NamedQuery(name = "CEstadoProc.findByCEstproId", query = "SELECT c FROM CEstadoProc c WHERE c.cEstproId = :cEstproId"),
    @NamedQuery(name = "CEstadoProc.findByCEstproDesc", query = "SELECT c FROM CEstadoProc c WHERE c.cEstproDesc = :cEstproDesc")})
public class CEstadoProc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_estpro_id")
    private Integer cEstproId;
    @Size(max = 25)
    @Column(name = "c_estpro_desc")
    private String cEstproDesc;
    @OneToMany(mappedBy = "cECEstproId")
    private List<TBienes> tBienesList;
    @OneToMany(mappedBy = "cEstproId")
    private List<TBienes> tBienesList1;

    public CEstadoProc() {
    }

    public CEstadoProc(Integer cEstproId) {
        this.cEstproId = cEstproId;
    }

    public Integer getCEstproId() {
        return cEstproId;
    }

    public void setCEstproId(Integer cEstproId) {
        this.cEstproId = cEstproId;
    }

    public String getCEstproDesc() {
        return cEstproDesc;
    }

    public void setCEstproDesc(String cEstproDesc) {
        this.cEstproDesc = cEstproDesc;
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }

    public List<TBienes> getTBienesList1() {
        return tBienesList1;
    }

    public void setTBienesList1(List<TBienes> tBienesList1) {
        this.tBienesList1 = tBienesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cEstproId != null ? cEstproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstadoProc)) {
            return false;
        }
        CEstadoProc other = (CEstadoProc) object;
        if ((this.cEstproId == null && other.cEstproId != null) || (this.cEstproId != null && !this.cEstproId.equals(other.cEstproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CEstadoProc[ cEstproId=" + cEstproId + " ]";
    }
    
}
