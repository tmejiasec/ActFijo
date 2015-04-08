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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "c_ubic")
@NamedQueries({
    @NamedQuery(name = "CUbic.findAll", query = "SELECT c FROM CUbic c"),
    @NamedQuery(name = "CUbic.findByCUbicId", query = "SELECT c FROM CUbic c WHERE c.cUbicId = :cUbicId"),
    @NamedQuery(name = "CUbic.findByCEdifId", query="SELECT m FROM CUbic m WHERE m.cEdifId.cEdifId = :cEdifId"),
    @NamedQuery(name = "CUbic.findByCAreaId", query="SELECT m FROM CUbic m WHERE m.cAreaId.cAreaId = :cAreaId"),
    @NamedQuery(name = "CUbic.findByCUbicDesc", query = "SELECT c FROM CUbic c WHERE c.cUbicDesc = :cUbicDesc")})
public class CUbic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_ubic_id")
    private Integer cUbicId;
    @Size(max = 75)
    @Column(name = "c_ubic_desc")
    private String cUbicDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUbicId")
    private List<TRobHur> tRobHurList;
    @JoinColumn(name = "c_edif_id", referencedColumnName = "c_edif_id")
    @ManyToOne
    private CEdificios cEdifId;
    @JoinColumn(name = "c_area_id", referencedColumnName = "c_area_id")
    @ManyToOne(optional = false)
    private CAreas cAreaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUbicId")
    private List<TDescargDeta> tDescargDetaList;
    @OneToMany(mappedBy = "cUbicId")
    private List<TBienes> tBienesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cUbicId")
    private List<TSustit> tSustitList;

    public CUbic() {
    }

    public CUbic(Integer cUbicId) {
        this.cUbicId = cUbicId;
    }

    public Integer getCUbicId() {
        return cUbicId;
    }

    public void setCUbicId(Integer cUbicId) {
        this.cUbicId = cUbicId;
    }

    public String getCUbicDesc() {
        return cUbicDesc;
    }

    public void setCUbicDesc(String cUbicDesc) {
        this.cUbicDesc = cUbicDesc;
    }

    public List<TRobHur> getTRobHurList() {
        return tRobHurList;
    }

    public void setTRobHurList(List<TRobHur> tRobHurList) {
        this.tRobHurList = tRobHurList;
    }

    public CEdificios getCEdifId() {
        return cEdifId;
    }

    public void setCEdifId(CEdificios cEdifId) {
        this.cEdifId = cEdifId;
    }

    public CAreas getCAreaId() {
        return cAreaId;
    }

    public void setCAreaId(CAreas cAreaId) {
        this.cAreaId = cAreaId;
    }

    public List<TDescargDeta> getTDescargDetaList() {
        return tDescargDetaList;
    }

    public void setTDescargDetaList(List<TDescargDeta> tDescargDetaList) {
        this.tDescargDetaList = tDescargDetaList;
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }

    public List<TSustit> getTSustitList() {
        return tSustitList;
    }

    public void setTSustitList(List<TSustit> tSustitList) {
        this.tSustitList = tSustitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cUbicId != null ? cUbicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CUbic)) {
            return false;
        }
        CUbic other = (CUbic) object;
        if ((this.cUbicId == null && other.cUbicId != null) || (this.cUbicId != null && !this.cUbicId.equals(other.cUbicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CUbic[ cUbicId=" + cUbicId + " ]";
    }
    
}
