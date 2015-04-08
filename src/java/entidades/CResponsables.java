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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_responsables")
@NamedQueries({
    @NamedQuery(name = "CResponsables.findAll", query = "SELECT c FROM CResponsables c"),
    @NamedQuery(name = "CResponsables.findByCRespId", query = "SELECT c FROM CResponsables c WHERE c.cRespId = :cRespId"),
    @NamedQuery(name = "CResponsables.findByCRespNom1", query = "SELECT c FROM CResponsables c WHERE c.cRespNom1 = :cRespNom1"),
    @NamedQuery(name = "CResponsables.findByCRespNom2", query = "SELECT c FROM CResponsables c WHERE c.cRespNom2 = :cRespNom2"),
    @NamedQuery(name = "CResponsables.findByCRespNom3", query = "SELECT c FROM CResponsables c WHERE c.cRespNom3 = :cRespNom3"),
    @NamedQuery(name = "CResponsables.findByCRespApe1", query = "SELECT c FROM CResponsables c WHERE c.cRespApe1 = :cRespApe1"),
    @NamedQuery(name = "CResponsables.findByCRespApe2", query = "SELECT c FROM CResponsables c WHERE c.cRespApe2 = :cRespApe2"),
    @NamedQuery(name = "CResponsables.findByCRespApec", query = "SELECT c FROM CResponsables c WHERE c.cRespApec = :cRespApec"),
    @NamedQuery(name = "CResponsables.findByCRespCargo", query = "SELECT c FROM CResponsables c WHERE c.cRespCargo = :cRespCargo"),
    @NamedQuery(name = "CResponsables.findByCRespDui", query = "SELECT c FROM CResponsables c WHERE c.cRespDui = :cRespDui"),
    @NamedQuery(name = "CResponsables.findByCRespNit", query = "SELECT c FROM CResponsables c WHERE c.cRespNit = :cRespNit"),
    @NamedQuery(name = "CResponsables.findByCRespCorreo", query = "SELECT c FROM CResponsables c WHERE c.cRespCorreo = :cRespCorreo"),
    @NamedQuery(name = "CResponsables.findByCRespTelofi", query = "SELECT c FROM CResponsables c WHERE c.cRespTelofi = :cRespTelofi"),
    @NamedQuery(name = "CResponsables.findByCRespEstado", query = "SELECT c FROM CResponsables c WHERE c.cRespEstado = :cRespEstado"),
    @NamedQuery(name = "CResponsables.findByCRespFechr", query = "SELECT c FROM CResponsables c WHERE c.cRespFechr = :cRespFechr")})
public class CResponsables implements Serializable {
    @OneToMany(mappedBy = "cRespId")
    private List<CProyectos> cProyectosList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_resp_id")
    private Integer cRespId;
    @Size(max = 20)
    @Column(name = "c_resp_nom1")
    private String cRespNom1;
    @Size(max = 20)
    @Column(name = "c_resp_nom2")
    private String cRespNom2;
    @Size(max = 20)
    @Column(name = "c_resp_nom3")
    private String cRespNom3;
    @Size(max = 20)
    @Column(name = "c_resp_ape1")
    private String cRespApe1;
    @Size(max = 20)
    @Column(name = "c_resp_ape2")
    private String cRespApe2;
    @Size(max = 20)
    @Column(name = "c_resp_apec")
    private String cRespApec;
    @Size(max = 75)
    @Column(name = "c_resp_cargo")
    private String cRespCargo;
    @Size(max = 10)
    @Column(name = "c_resp_dui")
    private String cRespDui;
    @Size(max = 17)
    @Column(name = "c_resp_nit")
    private String cRespNit;
    @Size(max = 75)
    @Column(name = "c_resp_correo")
    private String cRespCorreo;
    @Size(max = 15)
    @Column(name = "c_resp_telofi")
    private String cRespTelofi;
    @Size(max = 10)
    @Column(name = "c_resp_estado")
    private String cRespEstado;
    @Column(name = "c_resp_fechr")
    @Temporal(TemporalType.DATE)
    private Date cRespFechr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRespId")
    private List<TAsigEnca> tAsigEncaList;
    @JoinColumn(name = "c_nivel_id", referencedColumnName = "c_nivel_id")
    @ManyToOne
    private CNiveles cNivelId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRespId")
    private List<TDescargDeta> tDescargDetaList;
    @OneToMany(mappedBy = "cRespId")
    private List<TBienes> tBienesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRespId")
    private List<TSustit> tSustitList;

