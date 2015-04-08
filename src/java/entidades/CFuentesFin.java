/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "c_fuentes_fin")
@NamedQueries({
    @NamedQuery(name = "CFuentesFin.findAll", query = "SELECT c FROM CFuentesFin c"),
    @NamedQuery(name = "CFuentesFin.findByCFuentesId", query = "SELECT c FROM CFuentesFin c WHERE c.cFuentesId = :cFuentesId"),
    @NamedQuery(name = "CFuentesFin.findByCFuestesDesc", query = "SELECT c FROM CFuentesFin c WHERE c.cFuestesDesc = :cFuestesDesc")})
public class CFuentesFin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_fuentes_id")
    private Integer cFuentesId;
    @Size(max = 50)
    @Column(name = "c_fuestes_desc")
    private String cFuestesDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFuentesId")
    private List<CProyectos> cProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFuentesId")
    private List<TBienes> tBienesList;

    public CFuentesFin() {
    }

    public CFuentesFin(Integer cFuentesId) {
        this.cFuentesId = cFuentesId;
    }

    public Integer getCFuentesId() {
        return cFuentesId;
    }

    public void setCFuentesId(Integer cFuentesId) {
        this.cFuentesId = cFuentesId;
    }

    public String getCFuestesDesc() {
        return cFuestesDesc;
    }

    public void setCFuestesDesc(String cFuestesDesc) {
        this.cFuestesDesc = cFuestesDesc;
    }

    public List<CProyectos> getCProyectosList() {
        return cProyectosList;
    }

    public void setCProyectosList(List<CProyectos> cProyectosList) {
        this.cProyectosList = cProyectosList;
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
        hash += (cFuentesId != null ? cFuentesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CFuentesFin)) {
            return false;
        }
        CFuentesFin other = (CFuentesFin) object;
        if ((this.cFuentesId == null && other.cFuentesId != null) || (this.cFuentesId != null && !this.cFuentesId.equals(other.cFuentesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CFuentesFin[ cFuentesId=" + cFuentesId + " ]";
    }
    
}
