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
@Table(name = "c_marcas_bm")
@NamedQueries({
    @NamedQuery(name = "CMarcasBm.findAll", query = "SELECT c FROM CMarcasBm c"),
    @NamedQuery(name = "CMarcasBm.findByCMarcaId", query = "SELECT c FROM CMarcasBm c WHERE c.cMarcaId = :cMarcaId"),
    @NamedQuery(name = "CMarcasBm.findByCMarcaDesc", query = "SELECT c FROM CMarcasBm c WHERE c.cMarcaDesc = :cMarcaDesc")})
public class CMarcasBm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_marca_id")
    private Integer cMarcaId;
    @Size(max = 25)
    @Column(name = "c_marca_desc")
    private String cMarcaDesc;
    @OneToMany(mappedBy = "cMarcaId")
    private List<TBienes> tBienesList;

    public CMarcasBm() {
    }

    public CMarcasBm(Integer cMarcaId) {
        this.cMarcaId = cMarcaId;
    }

    public Integer getCMarcaId() {
        return cMarcaId;
    }

    public void setCMarcaId(Integer cMarcaId) {
        this.cMarcaId = cMarcaId;
    }

    public String getCMarcaDesc() {
        return cMarcaDesc;
    }

    public void setCMarcaDesc(String cMarcaDesc) {
        this.cMarcaDesc = cMarcaDesc;
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
        hash += (cMarcaId != null ? cMarcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMarcasBm)) {
            return false;
        }
        CMarcasBm other = (CMarcasBm) object;
        if ((this.cMarcaId == null && other.cMarcaId != null) || (this.cMarcaId != null && !this.cMarcaId.equals(other.cMarcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CMarcasBm[ cMarcaId=" + cMarcaId + " ]";
    }
    
}
