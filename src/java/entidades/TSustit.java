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
@Table(name = "t_sustit")
@NamedQueries({
    @NamedQuery(name = "TSustit.findAll", query = "SELECT t FROM TSustit t"),
    @NamedQuery(name = "TSustit.findByTSustId", query = "SELECT t FROM TSustit t WHERE t.tSustId = :tSustId"),
    @NamedQuery(name = "TSustit.findByTSustTipo", query = "SELECT t FROM TSustit t WHERE t.tSustTipo = :tSustTipo"),
    @NamedQuery(name = "TSustit.findByTSustCorr", query = "SELECT t FROM TSustit t WHERE t.tSustCorr = :tSustCorr"),
    @NamedQuery(name = "TSustit.findByTSustAnio", query = "SELECT t FROM TSustit t WHERE t.tSustAnio = :tSustAnio"),
    @NamedQuery(name = "TSustit.findByTSustCodigo", query = "SELECT t FROM TSustit t WHERE t.tSustCodigo = :tSustCodigo"),
    @NamedQuery(name = "TSustit.findByTSustFechres", query = "SELECT t FROM TSustit t WHERE t.tSustFechres = :tSustFechres"),
    @NamedQuery(name = "TSustit.findByTSustCopiares", query = "SELECT t FROM TSustit t WHERE t.tSustCopiares = :tSustCopiares"),
    @NamedQuery(name = "TSustit.findByTSustFechdict", query = "SELECT t FROM TSustit t WHERE t.tSustFechdict = :tSustFechdict"),
    @NamedQuery(name = "TSustit.findByTSustCopiadict", query = "SELECT t FROM TSustit t WHERE t.tSustCopiadict = :tSustCopiadict"),
    @NamedQuery(name = "TSustit.findByTSustDescAnt", query = "SELECT t FROM TSustit t WHERE t.tSustDescAnt = :tSustDescAnt"),
    @NamedQuery(name = "TSustit.findByTSustMarcAnt", query = "SELECT t FROM TSustit t WHERE t.tSustMarcAnt = :tSustMarcAnt"),
    @NamedQuery(name = "TSustit.findByTSustModeAnt", query = "SELECT t FROM TSustit t WHERE t.tSustModeAnt = :tSustModeAnt"),
    @NamedQuery(name = "TSustit.findByTSustSerieAnt", query = "SELECT t FROM TSustit t WHERE t.tSustSerieAnt = :tSustSerieAnt"),
    @NamedQuery(name = "TSustit.findByTSustFecha", query = "SELECT t FROM TSustit t WHERE t.tSustFecha = :tSustFecha"),
    @NamedQuery(name = "TSustit.findByTSustDescNew", query = "SELECT t FROM TSustit t WHERE t.tSustDescNew = :tSustDescNew"),
    @NamedQuery(name = "TSustit.findByTSustMarcNew", query = "SELECT t FROM TSustit t WHERE t.tSustMarcNew = :tSustMarcNew"),
    @NamedQuery(name = "TSustit.findByTSustModeNew", query = "SELECT t FROM TSustit t WHERE t.tSustModeNew = :tSustModeNew"),
    @NamedQuery(name = "TSustit.findByTSustSerieNew", query = "SELECT t FROM TSustit t WHERE t.tSustSerieNew = :tSustSerieNew"),
    @NamedQuery(name = "TSustit.findByTSustUsec", query = "SELECT t FROM TSustit t WHERE t.tSustUsec = :tSustUsec"),
    @NamedQuery(name = "TSustit.findByTSustFechc", query = "SELECT t FROM TSustit t WHERE t.tSustFechc = :tSustFechc"),
    @NamedQuery(name = "TSustit.findByTSustUsem", query = "SELECT t FROM TSustit t WHERE t.tSustUsem = :tSustUsem"),
    @NamedQuery(name = "TSustit.findByTSustFechm", query = "SELECT t FROM TSustit t WHERE t.tSustFechm = :tSustFechm")})
