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
@Table(name = "t_recep_enca")
@NamedQueries({
    @NamedQuery(name = "TRecepEnca.findAll", query = "SELECT t FROM TRecepEnca t"),
    @NamedQuery(name = "TRecepEnca.findByTReceId", query = "SELECT t FROM TRecepEnca t WHERE t.tReceId = :tReceId"),
    @NamedQuery(name = "TRecepEnca.findByTReceMot", query = "SELECT t FROM TRecepEnca t WHERE t.tReceMot = :tReceMot"),
    @NamedQuery(name = "TRecepEnca.findByTReceCorr", query = "SELECT t FROM TRecepEnca t WHERE t.tReceCorr = :tReceCorr"),
    @NamedQuery(name = "TRecepEnca.findByTReceAnio", query = "SELECT t FROM TRecepEnca t WHERE t.tReceAnio = :tReceAnio"),
    @NamedQuery(name = "TRecepEnca.findByTReceTec", query = "SELECT t FROM TRecepEnca t WHERE t.tReceTec = :tReceTec"),
    @NamedQuery(name = "TRecepEnca.findByTReceFecha", query = "SELECT t FROM TRecepEnca t WHERE t.tReceFecha = :tReceFecha"),
    @NamedQuery(name = "TRecepEnca.findByTReceHorai", query = "SELECT t FROM TRecepEnca t WHERE t.tReceHorai = :tReceHorai"),
    @NamedQuery(name = "TRecepEnca.findByTReceHoraf", query = "SELECT t FROM TRecepEnca t WHERE t.tReceHoraf = :tReceHoraf"),
    @NamedQuery(name = "TRecepEnca.findByTReceObserv", query = "SELECT t FROM TRecepEnca t WHERE t.tReceObserv = :tReceObserv"),
    @NamedQuery(name = "TRecepEnca.findByTReceDoc", query = "SELECT t FROM TRecepEnca t WHERE t.tReceDoc = :tReceDoc"),
    @NamedQuery(name = "TRecepEnca.findByTReceUsec", query = "SELECT t FROM TRecepEnca t WHERE t.tReceUsec = :tReceUsec"),
    @NamedQuery(name = "TRecepEnca.findByTReceFechc", query = "SELECT t FROM TRecepEnca t WHERE t.tReceFechc = :tReceFechc"),
    @NamedQuery(name = "TRecepEnca.findByTReceUsem", query = "SELECT t FROM TRecepEnca t WHERE t.tReceUsem = :tReceUsem"),
    @NamedQuery(name = "TRecepEnca.findByCJefesId", query="SELECT m FROM TRecepEnca m WHERE m.cJefesdId.cJefesdId = :cJefesId"),
    @NamedQuery(name = "TRecepEnca.findByTReceFechm", query = "SELECT t FROM TRecepEnca t WHERE t.tReceFechm = :tReceFechm")})
public class TRecepEnca implements Serializable {
    @Column(name = "t_rece_horac")
    @Temporal(TemporalType.TIME)
    private Date tReceHorac;
    @Column(name = "t_rece_horam")
    @Temporal(TemporalType.TIME)
    private Date tReceHoram;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_rece_id")
    private Integer tReceId;
    @Column(name = "t_rece_mot")
    private String tReceMot;
    @Column(name = "t_rece_corr")
    private Integer tReceCorr;
    @Column(name = "t_rece_anio")
    private Integer tReceAnio;
    @Column(name = "t_rece_tec")
    private Integer tReceTec;
    @Column(name = "t_rece_fecha")
    @Temporal(TemporalType.DATE)
    private Date tReceFecha;
    @Column(name = "t_rece_horai")
    @Temporal(TemporalType.TIME)
    private Date tReceHorai;
    @Column(name = "t_rece_horaf")
    @Temporal(TemporalType.TIME)
    private Date tReceHoraf;
    @Size(max = 2147483647)
    @Column(name = "t_rece_observ")
    private String tReceObserv;
    @Column(name = "t_rece_doc")
    private Boolean tReceDoc;
    @Column(name = "t_rece_usec")
    private Integer tReceUsec;
    @Column(name = "t_rece_fechc")
    @Temporal(TemporalType.DATE)
    private Date tReceFechc;
    @Column(name = "t_rece_usem")
    private Integer tReceUsem;
    @Column(name = "t_rece_fechm")
    @Temporal(TemporalType.DATE)
    private Date tReceFechm;
    @Column(name = "t_rece_fechc_id")
    private Integer tReceFechcId;
    @Column(name = "t_rece_fechm_id")
    private Integer tReceFechmId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tReceId")
    private List<TRecepDeta> tRecepDetaList;
    @JoinColumn(name = "t_tm_id", referencedColumnName = "t_tm_id")
    @ManyToOne(optional = false)
    private TTiempo tTmId;
    @JoinColumn(name = "c_jefesd_id", referencedColumnName = "c_jefesd_id")
    @ManyToOne(optional = false)
    private CJefesDep cJefesdId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne(optional = false)
    private CResponsables cRespId;
    
