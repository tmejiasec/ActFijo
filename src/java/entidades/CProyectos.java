/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_proyectos")
@NamedQueries({
    @NamedQuery(name = "CProyectos.findAll", query = "SELECT c FROM CProyectos c"),
    @NamedQuery(name = "CProyectos.findByCProyId", query = "SELECT c FROM CProyectos c WHERE c.cProyId = :cProyId"),
    @NamedQuery(name = "CProyectos.findByCProyNum", query = "SELECT c FROM CProyectos c WHERE c.cProyNum = :cProyNum"),
    @NamedQuery(name = "CProyectos.findByCProyNomb", query = "SELECT c FROM CProyectos c WHERE c.cProyNomb = :cProyNomb"),
    @NamedQuery(name = "CProyectos.findByCProyDesc", query = "SELECT c FROM CProyectos c WHERE c.cProyDesc = :cProyDesc"),
    @NamedQuery(name = "CProyectos.findByCProyFechi", query = "SELECT c FROM CProyectos c WHERE c.cProyFechi = :cProyFechi"),
    @NamedQuery(name = "CProyectos.findByCProyFechf", query = "SELECT c FROM CProyectos c WHERE c.cProyFechf = :cProyFechf"),
    @NamedQuery(name = "CProyectos.findByCProyUbic", query = "SELECT c FROM CProyectos c WHERE c.cProyUbic = :cProyUbic"),
    @NamedQuery(name = "CProyectos.findByCProyEstado", query = "SELECT c FROM CProyectos c WHERE c.cProyEstado = :cProyEstado"),
    @NamedQuery(name = "CProyectos.findByCProyObserv", query = "SELECT c FROM CProyectos c WHERE c.cProyObserv = :cProyObserv")})
public class CProyectos implements Serializable {
    @OneToMany(mappedBy = "cProyId")
    private List<TBienes> tBienesList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_proy_id")
    private Integer cProyId;
    @Size(min=1,max = 10)
    @Column(name = "c_proy_num")
    private String cProyNum;
    @Size(max = 75)
    @Column(name = "c_proy_nomb")
    private String cProyNomb;
    @Size(max = 150)
    @Column(name = "c_proy_desc")
    private String cProyDesc;
    @Column(name = "c_proy_fechi")
    @Temporal(TemporalType.DATE)
    private Date cProyFechi;
    @Column(name = "c_proy_fechf")
    @Temporal(TemporalType.DATE)
    private Date cProyFechf;
    @Size(max = 150)
    @Column(name = "c_proy_ubic")
    private String cProyUbic;
    @Size(max = 20)
    @Column(name = "c_proy_estado")
    private String cProyEstado;
    @Size(max = 200)
    @Column(name = "c_proy_observ")
    private String cProyObserv;
    @JoinColumn(name = "c_muni_id", referencedColumnName = "c_muni_id")
    @ManyToOne
    private CMunic cMuniId;
    @JoinColumn(name = "c_fuentes_id", referencedColumnName = "c_fuentes_id")
    @ManyToOne
    private CFuentesFin cFuentesId;
    @JoinColumn(name = "c_depto_id", referencedColumnName = "c_depto_id")
    @ManyToOne
    private CDeptos cDeptoId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne
    private CResponsables cRespId;
    @JoinColumn(name = "c_nivel_id", referencedColumnName = "c_nivel_id")
    @ManyToOne
    private CNiveles cNivelId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne
    private CDependencias cDepenId;
//    private List<TBienes> tBienesList;
    public CProyectos() {
    }

    public CProyectos(Integer cProyId) {
        this.cProyId = cProyId;
    }

    public Integer getCProyId() {
        return cProyId;
    }

    public void setCProyId(Integer cProyId) {
        this.cProyId = cProyId;
    }

    public String getCProyNum() {
        return cProyNum;
    }

    public void setCProyNum(String cProyNum) {
        this.cProyNum = cProyNum;
    }

    public String getCProyNomb() {
        return cProyNomb;
    }

    public void setCProyNomb(String cProyNomb) {
        this.cProyNomb = cProyNomb;
    }

    public String getCProyDesc() {
        return cProyDesc;
    }

    public void setCProyDesc(String cProyDesc) {
        this.cProyDesc = cProyDesc;
    }

    public Date getCProyFechi() {
        return cProyFechi;
    }

    public void setCProyFechi(Date cProyFechi) {
        this.cProyFechi = cProyFechi;
    }

    public Date getCProyFechf() {
        return cProyFechf;
    }

    public void setCProyFechf(Date cProyFechf) {
        this.cProyFechf = cProyFechf;
    }

    public String getCProyUbic() {
        return cProyUbic;
    }

    public void setCProyUbic(String cProyUbic) {
        this.cProyUbic = cProyUbic;
    }

    public String getCProyEstado() {
        return cProyEstado;
    }

    public void setCProyEstado(String cProyEstado) {
        this.cProyEstado = cProyEstado;
    }

    public String getCProyObserv() {
        return cProyObserv;
    }

    public void setCProyObserv(String cProyObserv) {
        this.cProyObserv = cProyObserv;
    }

    public CMunic getCMuniId() {
        return cMuniId;
    }

    public void setCMuniId(CMunic cMuniId) {
        this.cMuniId = cMuniId;
    }

    public CFuentesFin getCFuentesId() {
        return cFuentesId;
    }

    public void setCFuentesId(CFuentesFin cFuentesId) {
        this.cFuentesId = cFuentesId;
    }

    public CDeptos getCDeptoId() {
        return cDeptoId;
    }

    public void setCDeptoId(CDeptos cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    public CResponsables getCRespId() {
        return cRespId;
    }

    public void setCRespId(CResponsables cRespId) {
        this.cRespId = cRespId;
    }

//    public List<TBienes> getTBienesList() {
//        return tBienesList;
//    }

    public CNiveles getCNivelId() {
        return cNivelId;
    }

    public void setCNivelId(CNiveles cNivelId) {
        this.cNivelId = cNivelId;
    }

    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
    }

    
//    public void setTBienesList(List<TBienes> tBienesList) {
//        this.tBienesList = tBienesList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProyId != null ? cProyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProyectos)) {
            return false;
        }
        CProyectos other = (CProyectos) object;
        return false;
    }
//        if ((this.cProyId == null && other.cProyId != null) || (this.cProyId != null && !this.cProyId.equals(other.cProyId))) {
//            return false;
//        }
//        else{

    @Override
    public String toString() {
        return "entidades.CProyectos[ cProyId=" + cProyId + " ]";
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }
    
}
