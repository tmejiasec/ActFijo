/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_descarg_deta")
@NamedQueries({
    @NamedQuery(name = "TDescargDeta.findAll", query = "SELECT t FROM TDescargDeta t"),
    @NamedQuery(name = "TDescargDeta.findByTDescdetId", query = "SELECT t FROM TDescargDeta t WHERE t.tDescdetId = :tDescdetId"),
    @NamedQuery(name = "TDescargDeta.findByTDescdetCodigo", query = "SELECT t FROM TDescargDeta t WHERE t.tDescdetCodigo = :tDescdetCodigo"),
    @NamedQuery(name = "TDescargDeta.findByTDescdetDestino", query = "SELECT t FROM TDescargDeta t WHERE t.tDescdetDestino = :tDescdetDestino")})
public class TDescargDeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_descdet_id")
    private Integer tDescdetId;
    @Size(max = 12)
    @Column(name = "t_descdet_codigo")
    private String tDescdetCodigo;
    @Column(name = "t_descdet_destino")
    private Short tDescdetDestino;
    @JoinColumn(name = "t_descenc_id", referencedColumnName = "t_descenc_id")
    @ManyToOne(optional = false)
    private TDescargEnca tDescencId;
    @JoinColumn(name = "c_ubic_id", referencedColumnName = "c_ubic_id")
    @ManyToOne(optional = false)
    private CUbic cUbicId;
    @JoinColumn(name = "c_resp_id", referencedColumnName = "c_resp_id")
    @ManyToOne(optional = false)
    private CResponsables cRespId;
    @JoinColumn(name = "c_area_id", referencedColumnName = "c_area_id")
    @ManyToOne(optional = false)
    private CAreas cAreaId;

    public TDescargDeta() {
    }

    public TDescargDeta(Integer tDescdetId) {
        this.tDescdetId = tDescdetId;
    }

    public Integer getTDescdetId() {
        return tDescdetId;
    }

    public void setTDescdetId(Integer tDescdetId) {
        this.tDescdetId = tDescdetId;
    }

    public String getTDescdetCodigo() {
        return tDescdetCodigo;
    }

    public void setTDescdetCodigo(String tDescdetCodigo) {
        this.tDescdetCodigo = tDescdetCodigo;
    }

    public Short getTDescdetDestino() {
        return tDescdetDestino;
    }

    public void setTDescdetDestino(Short tDescdetDestino) {
        this.tDescdetDestino = tDescdetDestino;
    }

    public TDescargEnca getTDescencId() {
        return tDescencId;
    }

    public void setTDescencId(TDescargEnca tDescencId) {
        this.tDescencId = tDescencId;
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

    public CAreas getCAreaId() {
        return cAreaId;
    }

    public void setCAreaId(CAreas cAreaId) {
        this.cAreaId = cAreaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tDescdetId != null ? tDescdetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDescargDeta)) {
            return false;
        }
        TDescargDeta other = (TDescargDeta) object;
        if ((this.tDescdetId == null && other.tDescdetId != null) || (this.tDescdetId != null && !this.tDescdetId.equals(other.tDescdetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TDescargDeta[ tDescdetId=" + tDescdetId + " ]";
    }
    
}
