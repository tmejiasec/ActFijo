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
@Table(name = "t_recep_deta")
@NamedQueries({
    @NamedQuery(name = "TRecepDeta.findAll", query = "SELECT t FROM TRecepDeta t"),
    @NamedQuery(name = "TRecepDeta.findByTRecdId", query = "SELECT t FROM TRecepDeta t WHERE t.tRecdId = :tRecdId"),
    @NamedQuery(name = "TRecepDeta.findByTRecdCodigo", query = "SELECT t FROM TRecepDeta t WHERE t.tRecdCodigo = :tRecdCodigo")})
public class TRecepDeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_recd_id")
    private Integer tRecdId;
    @Size(max = 12)
    @Column(name = "t_recd_codigo")
    private String tRecdCodigo;
    @JoinColumn(name = "t_rece_id", referencedColumnName = "t_rece_id")
    @ManyToOne(optional = false)
    private TRecepEnca tReceId;

    public TRecepDeta() {
    }

    public TRecepDeta(Integer tRecdId) {
        this.tRecdId = tRecdId;
    }

    public Integer getTRecdId() {
        return tRecdId;
    }

    public void setTRecdId(Integer tRecdId) {
        this.tRecdId = tRecdId;
    }

    public String getTRecdCodigo() {
        return tRecdCodigo;
    }

    public void setTRecdCodigo(String tRecdCodigo) {
        this.tRecdCodigo = tRecdCodigo;
    }

    public TRecepEnca getTReceId() {
        return tReceId;
    }

    public void setTReceId(TRecepEnca tReceId) {
        this.tReceId = tReceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tRecdId != null ? tRecdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRecepDeta)) {
            return false;
        }
        TRecepDeta other = (TRecepDeta) object;
        if ((this.tRecdId == null && other.tRecdId != null) || (this.tRecdId != null && !this.tRecdId.equals(other.tRecdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TRecepDeta[ tRecdId=" + tRecdId + " ]";
    }
    
}