    public CResponsables() {
    }

    public CResponsables(Integer cRespId) {
        this.cRespId = cRespId;
    }

    public Integer getCRespId() {
        return cRespId;
    }

    public void setCRespId(Integer cRespId) {
        this.cRespId = cRespId;
    }

    public String getCRespNom1() {
        return cRespNom1;
    }

    public void setCRespNom1(String cRespNom1) {
        this.cRespNom1 = cRespNom1;
    }

    public String getCRespNom2() {
        return cRespNom2;
    }

    public void setCRespNom2(String cRespNom2) {
        this.cRespNom2 = cRespNom2;
    }

    public String getCRespNom3() {
        return cRespNom3;
    }

    public void setCRespNom3(String cRespNom3) {
        this.cRespNom3 = cRespNom3;
    }

    public String getCRespApe1() {
        return cRespApe1;
    }

    public void setCRespApe1(String cRespApe1) {
        this.cRespApe1 = cRespApe1;
    }

    public String getCRespApe2() {
        return cRespApe2;
    }

    public void setCRespApe2(String cRespApe2) {
        this.cRespApe2 = cRespApe2;
    }

    public String getCRespApec() {
        return cRespApec;
    }

    public void setCRespApec(String cRespApec) {
        this.cRespApec = cRespApec;
    }

    public String getCRespCargo() {
        return cRespCargo;
    }

    public void setCRespCargo(String cRespCargo) {
        this.cRespCargo = cRespCargo;
    }

    public String getCRespDui() {
        return cRespDui;
    }

    public void setCRespDui(String cRespDui) {
        this.cRespDui = cRespDui;
    }

    public String getCRespNit() {
        return cRespNit;
    }

    public void setCRespNit(String cRespNit) {
        this.cRespNit = cRespNit;
    }

    public String getCRespCorreo() {
        return cRespCorreo;
    }

    public void setCRespCorreo(String cRespCorreo) {
        this.cRespCorreo = cRespCorreo;
    }

    public String getCRespTelofi() {
        return cRespTelofi;
    }

    public void setCRespTelofi(String cRespTelofi) {
        this.cRespTelofi = cRespTelofi;
    }

    public String getCRespEstado() {
        return cRespEstado;
    }

    public void setCRespEstado(String cRespEstado) {
        this.cRespEstado = cRespEstado;
    }

    public Date getCRespFechr() {
        return cRespFechr;
    }

    public void setCRespFechr(Date cRespFechr) {
        this.cRespFechr = cRespFechr;
    }

    public List<TAsigEnca> getTAsigEncaList() {
        return tAsigEncaList;
    }

    public void setTAsigEncaList(List<TAsigEnca> tAsigEncaList) {
        this.tAsigEncaList = tAsigEncaList;
    }

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
        hash += (cRespId != null ? cRespId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CResponsables)) {
            return false;
        }
        CResponsables other = (CResponsables) object;
        if ((this.cRespId == null && other.cRespId != null) || (this.cRespId != null && !this.cRespId.equals(other.cRespId))) {
            return false;
        }
        else{
        return true;
        }
    }

    @Override
    public String toString() {
        return "entidades.CResponsables[ cRespId=" + cRespId + " ]";
    }

    public List<CProyectos> getCProyectosList() {
        return cProyectosList;
    }

    public void setCProyectosList(List<CProyectos> cProyectosList) {
        this.cProyectosList = cProyectosList;
    }
    
}