public class TSustit implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_sust_id")
    private Integer tSustId;
    @Column(name = "t_sust_tipo")
    private Integer tSustTipo;
    @Column(name = "t_sust_corr")
    private Integer tSustCorr;
    @Column(name = "t_sust_anio")
    private Integer tSustAnio;
    @Size(max = 12)
    @Column(name = "t_sust_codigo")
    private String tSustCodigo;
    @Column(name = "t_sust_fechres")
    @Temporal(TemporalType.DATE)
    private Date tSustFechres;
    @Column(name = "t_sust_copiares")
    private Boolean tSustCopiares;
    @Column(name = "t_sust_fechdict")
    @Temporal(TemporalType.DATE)
    private Date tSustFechdict;
    @Column(name = "t_sust_copiadict")
    private Boolean tSustCopiadict;
    @Size(max = 100)
    @Column(name = "t_sust_desc_ant")
    private String tSustDescAnt;
    @Column(name = "t_sust_marc_ant")
    private Integer tSustMarcAnt;
    @Size(max = 20)
    @Column(name = "t_sust_mode_ant")
    private String tSustModeAnt;
    @Size(max = 20)
    @Column(name = "t_sust_serie_ant")
    private String tSustSerieAnt;
    @Column(name = "t_sust_fecha")
    @Temporal(TemporalType.DATE)
    private Date tSustFecha;
    @Size(max = 100)
    @Column(name = "t_sust_desc_new")
    private String tSustDescNew;
    @Column(name = "t_sust_marc_new")
    private Short tSustMarcNew;
    @Size(max = 20)
    @Column(name = "t_sust_mode_new")
    private String tSustModeNew;
    @Size(max = 20)
    @Column(name = "t_sust_serie_new")
    private String tSustSerieNew;
    @Column(name = "t_sust_usec")
    private Integer tSustUsec;
    @Column(name = "t_sust_fechc")
    @Temporal(TemporalType.DATE)
    private Date tSustFechc;
    @Column(name = "t_sust_usem")
    private Integer tSustUsem;
    @Column(name = "t_sust_fechm")
    @Temporal(TemporalType.DATE)
    private Date tSustFechm;
    
  
    @Column(name = "t_fechdic_id")
    private Integer tFechdicId;
    @Column(name = "t_fechsust_id")
    private Integer tFechsustId;
    @Column(name = "t_fechres_id")   
    private Integer tFechresId;
    
    
    @JoinColumn(name = "t_tm_id", referencedColumnName = "t_tm_id")
    @ManyToOne(optional = false)
    private TTiempo tTmId;
    @JoinColumn(name = "c_ubic_id", referencedColumnName = "c_ubic_id")
    @ManyToOne(optional = false)
    private CUbic cUbicId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne(optional = false)
    private CResponsables cRespId;
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

    @JoinColumn(name = "t_bien_id", referencedColumnName = "t_bien_id")
    @ManyToOne
    private TBienes tBienId;
    
    public TSustit() {
    }

    public TSustit(Integer tSustId) {
        this.tSustId = tSustId;
    }

    public Integer getTSustId() {
        return tSustId;
    }

    public void setTSustId(Integer tSustId) {
        this.tSustId = tSustId;
    }

    public Integer getTSustTipo() {
        return tSustTipo;
    }

    public void setTSustTipo(Integer tSustTipo) {
        this.tSustTipo = tSustTipo;
    }

    public Integer getTSustCorr() {
        return tSustCorr;
    }

    public void setTSustCorr(Integer tSustCorr) {
        this.tSustCorr = tSustCorr;
    }

    public Integer getTSustAnio() {
        return tSustAnio;
    }

    public void setTSustAnio(Integer tSustAnio) {
        this.tSustAnio = tSustAnio;
    }

    public String getTSustCodigo() {
        return tSustCodigo;
    }

    public void setTSustCodigo(String tSustCodigo) {
        this.tSustCodigo = tSustCodigo;
    }

    public Date getTSustFechres() {
        return tSustFechres;
    }

    public void setTSustFechres(Date tSustFechres) {
        this.tSustFechres = tSustFechres;
    }

    public Boolean getTSustCopiares() {
        return tSustCopiares;
    }

    public void setTSustCopiares(Boolean tSustCopiares) {
        this.tSustCopiares = tSustCopiares;
    }

    public Date getTSustFechdict() {
        return tSustFechdict;
    }

    public void setTSustFechdict(Date tSustFechdict) {
        this.tSustFechdict = tSustFechdict;
    }

    public Boolean getTSustCopiadict() {
        return tSustCopiadict;
    }

    public void setTSustCopiadict(Boolean tSustCopiadict) {
        this.tSustCopiadict = tSustCopiadict;
    }

    public String getTSustDescAnt() {
        return tSustDescAnt;
    }

    public void setTSustDescAnt(String tSustDescAnt) {
        this.tSustDescAnt = tSustDescAnt;
    }

    public Integer getTSustMarcAnt() {
        return tSustMarcAnt;
    }

    public void setTSustMarcAnt(Integer tSustMarcAnt) {
        this.tSustMarcAnt = tSustMarcAnt;
    }

    public String getTSustModeAnt() {
        return tSustModeAnt;
    }

    public void setTSustModeAnt(String tSustModeAnt) {
        this.tSustModeAnt = tSustModeAnt;
    }

    public String getTSustSerieAnt() {
        return tSustSerieAnt;
    }

    public void setTSustSerieAnt(String tSustSerieAnt) {
        this.tSustSerieAnt = tSustSerieAnt;
    }

    public Date getTSustFecha() {
        return tSustFecha;
    }

    public void setTSustFecha(Date tSustFecha) {
        this.tSustFecha = tSustFecha;
    }

    public String getTSustDescNew() {
        return tSustDescNew;
    }

    public void setTSustDescNew(String tSustDescNew) {
        this.tSustDescNew = tSustDescNew;
    }

    public Short getTSustMarcNew() {
        return tSustMarcNew;
    }

    public void setTSustMarcNew(Short tSustMarcNew) {
        this.tSustMarcNew = tSustMarcNew;
    }

    public String getTSustModeNew() {
        return tSustModeNew;
    }

    public void setTSustModeNew(String tSustModeNew) {
        this.tSustModeNew = tSustModeNew;
    }

    public String getTSustSerieNew() {
        return tSustSerieNew;
    }

    public void setTSustSerieNew(String tSustSerieNew) {
        this.tSustSerieNew = tSustSerieNew;
    }

    public Integer getTSustUsec() {
        return tSustUsec;
    }

    public void setTSustUsec(Integer tSustUsec) {
        this.tSustUsec = tSustUsec;
    }

    public Date getTSustFechc() {
        return tSustFechc;
    }

    public void setTSustFechc(Date tSustFechc) {
        this.tSustFechc = tSustFechc;
    }

    public Integer getTSustUsem() {
        return tSustUsem;
    }

    public void setTSustUsem(Integer tSustUsem) {
        this.tSustUsem = tSustUsem;
    }

    public Date getTSustFechm() {
        return tSustFechm;
    }

    public void setTSustFechm(Date tSustFechm) {
        this.tSustFechm = tSustFechm;
    }

  public TTiempo getTTmId() {
        return tTmId;
    }

    public void setTTmId(TTiempo tTmId) {
        this.tTmId = tTmId;
    }

    public CUbic getCUbicId() {
        return cUbicId;
    }

    public void setCUbicId(CUbic cUbicId) {
        this.cUbicId = cUbicId;
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

    public Integer getTFechdicId() {
        return tFechdicId;
    }

    public Integer getTFechsustId() {
        return tFechsustId;
    }

    public Integer getTFechresId() {
        return tFechresId;
    }

    public void setTFechdicId(Integer tFechdicId) {
        this.tFechdicId = tFechdicId;
    }

    public void setTFechsustId(Integer tFechsustId) {
        this.tFechsustId = tFechsustId;
    }

    public void setTFechresId(Integer tFechresId) {
        this.tFechresId = tFechresId;
    }

    public TBienes getTBienId() {
        return tBienId;
    }

    public void setTBienId(TBienes tBienId) {
        this.tBienId = tBienId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tSustId != null ? tSustId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSustit)) {
            return false;
        }
        TSustit other = (TSustit) object;
        if ((this.tSustId == null && other.tSustId != null) || (this.tSustId != null && !this.tSustId.equals(other.tSustId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TSustit[ tSustId=" + tSustId + " ]";
    }
    
}
