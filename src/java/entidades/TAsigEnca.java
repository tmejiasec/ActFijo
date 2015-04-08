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
@Table(name = "t_asig_enca")
@NamedQueries({
    @NamedQuery(name = "TAsigEnca.findAll", query = "SELECT t FROM TAsigEnca t"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeId", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeId = :tAsigeId"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeCorr", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeCorr = :tAsigeCorr"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeAnio", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeAnio = :tAsigeAnio"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeTec", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeTec = :tAsigeTec"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeMot", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeMot = :tAsigeMot"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeFecha", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeFecha = :tAsigeFecha"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeDoc", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeDoc = :tAsigeDoc"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeHorai", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeHorai = :tAsigeHorai"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeHoraf", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeHoraf = :tAsigeHoraf"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeObserv", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeObserv = :tAsigeObserv"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeDep", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeDep = :tAsigeDep"),
    @NamedQuery(name = "TAsigEnca.findByTAsigePers", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigePers = :tAsigePers"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeCargo", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeCargo = :tAsigeCargo"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeUsec", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeUsec = :tAsigeUsec"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeFechc", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeFechc = :tAsigeFechc"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeUsem", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeUsem = :tAsigeUsem"),
    @NamedQuery(name = "TAsigEnca.findByTAsigeFechm", query = "SELECT t FROM TAsigEnca t WHERE t.tAsigeFechm = :tAsigeFechm")})
public class TAsigEnca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_asige_id")
    private Integer tAsigeId;
    @Column(name = "t_asige_corr")
    private Short tAsigeCorr;
    @Column(name = "t_asige_anio")
    private Short tAsigeAnio;
    @Column(name = "t_asige_tec")
    private Short tAsigeTec;
    @Column(name = "t_asige_mot")
    private Character tAsigeMot;
    @Column(name = "t_asige_fecha")
    @Temporal(TemporalType.DATE)
    private Date tAsigeFecha;
    @Column(name = "t_asige_doc")
    private Boolean tAsigeDoc;
    @Column(name = "t_asige_horai")
    @Temporal(TemporalType.TIME)
    private Date tAsigeHorai;
    @Column(name = "t_asige_horaf")
    @Temporal(TemporalType.TIME)
    private Date tAsigeHoraf;
    @Size(max = 2147483647)
    @Column(name = "t_asige_observ")
    private String tAsigeObserv;
    @Column(name = "t_asige_dep")
    private Short tAsigeDep;
    @Size(max = 100)
    @Column(name = "t_asige_pers")
    private String tAsigePers;
    @Size(max = 50)
    @Column(name = "t_asige_cargo")
    private String tAsigeCargo;
    @Column(name = "t_asige_usec")
    private Short tAsigeUsec;
    @Column(name = "t_asige_fechc")
    @Temporal(TemporalType.DATE)
    private Date tAsigeFechc;
    @Column(name = "t_asige_usem")
    private Short tAsigeUsem;
    @Column(name = "t_asige_fechm")
    @Temporal(TemporalType.DATE)
    private Date tAsigeFechm;
    @JoinColumn(name = "t_tm_id", referencedColumnName = "t_tm_id")
    @ManyToOne(optional = false)
    private TTiempo tTmId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne(optional = false)
    private CResponsables cRespId;
    @JoinColumn(name = "c_jefesd_id", referencedColumnName = "c_jefesd_id")
    @ManyToOne(optional = false)
    private CJefesDep cJefesdId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tAsigeId")
    private List<TAsigDeta> tAsigDetaList;

    public TAsigEnca() {
    }

    public TAsigEnca(Integer tAsigeId) {
        this.tAsigeId = tAsigeId;
    }

    public Integer getTAsigeId() {
        return tAsigeId;
    }

    public void setTAsigeId(Integer tAsigeId) {
        this.tAsigeId = tAsigeId;
    }

    public Short getTAsigeCorr() {
        return tAsigeCorr;
    }

    public void setTAsigeCorr(Short tAsigeCorr) {
        this.tAsigeCorr = tAsigeCorr;
    }

    public Short getTAsigeAnio() {
        return tAsigeAnio;
    }

    public void setTAsigeAnio(Short tAsigeAnio) {
        this.tAsigeAnio = tAsigeAnio;
    }

    public Short getTAsigeTec() {
        return tAsigeTec;
    }

    public void setTAsigeTec(Short tAsigeTec) {
        this.tAsigeTec = tAsigeTec;
    }

    public Character getTAsigeMot() {
        return tAsigeMot;
    }

    public void setTAsigeMot(Character tAsigeMot) {
        this.tAsigeMot = tAsigeMot;
    }

    public Date getTAsigeFecha() {
        return tAsigeFecha;
    }

    public void setTAsigeFecha(Date tAsigeFecha) {
        this.tAsigeFecha = tAsigeFecha;
    }

    public Boolean getTAsigeDoc() {
        return tAsigeDoc;
    }

    public void setTAsigeDoc(Boolean tAsigeDoc) {
        this.tAsigeDoc = tAsigeDoc;
    }

    public Date getTAsigeHorai() {
        return tAsigeHorai;
    }

    public void setTAsigeHorai(Date tAsigeHorai) {
        this.tAsigeHorai = tAsigeHorai;
    }

    public Date getTAsigeHoraf() {
        return tAsigeHoraf;
    }

    public void setTAsigeHoraf(Date tAsigeHoraf) {
        this.tAsigeHoraf = tAsigeHoraf;
    }

    public String getTAsigeObserv() {
        return tAsigeObserv;
    }

    public void setTAsigeObserv(String tAsigeObserv) {
        this.tAsigeObserv = tAsigeObserv;
    }

    public Short getTAsigeDep() {
        return tAsigeDep;
    }

    public void setTAsigeDep(Short tAsigeDep) {
        this.tAsigeDep = tAsigeDep;
    }

    public String getTAsigePers() {
        return tAsigePers;
    }

    public void setTAsigePers(String tAsigePers) {
        this.tAsigePers = tAsigePers;
    }

    public String getTAsigeCargo() {
        return tAsigeCargo;
    }

    public void setTAsigeCargo(String tAsigeCargo) {
        this.tAsigeCargo = tAsigeCargo;
    }

    public Short getTAsigeUsec() {
        return tAsigeUsec;
    }

    public void setTAsigeUsec(Short tAsigeUsec) {
        this.tAsigeUsec = tAsigeUsec;
    }

    public Date getTAsigeFechc() {
        return tAsigeFechc;
    }

    public void setTAsigeFechc(Date tAsigeFechc) {
        this.tAsigeFechc = tAsigeFechc;
    }

    public Short getTAsigeUsem() {
        return tAsigeUsem;
    }

    public void setTAsigeUsem(Short tAsigeUsem) {
        this.tAsigeUsem = tAsigeUsem;
    }

    public Date getTAsigeFechm() {
        return tAsigeFechm;
    }

    public void setTAsigeFechm(Date tAsigeFechm) {
        this.tAsigeFechm = tAsigeFechm;
    }

    public TTiempo getTTmId() {
        return tTmId;
    }

    public void setTTmId(TTiempo tTmId) {
        this.tTmId = tTmId;
    }

    public CResponsables getCRespId() {
        return cRespId;
    }

    public void setCRespId(CResponsables cRespId) {
        this.cRespId = cRespId;
    }

    public CJefesDep getCJefesdId() {
        return cJefesdId;
    }

    public void setCJefesdId(CJefesDep cJefesdId) {
        this.cJefesdId = cJefesdId;
    }

    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
    }

    public List<TAsigDeta> getTAsigDetaList() {
        return tAsigDetaList;
    }

    public void setTAsigDetaList(List<TAsigDeta> tAsigDetaList) {
        this.tAsigDetaList = tAsigDetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tAsigeId != null ? tAsigeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAsigEnca)) {
            return false;
        }
        TAsigEnca other = (TAsigEnca) object;
        if ((this.tAsigeId == null && other.tAsigeId != null) || (this.tAsigeId != null && !this.tAsigeId.equals(other.tAsigeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TAsigEnca[ tAsigeId=" + tAsigeId + " ]";
    }
    
}
