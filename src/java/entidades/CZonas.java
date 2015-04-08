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
@Table(name = "c_zonas")
@NamedQueries({
    @NamedQuery(name = "CZonas.findAll", query = "SELECT c FROM CZonas c"),
    @NamedQuery(name = "CZonas.findByCZonaId", query = "SELECT c FROM CZonas c WHERE c.cZonaId = :cZonaId"),
    @NamedQuery(name = "CZonas.findByCZonaDesc", query = "SELECT c FROM CZonas c WHERE c.cZonaDesc = :cZonaDesc")})
public class CZonas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_zona_id")
    private Integer cZonaId;
    @Size(max = 20)
    @Column(name = "c_zona_desc")
    private String cZonaDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cZonaId")
    private List<CDeptos> cDeptosList;

    public CZonas() {
    }

    public CZonas(Integer cZonaId) {
        this.cZonaId = cZonaId;
    }

    public Integer getCZonaId() {
        return cZonaId;
    }

    public void setCZonaId(Integer cZonaId) {
        this.cZonaId = cZonaId;
    }

    public String getCZonaDesc() {
        return cZonaDesc;
    }

    public void setCZonaDesc(String cZonaDesc) {
        this.cZonaDesc = cZonaDesc;
    }

    public List<CDeptos> getCDeptosList() {
        return cDeptosList;
    }

    public void setCDeptosList(List<CDeptos> cDeptosList) {
        this.cDeptosList = cDeptosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cZonaId != null ? cZonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CZonas)) {
            return false;
        }
        CZonas other = (CZonas) object;
        if ((this.cZonaId == null && other.cZonaId != null) || (this.cZonaId != null && !this.cZonaId.equals(other.cZonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CZonas[ cZonaId=" + cZonaId + " ]";
    }
    
}
