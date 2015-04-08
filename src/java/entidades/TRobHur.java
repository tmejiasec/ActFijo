/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_rob_hur")
@NamedQueries({
    @NamedQuery(name = "TRobHur.findAll", query = "SELECT t FROM TRobHur t"),
    @NamedQuery(name = "TRobHur.findByTRhId", query = "SELECT t FROM TRobHur t WHERE t.tRhId = :tRhId"),
    @NamedQuery(name = "TRobHur.findByTRhClase", query = "SELECT t FROM TRobHur t WHERE t.tRhClase = :tRhClase"),
    @NamedQuery(name = "TRobHur.findByTRhCorr", query = "SELECT t FROM TRobHur t WHERE t.tRhCorr = :tRhCorr"),
    @NamedQuery(name = "TRobHur.findByTRhAnio", query = "SELECT t FROM TRobHur t WHERE t.tRhAnio = :tRhAnio"),
    @NamedQuery(name = "TRobHur.findByTRhCodigo", query = "SELECT t FROM TRobHur t WHERE t.tRhCodigo = :tRhCodigo"),
    @NamedQuery(name = "TRobHur.findByTRhFecdenun", query = "SELECT t FROM TRobHur t WHERE t.tRhFecdenun = :tRhFecdenun"),
    @NamedQuery(name = "TRobHur.findByTRhFecdenunId", query = "SELECT t FROM TRobHur t WHERE t.tRhFecdenunId = :tRhFecdenunId"),
    @NamedQuery(name = "TRobHur.findByTRhCopiad", query = "SELECT t FROM TRobHur t WHERE t.tRhCopiad = :tRhCopiad"),
    @NamedQuery(name = "TRobHur.findByTRhFecinfor", query = "SELECT t FROM TRobHur t WHERE t.tRhFecinfor = :tRhFecinfor"),
    @NamedQuery(name = "TRobHur.findByTRhFecinforId", query = "SELECT t FROM TRobHur t WHERE t.tRhFecinforId = :tRhFecinforId"),
    @NamedQuery(name = "TRobHur.findByTRhCopiainf", query = "SELECT t FROM TRobHur t WHERE t.tRhCopiainf = :tRhCopiainf"),
    @NamedQuery(name = "TRobHur.findByTRhTramite", query = "SELECT t FROM TRobHur t WHERE t.tRhTramite = :tRhTramite"),
    @NamedQuery(name = "TRobHur.findByTRhObserv", query = "SELECT t FROM TRobHur t WHERE t.tRhObserv = :tRhObserv"),
    @NamedQuery(name = "TRobHur.findByTRhFecfin", query = "SELECT t FROM TRobHur t WHERE t.tRhFecfin = :tRhFecfin"),
    @NamedQuery(name = "TRobHur.findByTRhFecfinId", query = "SELECT t FROM TRobHur t WHERE t.tRhFecfinId = :tRhFecfinId"),
    @NamedQuery(name = "TRobHur.findByTRhEstadof", query = "SELECT t FROM TRobHur t WHERE t.tRhEstadof = :tRhEstadof"),
    @NamedQuery(name = "TRobHur.findByTRhUsec", query = "SELECT t FROM TRobHur t WHERE t.tRhUsec = :tRhUsec"),
    @NamedQuery(name = "TRobHur.findByTRhFechc", query = "SELECT t FROM TRobHur t WHERE t.tRhFechc = :tRhFechc"),
    @NamedQuery(name = "TRobHur.findByTRhUsem", query = "SELECT t FROM TRobHur t WHERE t.tRhUsem = :tRhUsem"),
    @NamedQuery(name = "TRobHur.findByTRhFechm", query = "SELECT t FROM TRobHur t WHERE t.tRhFechm = :tRhFechm")})
