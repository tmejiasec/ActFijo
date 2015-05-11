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
@Table(name = "t_bienes")
@NamedQueries({
    @NamedQuery(name = "TBienes.findAll", query = "SELECT t FROM TBienes t"),
    @NamedQuery(name = "TBienes.findByTBienId", query = "SELECT t FROM TBienes t WHERE t.tBienId = :tBienId"),
    @NamedQuery(name = "TBienes.findByTBienCodigo", query = "SELECT t FROM TBienes t WHERE t.tBienCodigo = :tBienCodigo"),
    @NamedQuery(name = "TBienes.findByTBienDesc", query = "SELECT t FROM TBienes t WHERE t.tBienDesc = :tBienDesc"),
    @NamedQuery(name = "TBienes.findByTBienModelo", query = "SELECT t FROM TBienes t WHERE t.tBienModelo = :tBienModelo"),
    @NamedQuery(name = "TBienes.findByTBienSerie", query = "SELECT t FROM TBienes t WHERE t.tBienSerie = :tBienSerie"),
    @NamedQuery(name = "TBienes.findByTBienTipinv", query = "SELECT t FROM TBienes t WHERE t.tBienTipinv = :tBienTipinv"),
    @NamedQuery(name = "TBienes.findByTBienFechadq", query = "SELECT t FROM TBienes t WHERE t.tBienFechadq = :tBienFechadq"),
    @NamedQuery(name = "TBienes.findByTBienValoradq", query = "SELECT t FROM TBienes t WHERE t.tBienValoradq = :tBienValoradq"),
    @NamedQuery(name = "TBienes.findByTBienFechvgar", query = "SELECT t FROM TBienes t WHERE t.tBienFechvgar = :tBienFechvgar"),
    @NamedQuery(name = "TBienes.findByTBienNumdoc", query = "SELECT t FROM TBienes t WHERE t.tBienNumdoc = :tBienNumdoc"),
    @NamedQuery(name = "TBienes.findByTBienFechregb", query = "SELECT t FROM TBienes t WHERE t.tBienFechregb = :tBienFechregb"),
    @NamedQuery(name = "TBienes.findByTBienPartida", query = "SELECT t FROM TBienes t WHERE t.tBienPartida = :tBienPartida"),
    @NamedQuery(name = "TBienes.findByTBienDepreciable", query = "SELECT t FROM TBienes t WHERE t.tBienDepreciable = :tBienDepreciable"),
    @NamedQuery(name = "TBienes.findByTBienFechinidep", query = "SELECT t FROM TBienes t WHERE t.tBienFechinidep = :tBienFechinidep"),
    @NamedQuery(name = "TBienes.findByTBienUso", query = "SELECT t FROM TBienes t WHERE t.tBienUso = :tBienUso"),
    @NamedQuery(name = "TBienes.findByTBienInglote", query = "SELECT t FROM TBienes t WHERE t.tBienInglote = :tBienInglote AND t.tBienLoteingre = :tBienLoteingre"),
    @NamedQuery(name = "TBienes.findByTBienCodagrup", query = "SELECT t FROM TBienes t WHERE t.tBienCodagrup = :tBienCodagrup"),
    @NamedQuery(name = "TBienes.findByTBienFoto", query = "SELECT t FROM TBienes t WHERE t.tBienFoto = :tBienFoto"),
    @NamedQuery(name = "TBienes.findByTBienDocing", query = "SELECT t FROM TBienes t WHERE t.tBienDocing = :tBienDocing"),
    @NamedQuery(name = "TBienes.findByTBienProceso", query = "SELECT t FROM TBienes t WHERE t.tBienProceso = :tBienProceso"),
    @NamedQuery(name = "TBienes.findByTBienUscrea", query = "SELECT t FROM TBienes t WHERE t.tBienUscrea = :tBienUscrea"),
    @NamedQuery(name = "TBienes.findByTBienFechcrea", query = "SELECT t FROM TBienes t WHERE t.tBienFechcrea = :tBienFechcrea"),
    @NamedQuery(name = "TBienes.findByTBienUsmodif", query = "SELECT t FROM TBienes t WHERE t.tBienUsmodif = :tBienUsmodif"),
    @NamedQuery(name = "TBienes.findByTBienFechmod", query = "SELECT t FROM TBienes t WHERE t.tBienFechmod = :tBienFechmod"),
    @NamedQuery(name = "TBienes.findByTBienFecadId", query = "SELECT t FROM TBienes t WHERE t.tBienFecadId = :tBienFecadId"),
    @NamedQuery(name = "TBienes.findByTBienFvgarId", query = "SELECT t FROM TBienes t WHERE t.tBienFvgarId = :tBienFvgarId"),
    @NamedQuery(name = "TBienes.findByTBienFregId", query = "SELECT t FROM TBienes t WHERE t.tBienFregId = :tBienFregId"),
    @NamedQuery(name = "TBienes.findByResponsable", query = "SELECT t FROM TBienes t WHERE t.cRespId.cRespId = :cRespId"),
    @NamedQuery(name = "TBienes.findByTBienFinidId", query = "SELECT t FROM TBienes t WHERE t.tBienFinidId = :tBienFinidId")})
    public class TBienes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_bien_id")
    private Integer tBienId;
    @Size(max = 12)
    @Column(name = "t_bien_codigo")
    private String tBienCodigo;
    @Size(max = 100)
    @Column(name = "t_bien_desc")
    private String tBienDesc;
    @Size(max = 20)
    @Column(name = "t_bien_modelo")
    private String tBienModelo;
    @Size(max = 20)
    @Column(name = "t_bien_serie")
    private String tBienSerie;
    @Column(name = "t_bien_tipinv")
    private String tBienTipinv;
    @Column(name = "t_bien_fechadq")
    @Temporal(TemporalType.DATE)
    private Date tBienFechadq;
    @Column(name = "t_bien_fechvgar")
    @Temporal(TemporalType.DATE)
    private Date tBienFechvgar;
    @Size(max = 20)
    @Column(name = "t_bien_numdoc")
    private String tBienNumdoc;
    @Column(name = "t_bien_fechregb")
    @Temporal(TemporalType.DATE)
    private Date tBienFechregb;
    @Size(max = 20)
    @Column(name = "t_bien_partida")
    private String tBienPartida;
    @Column(name = "t_bien_depreciable")
    private Boolean tBienDepreciable;
    @Column(name = "t_bien_fechinidep")
    @Temporal(TemporalType.DATE)
    private Date tBienFechinidep;
    @Column(name = "t_bien_uso")
    private Boolean tBienUso;
    @Column(name = "t_bien_inglote")
    private Boolean tBienInglote;
    @Size(max = 15)
    @Column(name = "t_bien_codagrup")
    private String tBienCodagrup;
    @Column(name = "t_bien_foto")
    private Boolean tBienFoto;
    @Column(name = "t_bien_docing")
    private Boolean tBienDocing;
    @Column(name = "t_bien_fechcrea")
    @Temporal(TemporalType.DATE)
    private Date tBienFechcrea;
    @Column(name = "t_bien_fechmod")
    @Temporal(TemporalType.DATE)
    private Date tBienFechmod;

    @Column(name = "t_bien_fecinglote")
    @Temporal(TemporalType.DATE)
    private Date tBienFecinglote;
    @Column(name = "t_bien_horinglote")
    @Temporal(TemporalType.TIME)
    private Date tBienHoringlote;
    @Size(max = 12)
    @Column(name = "t_bien_codinilot")
    private String tBienCodinilot;
    @Size(max = 12)
    @Column(name = "t_bien_codfinlot")
    private String tBienCodfinlot;    
    
    @Column(name = "t_bien_horamod")
    @Temporal(TemporalType.TIME)
    private Date tBienHoramod;
    @Column(name = "t_bien_horacrea")
    @Temporal(TemporalType.TIME)
    private Date tBienHoracrea;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne
    private CDependencias cDepenId;
    @JoinColumn(name = "c_nivel_id", referencedColumnName = "c_nivel_id")
    @ManyToOne
    private CNiveles cNivelId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "t_bien_valoradq")
    private Double tBienValoradq;
    @Column(name = "t_bien_proceso")
    private Integer tBienProceso;
    @Column(name = "t_bien_uscrea")
    private Integer tBienUscrea;
    @Column(name = "t_bien_usmodif")
    private Integer tBienUsmodif;
    @Column(name = "t_bien_cantxlote")
    private Integer tBienCantxlote;
    @Column(name = "t_bien_loteingre")
    private Boolean tBienLoteingre;
     
    @Column(name = "t_bien_fecad_id")
    private Integer tBienFecadId;
    @Column(name = "t_bien_fvgar_id")
    private Integer tBienFvgarId;
    @Column(name = "t_bien_freg_id")
    private Integer tBienFregId;
    @Column(name = "t_bien_finid_id")
    private Integer tBienFinidId;
    @JoinColumn(name = "c_ubic_id", referencedColumnName = "c_ubic_id")
    @ManyToOne
    private CUbic cUbicId;
    @JoinColumn(name = "c_tipd_id", referencedColumnName = "c_tipd_id")
    @ManyToOne
    private CTipDoc cTipdId;
    @JoinColumn(name = "c_tipdesc_id", referencedColumnName = "c_tipdesc_id")
    @ManyToOne
    private CTipDescarg cTipdescId;
    @JoinColumn(name = "c_rubro_id", referencedColumnName = "c_rubro_id")
    @ManyToOne
    private CRubros cRubroId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne
    private CResponsables cRespId;
    @JoinColumn(name = "c_area_id", referencedColumnName = "c_area_id")
    @ManyToOne
    private CAreas cAreaId;
    @JoinColumn(name = "c_condb_id", referencedColumnName = "c_condb_id")
    @ManyToOne
    private CCondBien cCondbId;
    @JoinColumn(name = "c_edif_id", referencedColumnName = "c_edif_id")
    @ManyToOne
    private CEdificios cEdifId;
    @JoinColumn(name = "c_espec_id", referencedColumnName = "c_espec_id")
    @ManyToOne(optional = false)
    private CEspecificos cEspecId;
    @JoinColumn(name = "c_estadb_id", referencedColumnName = "c_estadb_id")
    @ManyToOne
    private CEstadoBien cEstadbId;
    @JoinColumn(name = "c_e_c_estpro_id", referencedColumnName = "c_estpro_id")
    @ManyToOne
    private CEstadoProc cECEstproId;
    @JoinColumn(name = "c_estpro_id", referencedColumnName = "c_estpro_id")
    @ManyToOne
    private CEstadoProc cEstproId;
    @JoinColumn(name = "c_formad_id", referencedColumnName = "c_formad_id")
    @ManyToOne
    private CFormasAdq cFormadId;
    @JoinColumn(name = "c_fuentes_id", referencedColumnName = "c_fuentes_id")
    @ManyToOne(optional = false)
    private CFuentesFin cFuentesId;
    @JoinColumn(name = "c_marca_id", referencedColumnName = "c_marca_id")
    @ManyToOne
    private CMarcasBm cMarcaId;
    @JoinColumn(name = "c_prov_id", referencedColumnName = "c_prov_id")
    @ManyToOne
    private CProveedores cProvId;
    @JoinColumn(name = "c_proy_id", referencedColumnName = "c_proy_id")
    @ManyToOne
    private CProyectos cProyId;

    public TBienes() {
    }

    public TBienes(Integer tBienId) {
        this.tBienId = tBienId;
    }

    public Integer getTBienId() {
        return tBienId;
    }

    public void setTBienId(Integer tBienId) {
        this.tBienId = tBienId;
    }

    public String getTBienCodigo() {
        return tBienCodigo;
    }

    public void setTBienCodigo(String tBienCodigo) {
        this.tBienCodigo = tBienCodigo;
    }

    public String getTBienDesc() {
        return tBienDesc;
    }

    public void setTBienDesc(String tBienDesc) {
        this.tBienDesc = tBienDesc;
    }

    public String getTBienModelo() {
        return tBienModelo;
    }

    public void setTBienModelo(String tBienModelo) {
        this.tBienModelo = tBienModelo;
    }

    public String getTBienSerie() {
        return tBienSerie;
    }

    public void setTBienSerie(String tBienSerie) {
        this.tBienSerie = tBienSerie;
    }

    public String getTBienTipinv() {
        return tBienTipinv;
    }

    public void setTBienTipinv(String tBienTipinv) {
        this.tBienTipinv = tBienTipinv;
    }

    public Date getTBienFechadq() {
        return tBienFechadq;
    }

    public void setTBienFechadq(Date tBienFechadq) {
        this.tBienFechadq = tBienFechadq;
    }

    public Double getTBienValoradq() {
        return tBienValoradq;
    }

    public void setTBienValoradq(Double tBienValoradq) {
        this.tBienValoradq = tBienValoradq;
    }

    public Date getTBienFechvgar() {
        return tBienFechvgar;
    }

    public void setTBienFechvgar(Date tBienFechvgar) {
        this.tBienFechvgar = tBienFechvgar;
    }

    public String getTBienNumdoc() {
        return tBienNumdoc;
    }

    public void setTBienNumdoc(String tBienNumdoc) {
        this.tBienNumdoc = tBienNumdoc;
    }

    public Date getTBienFechregb() {
        return tBienFechregb;
    }

    public void setTBienFechregb(Date tBienFechregb) {
        this.tBienFechregb = tBienFechregb;
    }

    public String getTBienPartida() {
        return tBienPartida;
    }

    public void setTBienPartida(String tBienPartida) {
        this.tBienPartida = tBienPartida;
    }

    public Boolean getTBienDepreciable() {
        return tBienDepreciable;
    }

    public void setTBienDepreciable(Boolean tBienDepreciable) {
        this.tBienDepreciable = tBienDepreciable;
    }

    public Date getTBienFechinidep() {
        return tBienFechinidep;
    }

    public void setTBienFechinidep(Date tBienFechinidep) {
        this.tBienFechinidep = tBienFechinidep;
    }

    public Boolean getTBienUso() {
        return tBienUso;
    }

    public void setTBienUso(Boolean tBienUso) {
        this.tBienUso = tBienUso;
    }

    public Boolean getTBienInglote() {
        return tBienInglote;
    }

    public void setTBienInglote(Boolean tBienInglote) {
        this.tBienInglote = tBienInglote;
    }

    public String getTBienCodagrup() {
        return tBienCodagrup;
    }

    public void setTBienCodagrup(String tBienCodagrup) {
        this.tBienCodagrup = tBienCodagrup;
    }

    public Boolean getTBienFoto() {
        return tBienFoto;
    }

    public void setTBienFoto(Boolean tBienFoto) {
        this.tBienFoto = tBienFoto;
    }

    public Boolean getTBienDocing() {
        return tBienDocing;
    }

    public void setTBienDocing(Boolean tBienDocing) {
        this.tBienDocing = tBienDocing;
    }

    public Integer getTBienProceso() {
        return tBienProceso;
    }

    public void setTBienProceso(Integer tBienProceso) {
        this.tBienProceso = tBienProceso;
    }

    public Integer getTBienUscrea() {
        return tBienUscrea;
    }

    public void setTBienUscrea(Integer tBienUscrea) {
        this.tBienUscrea = tBienUscrea;
    }

    public Date getTBienFechcrea() {
        return tBienFechcrea;
    }

    public void setTBienFechcrea(Date tBienFechcrea) {
        this.tBienFechcrea = tBienFechcrea;
    }

    public Integer getTBienUsmodif() {
        return tBienUsmodif;
    }

    public void setTBienUsmodif(Integer tBienUsmodif) {
        this.tBienUsmodif = tBienUsmodif;
    }

    public Date getTBienFechmod() {
        return tBienFechmod;
    }

    public void setTBienFechmod(Date tBienFechmod) {
        this.tBienFechmod = tBienFechmod;
    }

    public Integer getTBienFecadId() {
        return tBienFecadId;
    }

    public void setTBienFecadId(Integer tBienFecadId) {
        this.tBienFecadId = tBienFecadId;
    }

    public Integer getTBienFvgarId() {
        return tBienFvgarId;
    }

    public void setTBienFvgarId(Integer tBienFvgarId) {
        this.tBienFvgarId = tBienFvgarId;
    }

    public Integer getTBienFregId() {
        return tBienFregId;
    }

    public void setTBienFregId(Integer tBienFregId) {
        this.tBienFregId = tBienFregId;
    }

    public Integer getTBienFinidId() {
        return tBienFinidId;
    }

    public void setTBienFinidId(Integer tBienFinidId) {
        this.tBienFinidId = tBienFinidId;
    }

    public CUbic getCUbicId() {
        return cUbicId;
    }

    public void setCUbicId(CUbic cUbicId) {
        this.cUbicId = cUbicId;
    }

    public CTipDoc getCTipdId() {
        return cTipdId;
    }

    public void setCTipdId(CTipDoc cTipdId) {
        this.cTipdId = cTipdId;
    }

    public CTipDescarg getCTipdescId() {
        return cTipdescId;
    }

    public void setCTipdescId(CTipDescarg cTipdescId) {
        this.cTipdescId = cTipdescId;
    }

    public CRubros getCRubroId() {
        return cRubroId;
    }

    public void setCRubroId(CRubros cRubroId) {
        this.cRubroId = cRubroId;
    }

    public CResponsables getCRespId() {
        return cRespId;
    }

    public void setCRespId(CResponsables cRespId) {
        this.cRespId = cRespId;
    }

    public CAreas getCAreaId() {
        return cAreaId;
    }

    public void setCAreaId(CAreas cAreaId) {
        this.cAreaId = cAreaId;
    }

    public CCondBien getCCondbId() {
        return cCondbId;
    }

    public void setCCondbId(CCondBien cCondbId) {
        this.cCondbId = cCondbId;
    }

    public CEdificios getCEdifId() {
        return cEdifId;
    }

    public void setCEdifId(CEdificios cEdifId) {
        this.cEdifId = cEdifId;
    }

    public CEspecificos getCEspecId() {
        return cEspecId;
    }

    public void setCEspecId(CEspecificos cEspecId) {
        this.cEspecId = cEspecId;
    }

    public CEstadoBien getCEstadbId() {
        return cEstadbId;
    }

    public void setCEstadbId(CEstadoBien cEstadbId) {
        this.cEstadbId = cEstadbId;
    }

    public CEstadoProc getCECEstproId() {
        return cECEstproId;
    }

    public void setCECEstproId(CEstadoProc cECEstproId) {
        this.cECEstproId = cECEstproId;
    }

    public CEstadoProc getCEstproId() {
        return cEstproId;
    }

    public void setCEstproId(CEstadoProc cEstproId) {
        this.cEstproId = cEstproId;
    }

    public CFormasAdq getCFormadId() {
        return cFormadId;
    }

    public void setCFormadId(CFormasAdq cFormadId) {
        this.cFormadId = cFormadId;
    }

    public CFuentesFin getCFuentesId() {
        return cFuentesId;
    }

    public void setCFuentesId(CFuentesFin cFuentesId) {
        this.cFuentesId = cFuentesId;
    }

    public CMarcasBm getCMarcaId() {
        return cMarcaId;
    }

    public void setCMarcaId(CMarcasBm cMarcaId) {
        this.cMarcaId = cMarcaId;
    }

    public CProveedores getCProvId() {
        return cProvId;
    }

    public void setCProvId(CProveedores cProvId) {
        this.cProvId = cProvId;
    }

    public CProyectos getCProyId() {
        return cProyId;
    }

    public void setCProyId(CProyectos cProyId) {
        this.cProyId = cProyId;
    }


    public Integer getTBienCantxlote() {
        return tBienCantxlote;
    }

    public void setTBienCantxlote(Integer tBienCantxlote) {
        this.tBienCantxlote = tBienCantxlote;
    }

    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
    }

    public CNiveles getCNivelId() {
        return cNivelId;
    }

    public void setCNivelId(CNiveles cNivelId) {
        this.cNivelId = cNivelId;
    }

    public Date getTBienHoramod() {
        return tBienHoramod;
    }

    public void setTBienHoramod(Date tBienHoramod) {
        this.tBienHoramod = tBienHoramod;
    }

    public Date getTBienHoracrea() {
        return tBienHoracrea;
    }

    public void setTBienHoracrea(Date tBienHoracrea) {
        this.tBienHoracrea = tBienHoracrea;
    }

    public Date getTBienFecinglote() {
        return tBienFecinglote;
    }

    public void setTBienFecinglote(Date tBienFecinglote) {
        this.tBienFecinglote = tBienFecinglote;
    }

    public Date getTBienHoringlote() {
        return tBienHoringlote;
    }

    public void setTBienHoringlote(Date tBienHoringlote) {
        this.tBienHoringlote = tBienHoringlote;
    }

    public String getTBienCodinilot() {
        return tBienCodinilot;
    }

    public void setTBienCodinilot(String tBienCodinilot) {
        this.tBienCodinilot = tBienCodinilot;
    }

    public String getTBienCodfinlot() {
        return tBienCodfinlot;
    }

    public void setTBienCodfinlot(String tBienCodfinlot) {
        this.tBienCodfinlot = tBienCodfinlot;
    }

    public Boolean getTBienLoteingre() {
        return tBienLoteingre;
    }

    public void setTBienLoteingre(Boolean tBienLoteingre) {
        this.tBienLoteingre = tBienLoteingre;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tBienId != null ? tBienId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBienes)) {
            return false;
        }
        TBienes other = (TBienes) object;
        if ((this.tBienId == null && other.tBienId != null) || (this.tBienId != null && !this.tBienId.equals(other.tBienId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TBienes[ tBienId=" + tBienId + " ]";
    }
    
    
}
