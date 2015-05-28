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
@Table(name = "t_movim_enca")
@NamedQueries({
    @NamedQuery(name = "TMovimEnca.findAll", query = "SELECT t FROM TMovimEnca t"),
    @NamedQuery(name = "TMovimEnca.findByTMoveId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveId = :tMoveId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveTipt", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveTipt = :tMoveTipt"),
    @NamedQuery(name = "TMovimEnca.findByTMoveCorr", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveCorr = :tMoveCorr AND t.tMoveAnio = :tMoveAnio"),
    @NamedQuery(name = "TMovimEnca.findByTMoveAnio", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveAnio = :tMoveAnio"),
    @NamedQuery(name = "TMovimEnca.findByTMoveDeps", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveDeps = :tMoveDeps"),
    @NamedQuery(name = "TMovimEnca.findByTMovePers", query = "SELECT t FROM TMovimEnca t WHERE t.tMovePers = :tMovePers"),
    @NamedQuery(name = "TMovimEnca.findByTMoveDepe", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveDepe = :tMoveDepe"),
    @NamedQuery(name = "TMovimEnca.findByTMovePere", query = "SELECT t FROM TMovimEnca t WHERE t.tMovePere = :tMovePere"),
    @NamedQuery(name = "TMovimEnca.findByTMoveDocp", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveDocp = :tMoveDocp"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecsal", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecsal = :tMoveFecsal"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecret", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecret = :tMoveFecret"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecretr", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecretr = :tMoveFecretr"),
    @NamedQuery(name = "TMovimEnca.findByTMoveDiag", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveDiag = :tMoveDiag"),
    @NamedQuery(name = "TMovimEnca.findByTMoveDocd", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveDocd = :tMoveDocd"),
    @NamedQuery(name = "TMovimEnca.findByTMoveObser", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveObser = :tMoveObser"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFechc", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFechc = :tMoveFechc"),
    @NamedQuery(name = "TMovimEnca.findByTMoveUsec", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveUsec = :tMoveUsec"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFechm", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFechm = :tMoveFechm"),
    @NamedQuery(name = "TMovimEnca.findByTMoveUsem", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveUsem = :tMoveUsem"),
    @NamedQuery(name = "TMovimEnca.findByTMoveJefaut", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveJefaut = :tMoveJefaut"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFechaut", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFechaut = :tMoveFechaut"),
    @NamedQuery(name = "TMovimEnca.findByTMoveConfirec", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveConfirec = :tMoveConfirec"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFechcr", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFechcr = :tMoveFechcr"),
    @NamedQuery(name = "TMovimEnca.findByTMoveConfaf", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveConfaf = :tMoveConfaf"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFechcaf", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFechcaf = :tMoveFechcaf"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecsId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecsId = :tMoveFecsId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecrId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecrId = :tMoveFecrId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFeciId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFeciId = :tMoveFeciId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecaId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecaId = :tMoveFecaId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFeccId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFeccId = :tMoveFeccId"),
    @NamedQuery(name = "TMovimEnca.findByTMoveFecafId", query = "SELECT t FROM TMovimEnca t WHERE t.tMoveFecafId = :tMoveFecafId")})
public class TMovimEnca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_move_id")
    private Integer tMoveId;
    @Column(name = "t_move_tipt")
    private String tMoveTipt;
    @Column(name = "t_move_corr")
    private Integer tMoveCorr;
    @Column(name = "t_move_anio")
    private Integer tMoveAnio;
    @Column(name = "t_move_nivs")
    private Integer tMoveNivs;
    @Column(name = "t_move_deps")
    private Integer tMoveDeps;
    @Column(name = "t_move_pers")
    private Integer tMovePers;
    @Column(name = "t_move_nive")
    private Integer tMoveNive;
    @Column(name = "t_move_depe")
    private Integer tMoveDepe;
    @Column(name = "t_move_pere")
    private Integer tMovePere;
    @Column(name = "t_move_docp")
    private Boolean tMoveDocp;
    @Column(name = "t_move_fecsal")
    @Temporal(TemporalType.DATE)
    private Date tMoveFecsal;
    @Column(name = "t_move_fecret")
    @Temporal(TemporalType.DATE)
    private Date tMoveFecret;
    @Column(name = "t_move_fecretr")
    @Temporal(TemporalType.DATE)
    private Date tMoveFecretr;
    @Column(name = "t_move_diag")
    private String tMoveDiag;
    @Column(name = "t_move_docd")
    private Boolean tMoveDocd;
    @Size(max = 2147483647)
    @Column(name = "t_move_obser")
    private String tMoveObser;
    @Column(name = "t_move_fechc")
    @Temporal(TemporalType.DATE)
    private Date tMoveFechc;
    @Column(name = "t_move_usec")
    private Integer tMoveUsec;
    @Column(name = "t_move_fechm")
    @Temporal(TemporalType.DATE)
    private Date tMoveFechm;
    @Column(name = "t_move_usem")
    private Integer tMoveUsem;
    @Column(name = "t_move_jefaut")
    private Integer tMoveJefaut;
    @Column(name = "t_move_fechaut")
    @Temporal(TemporalType.DATE)
    private Date tMoveFechaut;
    @Column(name = "t_move_confirec")
    private Integer tMoveConfirec;
    @Column(name = "t_move_fechcr")
    @Temporal(TemporalType.DATE)
    private Date tMoveFechcr;
    @Column(name = "t_move_confaf")
    private Integer tMoveConfaf;
    @Column(name = "t_move_fechcaf")
    @Temporal(TemporalType.DATE)
    private Date tMoveFechcaf;
    @Column(name = "t_move_fecs_id")
    private Integer tMoveFecsId;
    @Column(name = "t_move_fecr_id")
    private Integer tMoveFecrId;
    @Column(name = "t_move_feci_id")
    private Integer tMoveFeciId;
    @Column(name = "t_move_feca_id")
    private Integer tMoveFecaId;
    @Column(name = "t_move_fecc_id")
    private Integer tMoveFeccId;
    @Column(name = "t_move_fecaf_id")
    private Integer tMoveFecafId;
    @Column(name = "t_move_horac")
    @Temporal(TemporalType.TIME)
    private Date tMoveHorac;
    @Column(name = "t_move_horam")
    @Temporal(TemporalType.TIME)
    private Date tMoveHoram;
    @JoinColumn(name = "t_repar_id", referencedColumnName = "t_repar_id")
    @ManyToOne
    private TRepar tReparId;
    @JoinColumn(name = "t_prest_id", referencedColumnName = "t_prest_id")
    @ManyToOne
    private TPrest tPrestId;
    @JoinColumn(name = "c_tipm_id", referencedColumnName = "c_tipm_id")
    @ManyToOne(optional = false)
    private CTiposMov cTipmId;
    @JoinColumn(name = "c_estmov_id", referencedColumnName = "c_estmov_id")
    @ManyToOne(optional = false)
    private CEstadoMov cEstmovId;
    @OneToMany(mappedBy = "tMoveId")
    private List<TMovimDeta> tMovimDetaList;
    @OneToMany(mappedBy = "tMoveId")
    private List<TRepar> tReparList;
    @OneToMany(mappedBy = "tMoveId")
    private List<TPrest> tPrestList;

    public TMovimEnca() {
    }

    public TMovimEnca(Integer tMoveId) {
        this.tMoveId = tMoveId;
    }

    public Integer getTMoveId() {
        return tMoveId;
    }

    public void setTMoveId(Integer tMoveId) {
        this.tMoveId = tMoveId;
    }

    public String getTMoveTipt() {
        return tMoveTipt;
    }

    public void setTMoveTipt(String tMoveTipt) {
        this.tMoveTipt = tMoveTipt;
    }

    public Integer getTMoveCorr() {
        return tMoveCorr;
    }

    public void setTMoveCorr(Integer tMoveCorr) {
        this.tMoveCorr = tMoveCorr;
    }

    public Integer getTMoveAnio() {
        return tMoveAnio;
    }

    public void setTMoveAnio(Integer tMoveAnio) {
        this.tMoveAnio = tMoveAnio;
    }

    public Integer getTMoveDeps() {
        return tMoveDeps;
    }

    public void setTMoveDeps(Integer tMoveDeps) {
        this.tMoveDeps = tMoveDeps;
    }

    public Integer getTMovePers() {
        return tMovePers;
    }

    public void setTMovePers(Integer tMovePers) {
        this.tMovePers = tMovePers;
    }

    public Integer getTMoveDepe() {
        return tMoveDepe;
    }

    public void setTMoveDepe(Integer tMoveDepe) {
        this.tMoveDepe = tMoveDepe;
    }

    public Integer getTMovePere() {
        return tMovePere;
    }

    public void setTMovePere(Integer tMovePere) {
        this.tMovePere = tMovePere;
    }

    public Integer getTMoveNivs() {
        return tMoveNivs;
    }

    public void setTMoveNivs(Integer tMoveNivs) {
        this.tMoveNivs = tMoveNivs;
    }

    public Integer getTMoveNive() {
        return tMoveNive;
    }

    public void setTMoveNive(Integer tMoveNive) {
        this.tMoveNive = tMoveNive;
    }

    public Boolean getTMoveDocp() {
        return tMoveDocp;
    }

    public void setTMoveDocp(Boolean tMoveDocp) {
        this.tMoveDocp = tMoveDocp;
    }

    public Date getTMoveFecsal() {
        return tMoveFecsal;
    }

    public void setTMoveFecsal(Date tMoveFecsal) {
        this.tMoveFecsal = tMoveFecsal;
    }

    public Date getTMoveFecret() {
        return tMoveFecret;
    }

    public void setTMoveFecret(Date tMoveFecret) {
        this.tMoveFecret = tMoveFecret;
    }

    public Date getTMoveFecretr() {
        return tMoveFecretr;
    }

    public void setTMoveFecretr(Date tMoveFecretr) {
        this.tMoveFecretr = tMoveFecretr;
    }

    public String getTMoveDiag() {
        return tMoveDiag;
    }

    public void setTMoveDiag(String tMoveDiag) {
        this.tMoveDiag = tMoveDiag;
    }

    public Boolean getTMoveDocd() {
        return tMoveDocd;
    }

    public void setTMoveDocd(Boolean tMoveDocd) {
        this.tMoveDocd = tMoveDocd;
    }

    public String getTMoveObser() {
        return tMoveObser;
    }

    public void setTMoveObser(String tMoveObser) {
        this.tMoveObser = tMoveObser;
    }

    public Date getTMoveFechc() {
        return tMoveFechc;
    }

    public void setTMoveFechc(Date tMoveFechc) {
        this.tMoveFechc = tMoveFechc;
    }

    public Integer getTMoveUsec() {
        return tMoveUsec;
    }

    public void setTMoveUsec(Integer tMoveUsec) {
        this.tMoveUsec = tMoveUsec;
    }

    public Date getTMoveFechm() {
        return tMoveFechm;
    }

    public void setTMoveFechm(Date tMoveFechm) {
        this.tMoveFechm = tMoveFechm;
    }

    public Integer getTMoveUsem() {
        return tMoveUsem;
    }

    public void setTMoveUsem(Integer tMoveUsem) {
        this.tMoveUsem = tMoveUsem;
    }

    public Integer getTMoveJefaut() {
        return tMoveJefaut;
    }

    public void setTMoveJefaut(Integer tMoveJefaut) {
        this.tMoveJefaut = tMoveJefaut;
    }

    public Date getTMoveFechaut() {
        return tMoveFechaut;
    }

    public void setTMoveFechaut(Date tMoveFechaut) {
        this.tMoveFechaut = tMoveFechaut;
    }

    public Integer getTMoveConfirec() {
        return tMoveConfirec;
    }

    public void setTMoveConfirec(Integer tMoveConfirec) {
        this.tMoveConfirec = tMoveConfirec;
    }

    public Date getTMoveFechcr() {
        return tMoveFechcr;
    }

    public void setTMoveFechcr(Date tMoveFechcr) {
        this.tMoveFechcr = tMoveFechcr;
    }

    public Integer getTMoveConfaf() {
        return tMoveConfaf;
    }

    public void setTMoveConfaf(Integer tMoveConfaf) {
        this.tMoveConfaf = tMoveConfaf;
    }

    public Date getTMoveFechcaf() {
        return tMoveFechcaf;
    }

    public void setTMoveFechcaf(Date tMoveFechcaf) {
        this.tMoveFechcaf = tMoveFechcaf;
    }

    public Integer getTMoveFecsId() {
        return tMoveFecsId;
    }

    public void setTMoveFecsId(Integer tMoveFecsId) {
        this.tMoveFecsId = tMoveFecsId;
    }

    public Integer getTMoveFecrId() {
        return tMoveFecrId;
    }

    public void setTMoveFecrId(Integer tMoveFecrId) {
        this.tMoveFecrId = tMoveFecrId;
    }

    public Integer getTMoveFeciId() {
        return tMoveFeciId;
    }

    public void setTMoveFeciId(Integer tMoveFeciId) {
        this.tMoveFeciId = tMoveFeciId;
    }

    public Integer getTMoveFecaId() {
        return tMoveFecaId;
    }

    public void setTMoveFecaId(Integer tMoveFecaId) {
        this.tMoveFecaId = tMoveFecaId;
    }

    public Integer getTMoveFeccId() {
        return tMoveFeccId;
    }

    public void setTMoveFeccId(Integer tMoveFeccId) {
        this.tMoveFeccId = tMoveFeccId;
    }

    public Integer getTMoveFecafId() {
        return tMoveFecafId;
    }

    public void setTMoveFecafId(Integer tMoveFecafId) {
        this.tMoveFecafId = tMoveFecafId;
    }

    public TRepar getTReparId() {
        return tReparId;
    }

    public void setTReparId(TRepar tReparId) {
        this.tReparId = tReparId;
    }

    public TPrest getTPrestId() {
        return tPrestId;
    }

    public void setTPrestId(TPrest tPrestId) {
        this.tPrestId = tPrestId;
    }

    public CTiposMov getCTipmId() {
        return cTipmId;
    }

    public void setCTipmId(CTiposMov cTipmId) {
        this.cTipmId = cTipmId;
    }

    public CEstadoMov getCEstmovId() {
        return cEstmovId;
    }

    public Date getTMoveHorac() {
        return tMoveHorac;
    }

    public void setTMoveHorac(Date tMoveHorac) {
        this.tMoveHorac = tMoveHorac;
    }

    public Date getTMoveHoram() {
        return tMoveHoram;
    }

    public void setTMoveHoram(Date tMoveHoram) {
        this.tMoveHoram = tMoveHoram;
    }

    
    public void setCEstmovId(CEstadoMov cEstmovId) {
        this.cEstmovId = cEstmovId;
    }

    public List<TMovimDeta> getTMovimDetaList() {
        return tMovimDetaList;
    }

    public void setTMovimDetaList(List<TMovimDeta> tMovimDetaList) {
        this.tMovimDetaList = tMovimDetaList;
    }

    public List<TRepar> getTReparList() {
        return tReparList;
    }

    public void setTReparList(List<TRepar> tReparList) {
        this.tReparList = tReparList;
    }

    public List<TPrest> getTPrestList() {
        return tPrestList;
    }

    public void setTPrestList(List<TPrest> tPrestList) {
        this.tPrestList = tPrestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tMoveId != null ? tMoveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMovimEnca)) {
            return false;
        }
        TMovimEnca other = (TMovimEnca) object;
        if ((this.tMoveId == null && other.tMoveId != null) || (this.tMoveId != null && !this.tMoveId.equals(other.tMoveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TMovimEnca[ tMoveId=" + tMoveId + " ]";
    }
    
}
