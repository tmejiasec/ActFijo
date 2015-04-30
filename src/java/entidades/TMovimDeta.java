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
@Table(name = "t_movim_deta")
@NamedQueries({
    @NamedQuery(name = "TMovimDeta.findAll", query = "SELECT t FROM TMovimDeta t"),
    @NamedQuery(name = "TMovimDeta.findByTMovdId", query = "SELECT t FROM TMovimDeta t WHERE t.tMovdId = :tMovdId"),
    @NamedQuery(name = "TMovimDeta.findByTMoveId", query = "SELECT t FROM TMovimDeta t WHERE t.tMoveId = :tMoveId"),
    @NamedQuery(name = "TMovimDeta.findByTMovdCodigo", query = "SELECT t FROM TMovimDeta t WHERE t.tMovdCodigo = :tMovdCodigo")})
public class TMovimDeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_movd_id")
    private Integer tMovdId;
    @Size(max = 12)
    @Column(name = "t_movd_codigo")
    private String tMovdCodigo;
    
    @JoinColumn(name = "t_move_id", referencedColumnName = "t_move_id")
    @ManyToOne
    private TMovimEnca tMoveId;
    
    @JoinColumn(name = "t_bien_id", referencedColumnName = "t_bien_id")
    @ManyToOne
    private TBienes tBienId;

    public TMovimDeta() {
    }

    public TMovimDeta(Integer tMovdId) {
        this.tMovdId = tMovdId;
    }

    public Integer getTMovdId() {
        return tMovdId;
    }

    public void setTMovdId(Integer tMovdId) {
        this.tMovdId = tMovdId;
    }

    public String getTMovdCodigo() {
        return tMovdCodigo;
    }

    public void setTMovdCodigo(String tMovdCodigo) {
        this.tMovdCodigo = tMovdCodigo;
    }

    public TMovimEnca getTMoveId() {
        return tMoveId;
    }

    public void setTMoveId(TMovimEnca tMoveId) {
        this.tMoveId = tMoveId;
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
        hash += (tMovdId != null ? tMovdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMovimDeta)) {
            return false;
        }
        TMovimDeta other = (TMovimDeta) object;
        if ((this.tMovdId == null && other.tMovdId != null) || (this.tMovdId != null && !this.tMovdId.equals(other.tMovdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TMovimDeta[ tMovdId=" + tMovdId + " ]";
    }
    
}