public class TRobHur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_rh_id")
    private Integer tRhId;
    @Column(name = "t_rh_clase")
    private Short tRhClase;
    @Column(name = "t_rh_corr")
    private Short tRhCorr;
    @Column(name = "t_rh_anio")
    private Short tRhAnio;
    @Size(max = 12)
    @Column(name = "t_rh_codigo")
    private String tRhCodigo;
    @Column(name = "t_rh_fecdenun")
    @Temporal(TemporalType.DATE)
    private Date tRhFecdenun;
    @Column(name = "t_rh_fecdenun_id")
    private Short tRhFecdenunId;
    @Column(name = "t_rh_copiad")
    private Boolean tRhCopiad;
    @Column(name = "t_rh_fecinfor")
    @Temporal(TemporalType.DATE)
    private Date tRhFecinfor;
    @Column(name = "t_rh_fecinfor_id")
    private Short tRhFecinforId;
    @Column(name = "t_rh_copiainf")
    private Boolean tRhCopiainf;
    @Column(name = "t_rh_tramite")
    private Short tRhTramite;
    @Size(max = 2147483647)
    @Column(name = "t_rh_observ")
    private String tRhObserv;
    @Column(name = "t_rh_fecfin")
    @Temporal(TemporalType.DATE)
    private Date tRhFecfin;
    @Column(name = "t_rh_fecfin_id")
    private Short tRhFecfinId;
    @Column(name = "t_rh_estadof")
    private Short tRhEstadof;
    @Column(name = "t_rh_usec")
    private Short tRhUsec;
    @Column(name = "t_rh_fechc")
    @Temporal(TemporalType.DATE)
    private Date tRhFechc;
    @Column(name = "t_rh_usem")
    private Short tRhUsem;
    @Column(name = "t_rh_fechm")
    @Temporal(TemporalType.DATE)
    private Date tRhFechm;
    @JoinColumn(name = "c_ubic_id", referencedColumnName = "c_ubic_id")
    @ManyToOne(optional = false)
    private CUbic cUbicId;
    @JoinColumn(name = "c_jefesd_id", referencedColumnName = "c_jefesd_id")
    @ManyToOne(optional = false)
    private CJefesDep cJefesdId;
    @JoinColumn(name = "c_edif_id", referencedColumnName = "c_edif_id")
    @ManyToOne
    private CEdificios cEdifId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;
    @JoinColumn(name = "c_area_id", referencedColumnName = "c_area_id")
    @ManyToOne
    private CAreas cAreaId;

    public TRobHur() {
    }

    public TRobHur(Integer tRhId) {
        this.tRhId = tRhId;
    }

    public Integer getTRhId() {
        return tRhId;
    }

    public void setTRhId(Integer tRhId) {
        this.tRhId = tRhId;
    }

    public Short getTRhClase() {
        return tRhClase;
    }

    public void setTRhClase(Short tRhClase) {
        this.tRhClase = tRhClase;
    }

    public Short getTRhCorr() {
        return tRhCorr;
    }

    public void setTRhCorr(Short tRhCorr) {
        this.tRhCorr = tRhCorr;
    }

    public Short getTRhAnio() {
        return tRhAnio;
    }

    public void setTRhAnio(Short tRhAnio) {
        this.tRhAnio = tRhAnio;
    }

    public String getTRhCodigo() {
        return tRhCodigo;
    }

    public void setTRhCodigo(String tRhCodigo) {
        this.tRhCodigo = tRhCodigo;
    }

    public Date getTRhFecdenun() {
        return tRhFecdenun;
    }

    public void setTRhFecdenun(Date tRhFecdenun) {
        this.tRhFecdenun = tRhFecdenun;
    }

    public Short getTRhFecdenunId() {
        return tRhFecdenunId;
    }

    public void setTRhFecdenunId(Short tRhFecdenunId) {
        this.tRhFecdenunId = tRhFecdenunId;
    }

    public Boolean getTRhCopiad() {
        return tRhCopiad;
    }

    public void setTRhCopiad(Boolean tRhCopiad) {
        this.tRhCopiad = tRhCopiad;
    }

    public Date getTRhFecinfor() {
        return tRhFecinfor;
    }

    public void setTRhFecinfor(Date tRhFecinfor) {
        this.tRhFecinfor = tRhFecinfor;
    }

    public Short getTRhFecinforId() {
        return tRhFecinforId;
    }

    public void setTRhFecinforId(Short tRhFecinforId) {
        this.tRhFecinforId = tRhFecinforId;
    }

    public Boolean getTRhCopiainf() {
        return tRhCopiainf;
    }

    public void setTRhCopiainf(Boolean tRhCopiainf) {
        this.tRhCopiainf = tRhCopiainf;
    }

    public Short getTRhTramite() {
        return tRhTramite;
    }

    public void setTRhTramite(Short tRhTramite) {
        this.tRhTramite = tRhTramite;
    }

    public String getTRhObserv() {
        return tRhObserv;
    }

    public void setTRhObserv(String tRhObserv) {
        this.tRhObserv = tRhObserv;
    }

    public Date getTRhFecfin() {
        return tRhFecfin;
    }

    public void setTRhFecfin(Date tRhFecfin) {
        this.tRhFecfin = tRhFecfin;
    }

    public Short getTRhFecfinId() {
        return tRhFecfinId;
    }

    public void setTRhFecfinId(Short tRhFecfinId) {
        this.tRhFecfinId = tRhFecfinId;
    }

    public Short getTRhEstadof() {
        return tRhEstadof;
    }

    public void setTRhEstadof(Short tRhEstadof) {
        this.tRhEstadof = tRhEstadof;
    }

    public Short getTRhUsec() {
        return tRhUsec;
    }

    public void setTRhUsec(Short tRhUsec) {
        this.tRhUsec = tRhUsec;
    }

    public Date getTRhFechc() {
        return tRhFechc;
    }

    public void setTRhFechc(Date tRhFechc) {
        this.tRhFechc = tRhFechc;
    }

    public Short getTRhUsem() {
        return tRhUsem;
    }

    public void setTRhUsem(Short tRhUsem) {
        this.tRhUsem = tRhUsem;
    }

    public Date getTRhFechm() {
        return tRhFechm;
    }

    public void setTRhFechm(Date tRhFechm) {
        this.tRhFechm = tRhFechm;
    }

    public CUbic getCUbicId() {
        return cUbicId;
    }

    public void setCUbicId(CUbic cUbicId) {
        this.cUbicId = cUbicId;
    }

    public CJefesDep getCJefesdId() {
        return cJefesdId;
    }

    public void setCJefesdId(CJefesDep cJefesdId) {
        this.cJefesdId = cJefesdId;
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

    public CAreas getCAreaId() {
        return cAreaId;
    }

    public void setCAreaId(CAreas cAreaId) {
        this.cAreaId = cAreaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tRhId != null ? tRhId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRobHur)) {
            return false;
        }
        TRobHur other = (TRobHur) object;
        if ((this.tRhId == null && other.tRhId != null) || (this.tRhId != null && !this.tRhId.equals(other.tRhId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TRobHur[ tRhId=" + tRhId + " ]";
    }
    
}