    //c_resp_id
    
    public TRecepEnca() {
    }

    public TRecepEnca(Integer tReceId) {
        this.tReceId = tReceId;
    }

    public Integer getTReceId() {
        return tReceId;
    }

    public void setTReceId(Integer tReceId) {
        this.tReceId = tReceId;
    }

    public String getTReceMot() {
        return tReceMot;
    }

    public void setTReceMot(String tReceMot) {
        this.tReceMot = tReceMot;
    }

    public Integer getTReceCorr() {
        return tReceCorr;
    }

    public void setTReceCorr(Integer tReceCorr) {
        this.tReceCorr = tReceCorr;
    }

    public Integer getTReceAnio() {
        return tReceAnio;
    }

    public void setTReceAnio(Integer tReceAnio) {
        this.tReceAnio = tReceAnio;
    }

    public Integer getTReceTec() {
        return tReceTec;
    }

    public void setTReceTec(Integer tReceTec) {
        this.tReceTec = tReceTec;
    }

    public Date getTReceFecha() {
        return tReceFecha;
    }

    public void setTReceFecha(Date tReceFecha) {
        this.tReceFecha = tReceFecha;
    }

    public Date getTReceHorai() {
        return tReceHorai;
    }

    public void setTReceHorai(Date tReceHorai) {
        this.tReceHorai = tReceHorai;
    }

    public Date getTReceHoraf() {
        return tReceHoraf;
    }

    public void setTReceHoraf(Date tReceHoraf) {
        this.tReceHoraf = tReceHoraf;
    }

    public String getTReceObserv() {
        return tReceObserv;
    }

    public void setTReceObserv(String tReceObserv) {
        this.tReceObserv = tReceObserv;
    }

    public Boolean getTReceDoc() {
        return tReceDoc;
    }

    public void setTReceDoc(Boolean tReceDoc) {
        this.tReceDoc = tReceDoc;
    }

    public Integer getTReceUsec() {
        return tReceUsec;
    }

    public void setTReceUsec(Integer tReceUsec) {
        this.tReceUsec = tReceUsec;
    }

    public Date getTReceFechc() {
        return tReceFechc;
    }

    public void setTReceFechc(Date tReceFechc) {
        this.tReceFechc = tReceFechc;
    }

    public Integer getTReceUsem() {
        return tReceUsem;
    }

    public void setTReceUsem(Integer tReceUsem) {
        this.tReceUsem = tReceUsem;
    }

    public Date getTReceFechm() {
        return tReceFechm;
    }

    public void setTReceFechm(Date tReceFechm) {
        this.tReceFechm = tReceFechm;
    }

    public List<TRecepDeta> getTRecepDetaList() {
        return tRecepDetaList;
    }

    public void setTRecepDetaList(List<TRecepDeta> tRecepDetaList) {
        this.tRecepDetaList = tRecepDetaList;
    }

    public TTiempo getTTmId() {
        return tTmId;
    }

    public void setTTmId(TTiempo tTmId) {
        this.tTmId = tTmId;
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


    public Integer getTReceFechcId() {
        return tReceFechcId;
    }

    public void setTReceFechcId(Integer tReceFechcId) {
        this.tReceFechcId = tReceFechcId;
    }

    public Integer getTReceFechmId() {
        return tReceFechmId;
    }

    public void setTReceFechmId(Integer tReceFechmId) {
        this.tReceFechmId = tReceFechmId;
    }


    public CResponsables getCRespId() {
        return cRespId;
    }

    public void setCRespId(CResponsables cRespId) {
        this.cRespId = cRespId;
    }

    
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tReceId != null ? tReceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRecepEnca)) {
            return false;
        }
        TRecepEnca other = (TRecepEnca) object;
        if ((this.tReceId == null && other.tReceId != null) || (this.tReceId != null && !this.tReceId.equals(other.tReceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TRecepEnca[ tReceId=" + tReceId + " ]";
    }

    public Date getTReceHorac() {
        return tReceHorac;
    }

    public void setTReceHorac(Date tReceHorac) {
        this.tReceHorac = tReceHorac;
    }

    public Date getTReceHoram() {
        return tReceHoram;
    }

    public void setTReceHoram(Date tReceHoram) {
        this.tReceHoram = tReceHoram;
    }
    
}
