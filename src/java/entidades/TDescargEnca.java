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

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_descarg_enca")
@NamedQueries({
    @NamedQuery(name = "TDescargEnca.findAll", query = "SELECT t FROM TDescargEnca t"),
    @NamedQuery(name = "TDescargEnca.findByTDescencId", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencId = :tDescencId"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCorr", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCorr = :tDescencCorr"),
    @NamedQuery(name = "TDescargEnca.findByTDescencAnio", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencAnio = :tDescencAnio"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechsol", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechsol = :tDescencFechsol"),
    @NamedQuery(name = "TDescargEnca.findByTDescencEstado", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencEstado = :tDescencEstado"),
    @NamedQuery(name = "TDescargEnca.findByTDescencTidoc", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencTidoc = :tDescencTidoc"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCopiadoc", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCopiadoc = :tDescencCopiadoc"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechaut", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechaut = :tDescencFechaut"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCodaut", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCodaut = :tDescencCodaut"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechpro", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechpro = :tDescencFechpro"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCodpro", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCodpro = :tDescencCodpro"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechres", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechres = :tDescencFechres"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCodres", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCodres = :tDescencCodres"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechdes", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechdes = :tDescencFechdes"),
    @NamedQuery(name = "TDescargEnca.findByTDescencCoddes", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencCoddes = :tDescencCoddes"),
    @NamedQuery(name = "TDescargEnca.findByTDescencUsec", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencUsec = :tDescencUsec"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechc", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechc = :tDescencFechc"),
    @NamedQuery(name = "TDescargEnca.findByTDescencUsem", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencUsem = :tDescencUsem"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechm", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechm = :tDescencFechm"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechsolId", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechsolId = :tDescencFechsolId"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechdesId", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechdesId = :tDescencFechdesId"),
    @NamedQuery(name = "TDescargEnca.findByCJefesId", query="SELECT m FROM TDescargEnca m WHERE m.cJefesdId.cJefesdId = :cJefesId"),
    @NamedQuery(name = "TDescargEnca.findByTDescencFechautId", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechautId = :tDescencFechautId")})
public class TDescargEnca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_descenc_id")
    private Integer tDescencId;
    @Column(name = "t_descenc_fechsol")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechsol;
    @Column(name = "t_descenc_copiadoc")
    private Boolean tDescencCopiadoc;
    @Column(name = "t_descenc_fechaut")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechaut;
    @Column(name = "t_descenc_fechpro")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechpro;
    @Column(name = "t_descenc_fechres")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechres;
    @Column(name = "t_descenc_fechdes")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechdes;
    @Column(name = "t_descenc_fechc")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechc;
    @Column(name = "t_descenc_fechm")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechm;
    @Column(name = "t_descenc_corr")
    private Integer tDescencCorr;
    @Column(name = "t_descenc_anio")
    private Integer tDescencAnio;
    @Column(name = "t_descenc_estado")
    private Integer tDescencEstado;
    @Column(name = "t_descenc_tidoc")
    private Integer tDescencTidoc;
    @Column(name = "t_descenc_codaut")
    private Integer tDescencCodaut;
    @Column(name = "t_descenc_codpro")
    private Integer tDescencCodpro;
    @Column(name = "t_descenc_codres")
    private Integer tDescencCodres;
    @Column(name = "t_descenc_coddes")
    private Integer tDescencCoddes;
    @Column(name = "t_descenc_usec")
    private Integer tDescencUsec;
    @Column(name = "t_descenc_usem")
    private Integer tDescencUsem;
    @Column(name = "t_descenc_fechsol_id")
    private Integer tDescencFechsolId;
    @Column(name = "t_descenc_fechdes_id")
    private Integer tDescencFechdesId;
    @Column(name = "t_descenc_fechaut_id")
    private Integer tDescencFechautId;
    @Column(name = "t_descenc_horac")
    @Temporal(TemporalType.TIME)
    private Date tDescencHorac;
    @Column(name = "t_descenc_horam")
    @Temporal(TemporalType.TIME)
    private Date tDescencHoram;
    @Column(name = "t_descenc_horaut")
    @Temporal(TemporalType.TIME)
    private Date tDescencHoraut;
    
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne(optional = false)
    private CResponsables cRespId;
    @JoinColumn(name = "c_jefesd_id", referencedColumnName = "c_jefesd_id")
    @ManyToOne(optional = false)
    private CJefesDep cJefesdId;
    @JoinColumn(name = "c_edif_id", referencedColumnName = "c_edif_id")
    @ManyToOne(optional = false)
    private CEdificios cEdifId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne(optional = false)
    private CDependencias cDepenId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tDescencId")
    private List<TDescargDeta> tDescargDetaList;

    public TDescargEnca() {
    }

    public TDescargEnca(Integer tDescencId) {
        this.tDescencId = tDescencId;
    }

    public Integer getTDescencId() {
        return tDescencId;
    }

    public void setTDescencId(Integer tDescencId) {
        this.tDescencId = tDescencId;
    }

    public Integer getTDescencCorr() {
        return tDescencCorr;
    }

    public void setTDescencCorr(Integer tDescencCorr) {
        this.tDescencCorr = tDescencCorr;
    }

    public Integer getTDescencAnio() {
        return tDescencAnio;
    }

    public void setTDescencAnio(Integer tDescencAnio) {
        this.tDescencAnio = tDescencAnio;
    }

    public Date getTDescencFechsol() {
        return tDescencFechsol;
    }

    public void setTDescencFechsol(Date tDescencFechsol) {
        this.tDescencFechsol = tDescencFechsol;
    }

    public Integer getTDescencEstado() {
        return tDescencEstado;
    }

    public void setTDescencEstado(Integer tDescencEstado) {
        this.tDescencEstado = tDescencEstado;
    }

    public Integer getTDescencTidoc() {
        return tDescencTidoc;
    }

    public void setTDescencTidoc(Integer tDescencTidoc) {
        this.tDescencTidoc = tDescencTidoc;
    }

    public Boolean getTDescencCopiadoc() {
        return tDescencCopiadoc;
    }

    public void setTDescencCopiadoc(Boolean tDescencCopiadoc) {
        this.tDescencCopiadoc = tDescencCopiadoc;
    }

    public Date getTDescencFechaut() {
        return tDescencFechaut;
    }

    public void setTDescencFechaut(Date tDescencFechaut) {
        this.tDescencFechaut = tDescencFechaut;
    }

    public Integer getTDescencCodaut() {
        return tDescencCodaut;
    }

    public void setTDescencCodaut(Integer tDescencCodaut) {
        this.tDescencCodaut = tDescencCodaut;
    }

    public Date getTDescencFechpro() {
        return tDescencFechpro;
    }

    public void setTDescencFechpro(Date tDescencFechpro) {
        this.tDescencFechpro = tDescencFechpro;
    }

    public Integer getTDescencCodpro() {
        return tDescencCodpro;
    }

    public void setTDescencCodpro(Integer tDescencCodpro) {
        this.tDescencCodpro = tDescencCodpro;
    }

    public Date getTDescencFechres() {
        return tDescencFechres;
    }

    public void setTDescencFechres(Date tDescencFechres) {
        this.tDescencFechres = tDescencFechres;
    }

    public Integer getTDescencCodres() {
        return tDescencCodres;
    }

    public void setTDescencCodres(Integer tDescencCodres) {
        this.tDescencCodres = tDescencCodres;
    }

    public Date getTDescencFechdes() {
        return tDescencFechdes;
    }

    public void setTDescencFechdes(Date tDescencFechdes) {
        this.tDescencFechdes = tDescencFechdes;
    }

    public Integer getTDescencCoddes() {
        return tDescencCoddes;
    }

    public void setTDescencCoddes(Integer tDescencCoddes) {
        this.tDescencCoddes = tDescencCoddes;
    }

    public Integer getTDescencUsec() {
        return tDescencUsec;
    }

    public void setTDescencUsec(Integer tDescencUsec) {
        this.tDescencUsec = tDescencUsec;
    }

    public Date getTDescencFechc() {
        return tDescencFechc;
    }

    public void setTDescencFechc(Date tDescencFechc) {
        this.tDescencFechc = tDescencFechc;
    }

    public Integer getTDescencUsem() {
        return tDescencUsem;
    }

    public void setTDescencUsem(Integer tDescencUsem) {
        this.tDescencUsem = tDescencUsem;
    }

    public Date getTDescencFechm() {
        return tDescencFechm;
    }

    public void setTDescencFechm(Date tDescencFechm) {
        this.tDescencFechm = tDescencFechm;
    }

    public Integer getTDescencFechsolId() {
        return tDescencFechsolId;
    }

    public void setTDescencFechsolId(Integer tDescencFechsolId) {
        this.tDescencFechsolId = tDescencFechsolId;
    }

    public Integer getTDescencFechdesId() {
        return tDescencFechdesId;
    }

    public void setTDescencFechdesId(Integer tDescencFechdesId) {
        this.tDescencFechdesId = tDescencFechdesId;
    }

    public Integer getTDescencFechautId() {
        return tDescencFechautId;
    }

    public void setTDescencFechautId(Integer tDescencFechautId) {
        this.tDescencFechautId = tDescencFechautId;
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

    public List<TDescargDeta> getTDescargDetaList() {
        return tDescargDetaList;
    }

    public void setTDescargDetaList(List<TDescargDeta> tDescargDetaList) {
        this.tDescargDetaList = tDescargDetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tDescencId != null ? tDescencId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDescargEnca)) {
            return false;
        }
        TDescargEnca other = (TDescargEnca) object;
        if ((this.tDescencId == null && other.tDescencId != null) || (this.tDescencId != null && !this.tDescencId.equals(other.tDescencId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TDescargEnca[ tDescencId=" + tDescencId + " ]";
    }

   

    public Date getTDescencHorac() {
        return tDescencHorac;
    }

    public void setTDescencHorac(Date tDescencHorac) {
        this.tDescencHorac = tDescencHorac;
    }

    public Date getTDescencHoram() {
        return tDescencHoram;
    }

    public void setTDescencHoram(Date tDescencHoram) {
        this.tDescencHoram = tDescencHoram;
    }

    public Date getTDescencHoraut() {
        return tDescencHoraut;
    }

    public void setTDescencHoraut(Date tDescencHoraut) {
        this.tDescencHoraut = tDescencHoraut;
    }
    
}
