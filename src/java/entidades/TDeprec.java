/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "t_deprec")
@NamedQueries({
    @NamedQuery(name = "TDeprec.findAll", query = "SELECT t FROM TDeprec t"),
    @NamedQuery(name = "TDeprec.findByTDepId", query = "SELECT t FROM TDeprec t WHERE t.tDepId = :tDepId"),
    @NamedQuery(name = "TDeprec.findByTDepCodigo", query = "SELECT t FROM TDeprec t WHERE t.tDepCodigo = :tDepCodigo"),
    @NamedQuery(name = "TDeprec.findByTDepFecha", query = "SELECT t FROM TDeprec t WHERE t.tDepFecha = :tDepFecha"),
    @NamedQuery(name = "TDeprec.findByTDepFechaId", query = "SELECT t FROM TDeprec t WHERE t.tDepFechaId = :tDepFechaId"),
    @NamedQuery(name = "TDeprec.findByTDepValorAd", query = "SELECT t FROM TDeprec t WHERE t.tDepValorAd = :tDepValorAd"),
    @NamedQuery(name = "TDeprec.findByTDepFactorAn", query = "SELECT t FROM TDeprec t WHERE t.tDepFactorAn = :tDepFactorAn"),
    @NamedQuery(name = "TDeprec.findByTDepPlazo", query = "SELECT t FROM TDeprec t WHERE t.tDepPlazo = :tDepPlazo"),
    @NamedQuery(name = "TDeprec.findByTDepValorRes", query = "SELECT t FROM TDeprec t WHERE t.tDepValorRes = :tDepValorRes"),
    @NamedQuery(name = "TDeprec.findByTDepValorAdep", query = "SELECT t FROM TDeprec t WHERE t.tDepValorAdep = :tDepValorAdep"),
    @NamedQuery(name = "TDeprec.findByTDepDepanual", query = "SELECT t FROM TDeprec t WHERE t.tDepDepanual = :tDepDepanual"),
    @NamedQuery(name = "TDeprec.findByTDepDepacum", query = "SELECT t FROM TDeprec t WHERE t.tDepDepacum = :tDepDepacum"),
    @NamedQuery(name = "TDeprec.findByTDepValorAc", query = "SELECT t FROM TDeprec t WHERE t.tDepValorAc = :tDepValorAc"),
    @NamedQuery(name = "TDeprec.findByTDepFechCalc", query = "SELECT t FROM TDeprec t WHERE t.tDepFechCalc = :tDepFechCalc"),
    @NamedQuery(name = "TDeprec.findByTDepFechAnt", query = "SELECT t FROM TDeprec t WHERE t.tDepFechAnt = :tDepFechAnt"),
    @NamedQuery(name = "TDeprec.findByTDepFechantId", query = "SELECT t FROM TDeprec t WHERE t.tDepFechantId = :tDepFechantId"),
    @NamedQuery(name = "TDeprec.findByTDepDepreciado", query = "SELECT t FROM TDeprec t WHERE t.tDepDepreciado = :tDepDepreciado"),
    @NamedQuery(name = "TDeprec.findByTDepUsec", query = "SELECT t FROM TDeprec t WHERE t.tDepUsec = :tDepUsec"),
    @NamedQuery(name = "TDeprec.findByTDepFechc", query = "SELECT t FROM TDeprec t WHERE t.tDepFechc = :tDepFechc")})
