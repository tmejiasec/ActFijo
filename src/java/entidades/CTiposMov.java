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
@Table(name = "c_tipos_mov")
@NamedQueries({
    @NamedQuery(name = "CTiposMov.findAll", query = "SELECT c FROM CTiposMov c"),
    @NamedQuery(name = "CTiposMov.findByCTipmId", query = "SELECT c FROM CTiposMov c WHERE c.cTipmId = :cTipmId"),
    @NamedQuery(name = "CTiposMov.findByCTipmDesc", query = "SELECT c FROM CTiposMov c WHERE c.cTipmDesc = :cTipmDesc")})
public class CTiposMov implements Serializable {
    @OneToMany(mappedBy = "cTipmId")
    private List<TSegMov> tSegMovList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_tipm_id")
    private Integer cTipmId;
    @Size(max = 25)
    @Column(name = "c_tipm_desc")
    private String cTipmDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cTipmId")
    private List<TCorrMov> tCorrMovList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cTipmId")
    private List<TMovimEnca> tMovimEncaList;

    public CTiposMov() {
    }

    public CTiposMov(Integer cTipmId) {
        this.cTipmId = cTipmId;
    }

    public Integer getCTipmId() {
        return cTipmId;
    }

    public void setCTipmId(Integer cTipmId) {
        this.cTipmId = cTipmId;
    }

    public String getCTipmDesc() {
        return cTipmDesc;
    }

    public void setCTipmDesc(String cTipmDesc) {
        this.cTipmDesc = cTipmDesc;
    }

    public List<TCorrMov> getTCorrMovList() {
        return tCorrMovList;
    }

    public void setTCorrMovList(List<TCorrMov> tCorrMovList) {
        this.tCorrMovList = tCorrMovList;
    }

    public List<TMovimEnca> getTMovimEncaList() {
        return tMovimEncaList;
    }

    public void setTMovimEncaList(List<TMovimEnca> tMovimEncaList) {
        this.tMovimEncaList = tMovimEncaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTipmId != null ? cTipmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTiposMov)) {
            return false;
        }
        CTiposMov other = (CTiposMov) object;
        if ((this.cTipmId == null && other.cTipmId != null) || (this.cTipmId != null && !this.cTipmId.equals(other.cTipmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CTiposMov[ cTipmId=" + cTipmId + " ]";
    }

    public List<TSegMov> getTSegMovList() {
        return tSegMovList;
    }

    public void setTSegMovList(List<TSegMov> tSegMovList) {
        this.tSegMovList = tSegMovList;
    }
    
}
