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
@Table(name = "c_areas")
@NamedQueries({
    @NamedQuery(name = "CAreas.findAll", query = "SELECT c FROM CAreas c"),
    @NamedQuery(name = "CAreas.findByCAreaId", query = "SELECT c FROM CAreas c WHERE c.cAreaId = :cAreaId"),
    @NamedQuery(name = "CAreas.findByCEdifId", query="SELECT m FROM CAreas m WHERE m.cEdifId.cEdifId = :cEdifId"),
    @NamedQuery(name = "CAreas.findByCDepenId", query="SELECT m FROM CAreas m WHERE m.cDepenId.cDepenId = :cDepenId"),
    @NamedQuery(name = "CAreas.findByCAreaDesc", query = "SELECT c FROM CAreas c WHERE c.cAreaDesc = :cAreaDesc")})
public class CAreas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_area_id")
    private Integer cAreaId;
    @Size(max = 150)
    @Column(name = "c_area_desc")
    private String cAreaDesc;
    @OneToMany(mappedBy = "cAreaId")
    private List<TRobHur> tRobHurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cAreaId")
    private List<CUbic> cUbicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cAreaId")
    private List<TDescargDeta> tDescargDetaList;
    @JoinColumn(name = "c_edif_id", referencedColumnName = "c_edif_id")
    @ManyToOne(optional = false)
    private CEdificios cEdifId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;    
    @OneToMany(mappedBy = "cAreaId")
    private List<TBienes> tBienesList;
    @OneToMany(mappedBy = "cAreaId")
    private List<TSustit> tSustitList;

    public CAreas() {
    }

    public CAreas(Integer cAreaId) {
        this.cAreaId = cAreaId;
    }

    public Integer getCAreaId() {
        return cAreaId;
    }

    public void setCAreaId(Integer cAreaId) {
        this.cAreaId = cAreaId;
    }

    public String getCAreaDesc() {
        return cAreaDesc;
    }

    public void setCAreaDesc(String cAreaDesc) {
        this.cAreaDesc = cAreaDesc;
    }

    public List<TRobHur> getTRobHurList() {
        return tRobHurList;
    }

    public void setTRobHurList(List<TRobHur> tRobHurList) {
        this.tRobHurList = tRobHurList;
    }

    public List<CUbic> getCUbicList() {
        return cUbicList;
    }

    public void setCUbicList(List<CUbic> cUbicList) {
        this.cUbicList = cUbicList;
    }

    public List<TDescargDeta> getTDescargDetaList() {
        return tDescargDetaList;
    }

    public void setTDescargDetaList(List<TDescargDeta> tDescargDetaList) {
        this.tDescargDetaList = tDescargDetaList;
    }

    public CEdificios getCEdifId() {
        return cEdifId;
    }

    public void setCEdifId(CEdificios cEdifId) {
        this.cEdifId = cEdifId;
    }

    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
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
        hash += (cAreaId != null ? cAreaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAreas)) {
            return false;
        }
        CAreas other = (CAreas) object;
        if ((this.cAreaId == null && other.cAreaId != null) || (this.cAreaId != null && !this.cAreaId.equals(other.cAreaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CAreas[ cAreaId=" + cAreaId + " ]";
    }
    
}