public class TDeprec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_dep_id")
    private Integer tDepId;
    @Size(max = 12)
    @Column(name = "t_dep_codigo")
    private String tDepCodigo;
    @Column(name = "t_dep_fecha")
    @Temporal(TemporalType.DATE)
    private Date tDepFecha;
    @Column(name = "t_dep_fech_calc")
    @Temporal(TemporalType.DATE)
    private Date tDepFechCalc;
    @Column(name = "t_dep_fech_ant")
    @Temporal(TemporalType.DATE)
    private Date tDepFechAnt;
    @Column(name = "t_dep_depreciado")
    private Character tDepDepreciado;
    @Column(name = "t_dep_fechc")
    @Temporal(TemporalType.DATE)
    private Date tDepFechc;
    @Column(name = "t_dep_fecha_id")
    private Integer tDepFechaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "t_dep_valor_ad")
    private Double tDepValorAd;
    @Column(name = "t_dep_factor_an")
    private Double tDepFactorAn;
    @Column(name = "t_dep_plazo")
    private Integer tDepPlazo;
    @Column(name = "t_dep_valor_res")
    private Double tDepValorRes;
    @Column(name = "t_dep_valor_adep")
    private Double tDepValorAdep;
    @Column(name = "t_dep_depanual")
    private Double tDepDepanual;
    @Column(name = "t_dep_depacum")
    private Double tDepDepacum;
    @Column(name = "t_dep_valor_ac")
    private Double tDepValorAc;
    @Column(name = "t_dep_fechant_id")
    private Integer tDepFechantId;
    @Column(name = "t_dep_usec")
    private Integer tDepUsec;
    @Column(name = "t_dep_horac")
    @Temporal(TemporalType.TIME)
    private Date tDepHorac;

    public TDeprec() {
    }

    public TDeprec(Integer tDepId) {
        this.tDepId = tDepId;
    }

    public Integer getTDepId() {
        return tDepId;
    }

    public void setTDepId(Integer tDepId) {
        this.tDepId = tDepId;
    }

    public String getTDepCodigo() {
        return tDepCodigo;
    }

    public void setTDepCodigo(String tDepCodigo) {
        this.tDepCodigo = tDepCodigo;
    }

    public Date getTDepFecha() {
        return tDepFecha;
    }

    public void setTDepFecha(Date tDepFecha) {
        this.tDepFecha = tDepFecha;
    }

    public Date getTDepFechCalc() {
        return tDepFechCalc;
    }

    public void setTDepFechCalc(Date tDepFechCalc) {
        this.tDepFechCalc = tDepFechCalc;
    }

    public Date getTDepFechAnt() {
        return tDepFechAnt;
    }

    public void setTDepFechAnt(Date tDepFechAnt) {
        this.tDepFechAnt = tDepFechAnt;
    }


    public Character getTDepDepreciado() {
        return tDepDepreciado;
    }

    public void setTDepDepreciado(Character tDepDepreciado) {
        this.tDepDepreciado = tDepDepreciado;
    }

   
    public Date getTDepFechc() {
        return tDepFechc;
    }

    public void setTDepFechc(Date tDepFechc) {
        this.tDepFechc = tDepFechc;
    }

    public Integer getTDepFechaId() {
        return tDepFechaId;
    }

    public void setTDepFechaId(Integer tDepFechaId) {
        this.tDepFechaId = tDepFechaId;
    }

    public Double getTDepValorAd() {
        return tDepValorAd;
    }

    public void setTDepValorAd(Double tDepValorAd) {
        this.tDepValorAd = tDepValorAd;
    }

    public Double getTDepFactorAn() {
        return tDepFactorAn;
    }

    public void setTDepFactorAn(Double tDepFactorAn) {
        this.tDepFactorAn = tDepFactorAn;
    }

    public Integer getTDepPlazo() {
        return tDepPlazo;
    }

    public void setTDepPlazo(Integer tDepPlazo) {
        this.tDepPlazo = tDepPlazo;
    }

    public Double getTDepValorRes() {
        return tDepValorRes;
    }

    public void setTDepValorRes(Double tDepValorRes) {
        this.tDepValorRes = tDepValorRes;
    }

    public Double getTDepValorAdep() {
        return tDepValorAdep;
    }

    public void setTDepValorAdep(Double tDepValorAdep) {
        this.tDepValorAdep = tDepValorAdep;
    }

    public Double getTDepDepanual() {
        return tDepDepanual;
    }

    public void setTDepDepanual(Double tDepDepanual) {
        this.tDepDepanual = tDepDepanual;
    }

    public Double getTDepDepacum() {
        return tDepDepacum;
    }

    public void setTDepDepacum(Double tDepDepacum) {
        this.tDepDepacum = tDepDepacum;
    }

    public Double getTDepValorAc() {
        return tDepValorAc;
    }

    public void setTDepValorAc(Double tDepValorAc) {
        this.tDepValorAc = tDepValorAc;
    }

    public Integer getTDepFechantId() {
        return tDepFechantId;
    }

    public void setTDepFechantId(Integer tDepFechantId) {
        this.tDepFechantId = tDepFechantId;
    }

    public Integer getTDepUsec() {
        return tDepUsec;
    }

    public void setTDepUsec(Integer tDepUsec) {
        this.tDepUsec = tDepUsec;
    }

    public Date getTDepHorac() {
        return tDepHorac;
    }

    public void setTDepHorac(Date tDepHorac) {
        this.tDepHorac = tDepHorac;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tDepId != null ? tDepId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDeprec)) {
            return false;
        }
        TDeprec other = (TDeprec) object;
        if ((this.tDepId == null && other.tDepId != null) || (this.tDepId != null && !this.tDepId.equals(other.tDepId))) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "entidades.TDeprec[ tDepId=" + tDepId + " ]";
    }

    
}
