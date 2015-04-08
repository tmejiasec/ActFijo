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
    @NamedQuery(name = "TDescargEnca.findByTDescencFechautId", query = "SELECT t FROM TDescargEnca t WHERE t.tDescencFechautId = :tDescencFechautId")})
public class TDescargEnca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_descenc_id")
    private Integer tDescencId;
    @Column(name = "t_descenc_corr")
    private Short tDescencCorr;
    @Column(name = "t_descenc_anio")
    private Short tDescencAnio;
    @Column(name = "t_descenc_fechsol")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechsol;
    @Column(name = "t_descenc_estado")
    private Short tDescencEstado;
    @Column(name = "t_descenc_tidoc")
    private Short tDescencTidoc;
    @Column(name = "t_descenc_copiadoc")
    private Boolean tDescencCopiadoc;
    @Column(name = "t_descenc_fechaut")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechaut;
    @Column(name = "t_descenc_codaut")
    private Short tDescencCodaut;
    @Column(name = "t_descenc_fechpro")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechpro;
    @Column(name = "t_descenc_codpro")
    private Short tDescencCodpro;
    @Column(name = "t_descenc_fechres")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechres;
    @Column(name = "t_descenc_codres")
    private Short tDescencCodres;
    @Column(name = "t_descenc_fechdes")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechdes;
    @Column(name = "t_descenc_coddes")
    private Short tDescencCoddes;
    @Column(name = "t_descenc_usec")
    private Short tDescencUsec;
    @Column(name = "t_descenc_fechc")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechc;
    @Column(name = "t_descenc_usem")
    private Short tDescencUsem;
    @Column(name = "t_descenc_fechm")
    @Temporal(TemporalType.DATE)
    private Date tDescencFechm;
    @Column(name = "t_descenc_fechsol_id")
    private Short tDescencFechsolId;
    @Column(name = "t_descenc_fechdes_id")
    private Short tDescencFechdesId;
    @Column(name = "t_descenc_fechaut_id")
    private Short tDescencFechautId;
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

    public Short getTDescencCorr() {
        return tDescencCorr;
    }

    public void setTDescencCorr(Short tDescencCorr) {
        this.tDescencCorr = tDescencCorr;
    }

    public Short getTDescencAnio() {
        return tDescencAnio;
    }

    public void setTDescencAnio(Short tDescencAnio) {
        this.tDescencAnio = tDescencAnio;
    }

    public Date getTDescencFechsol() {
        return tDescencFechsol;
    }

    public void setTDescencFechsol(Date tDescencFechsol) {
        this.tDescencFechsol = tDescencFechsol;
    }

    public Short getTDescencEstado() {
        return tDescencEstado;
    }

    public void setTDescencEstado(Short tDescencEstado) {
        this.tDescencEstado = tDescencEstado;
    }

    public Short getTDescencTidoc() {
        return tDescencTidoc;
    }

    public void setTDescencTidoc(Short tDescencTidoc) {
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

    public Short getTDescencCodaut() {
        return tDescencCodaut;
    }

    public void setTDescencCodaut(Short tDescencCodaut) {
        this.tDescencCodaut = tDescencCodaut;
    }

    public Date getTDescencFechpro() {
        return tDescencFechpro;
    }

    public void setTDescencFechpro(Date tDescencFechpro) {
        this.tDescencFechpro = tDescencFechpro;
    }

    public Short getTDescencCodpro() {
        return tDescencCodpro;
    }

    public void setTDescencCodpro(Short tDescencCodpro) {
        this.tDescencCodpro = tDescencCodpro;
    }

    public Date getTDescencFechres() {
        return tDescencFechres;
    }

    public void setTDescencFechres(Date tDescencFechres) {
        this.tDescencFechres = tDescencFechres;
    }

    public Short getTDescencCodres() {
        return tDescencCodres;
    }

    public void setTDescencCodres(Short tDescencCodres) {
        this.tDescencCodres = tDescencCodres;
    }

    public Date getTDescencFechdes() {
        return tDescencFechdes;
    }

    public void setTDescencFechdes(Date tDescencFechdes) {
        this.tDescencFechdes = tDescencFechdes;
    }

    public Short getTDescencCoddes() {
        return tDescencCoddes;
    }

    public void setTDescencCoddes(Short tDescencCoddes) {
        this.tDescencCoddes = tDescencCoddes;
    }

    public Short getTDescencUsec() {
        return tDescencUsec;
    }

    public void setTDescencUsec(Short tDescencUsec) {
        this.tDescencUsec = tDescencUsec;
    }

    public Date getTDescencFechc() {
        return tDescencFechc;
    }

    public void setTDescencFechc(Date tDescencFechc) {
        this.tDescencFechc = tDescencFechc;
    }

    public Short getTDescencUsem() {
        return tDescencUsem;
    }

    public void setTDescencUsem(Short tDescencUsem) {
        this.tDescencUsem = tDescencUsem;
    }

    public Date getTDescencFechm() {
        return tDescencFechm;
    }

    public void setTDescencFechm(Date tDescencFechm) {
        this.tDescencFechm = tDescencFechm;
    }

    public Short getTDescencFechsolId() {
        return tDescencFechsolId;
    }

    public void setTDescencFechsolId(Short tDescencFechsolId) {
        this.tDescencFechsolId = tDescencFechsolId;
    }

    public Short getTDescencFechdesId() {
        return tDescencFechdesId;
    }

    public void setTDescencFechdesId(Short tDescencFechdesId) {
        this.tDescencFechdesId = tDescencFechdesId;
    }

    public Short getTDescencFechautId() {
        return tDescencFechautId;
    }

    public void setTDescencFechautId(Short tDescencFechautId) {
        this.tDescencFechautId = tDescencFechautId;
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
    
}
