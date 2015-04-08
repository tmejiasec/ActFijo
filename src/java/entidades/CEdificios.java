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
@Table(name = "c_edificios")
@NamedQueries({
    @NamedQuery(name = "CEdificios.findAll", query = "SELECT c FROM CEdificios c"),
    @NamedQuery(name = "CEdificios.findByCEdifId", query = "SELECT c FROM CEdificios c WHERE c.cEdifId = :cEdifId"),
    @NamedQuery(name = "CEdificios.findByCEdifDesc", query = "SELECT c FROM CEdificios c WHERE c.cEdifDesc = :cEdifDesc"),
    @NamedQuery(name = "CEdificios.findByCEdifDirec", query = "SELECT c FROM CEdificios c WHERE c.cEdifDirec = :cEdifDirec"),
    @NamedQuery(name = "CEdificios.findByCEdifLegal", query = "SELECT c FROM CEdificios c WHERE c.cEdifLegal = :cEdifLegal")})
public class CEdificios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_edif_id")
    private Integer cEdifId;
    @Size(max = 150)
    @Column(name = "c_edif_desc")
    private String cEdifDesc;
    @Size(max = 150)
    @Column(name = "c_edif_direc")
    private String cEdifDirec;
    @Size(max = 15)
    @Column(name = "c_edif_legal")
    private String cEdifLegal;
    @Column(name = "c_edif_longitud")
    private Double cEdifLongitud;
    @Column(name = "c_edif_latitud")
    private Double cEdifLatitud;
    
    @OneToMany(mappedBy = "cEdifId")
    private List<TRobHur> tRobHurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cEdifId")
    private List<TDescargEnca> tDescargEncaList;
    @JoinColumn(name = "c_muni_id", referencedColumnName = "c_muni_id")
    @ManyToOne(optional = false)
    private CMunic cMuniId;
    @JoinColumn(name = "c_depto_id", referencedColumnName = "c_depto_id")
    @ManyToOne
    private CDeptos cDeptoId;
    @OneToMany(mappedBy = "cEdifId")
    private List<CUbic> cUbicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cEdifId")
    private List<CAreas> cAreasList;
    @OneToMany(mappedBy = "cEdifId")
    private List<TBienes> tBienesList;
    @OneToMany(mappedBy = "cEdifId")
    private List<TSustit> tSustitList;

    public CEdificios() {
    }

    public CEdificios(Integer cEdifId) {
        this.cEdifId = cEdifId;
    }

    public Integer getCEdifId() {
        return cEdifId;
    }

    public void setCEdifId(Integer cEdifId) {
        this.cEdifId = cEdifId;
    }

    public String getCEdifDesc() {
        return cEdifDesc;
    }

    public void setCEdifDesc(String cEdifDesc) {
        this.cEdifDesc = cEdifDesc;
    }

    public String getCEdifDirec() {
        return cEdifDirec;
    }

    public void setCEdifDirec(String cEdifDirec) {
        this.cEdifDirec = cEdifDirec;
    }

    public String getCEdifLegal() {
        return cEdifLegal;
    }

    public void setCEdifLegal(String cEdifLegal) {
        this.cEdifLegal = cEdifLegal;
    }

    public Double getCEdifLongitud() {
        return cEdifLongitud;
    }

    public void setCEdifLongitud(Double cEdifLongitud) {
        this.cEdifLongitud = cEdifLongitud;
    }

    public Double getCEdifLatitud() {
        return cEdifLatitud;
    }

    public void setCEdifLatitud(Double cEdifLatitud) {
        this.cEdifLatitud = cEdifLatitud;
    }

    public List<TRobHur> getTRobHurList() {
        return tRobHurList;
    }

    public void setTRobHurList(List<TRobHur> tRobHurList) {
        this.tRobHurList = tRobHurList;
    }

    public List<TDescargEnca> getTDescargEncaList() {
        return tDescargEncaList;
    }

    public void setTDescargEncaList(List<TDescargEnca> tDescargEncaList) {
        this.tDescargEncaList = tDescargEncaList;
    }

    public CMunic getCMuniId() {
        return cMuniId;
    }

    public void setCMuniId(CMunic cMuniId) {
        this.cMuniId = cMuniId;
    }

    public CDeptos getCDeptoId() {
        return cDeptoId;
    }

    public void setCDeptoId(CDeptos cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    public List<CUbic> getCUbicList() {
        return cUbicList;
    }

    public void setCUbicList(List<CUbic> cUbicList) {
        this.cUbicList = cUbicList;
    }

    public List<CAreas> getCAreasList() {
        return cAreasList;
    }

    public void setCAreasList(List<CAreas> cAreasList) {
        this.cAreasList = cAreasList;
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
        hash += (cEdifId != null ? cEdifId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEdificios)) {
            return false;
        }
        CEdificios other = (CEdificios) object;
        if ((this.cEdifId == null && other.cEdifId != null) || (this.cEdifId != null && !this.cEdifId.equals(other.cEdifId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CEdificios[ cEdifId=" + cEdifId + " ]";
    }
    
}
