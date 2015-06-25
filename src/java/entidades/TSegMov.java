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
@Table(name = "t_seg_mov")
@NamedQueries({
    @NamedQuery(name = "TSegMov.findAll", query = "SELECT t FROM TSegMov t"),
    @NamedQuery(name = "TSegMov.findByTSegId", query = "SELECT t FROM TSegMov t WHERE t.tSegId = :tSegId"),
    @NamedQuery(name = "TSegMov.findByTSegObserv", query = "SELECT t FROM TSegMov t WHERE t.tSegObserv = :tSegObserv"),
    @NamedQuery(name = "TSegMov.findByTMoveId", query="SELECT m FROM TSegMov m WHERE m.tMoveId.tMoveId = :tMoveId"),
    @NamedQuery(name = "TSegMov.findByTSegFecha", query = "SELECT t FROM TSegMov t WHERE t.tSegFecha = :tSegFecha"),
    @NamedQuery(name = "TSegMov.findByTSegHora", query = "SELECT t FROM TSegMov t WHERE t.tSegHora = :tSegHora"),
    @NamedQuery(name = "TSegMov.findByCUserId", query = "SELECT t FROM TSegMov t WHERE t.cUserId.cUserId = :cUserId")})
public class TSegMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_seg_id")
    private Integer tSegId;
    @Size(max = 250)
    @Column(name = "t_seg_observ")
    private String tSegObserv;
    @Column(name = "t_seg_fecha")
    @Temporal(TemporalType.DATE)
    private Date tSegFecha;
    @Column(name = "t_seg_hora")
    @Temporal(TemporalType.TIME)
    private Date tSegHora;
    @Column(name = "t_seg_fechp")
    @Temporal(TemporalType.DATE)
    private Date tSegFechp;
    @Column(name = "t_seg_horap")
    @Temporal(TemporalType.TIME)
    private Date tSegHorap;
    @JoinColumn(name = "t_tm_id", referencedColumnName = "t_tm_id")
    @ManyToOne
    private TTiempo tTmId;
    @JoinColumn(name = "t_move_id", referencedColumnName = "t_move_id")
    @ManyToOne
    private TMovimEnca tMoveId;
    @JoinColumn(name = "c_tipm_id", referencedColumnName = "c_tipm_id")
    @ManyToOne
    private CTiposMov cTipmId;
    @JoinColumn(name = "c_estmov_id", referencedColumnName = "c_estmov_id")
    @ManyToOne
    private CEstadoMov cEstmovId;
    @JoinColumn(name = "c_user_id", referencedColumnName = "c_user_id")
    @ManyToOne
    private CUsuarios cUserId;

    public TSegMov() {
    }

    public TSegMov(Integer tSegId) {
        this.tSegId = tSegId;
    }

    public Integer getTSegId() {
        return tSegId;
    }

    public void setTSegId(Integer tSegId) {
        this.tSegId = tSegId;
    }

    public String getTSegObserv() {
        return tSegObserv;
    }

    public void setTSegObserv(String tSegObserv) {
        this.tSegObserv = tSegObserv;
    }

    public Date getTSegFecha() {
        return tSegFecha;
    }

    public void setTSegFecha(Date tSegFecha) {
        this.tSegFecha = tSegFecha;
    }

    public Date getTSegHora() {
        return tSegHora;
    }

    public void setTSegHora(Date tSegHora) {
        this.tSegHora = tSegHora;
    }

    public Date getTSegFechp() {
        return tSegFechp;
    }

    public void setTSegFechp(Date tSegFechp) {
        this.tSegFechp = tSegFechp;
    }

    public Date getTSegHorap() {
        return tSegHorap;
    }

    public void setTSegHorap(Date tSegHorap) {
        this.tSegHorap = tSegHorap;
    }

    public TTiempo getTTmId() {
        return tTmId;
    }

    public void setTTmId(TTiempo tTmId) {
        this.tTmId = tTmId;
    }

    public TMovimEnca getTMoveId() {
        return tMoveId;
    }

    public void setTMoveId(TMovimEnca tMoveId) {
        this.tMoveId = tMoveId;
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

    public void setCEstmovId(CEstadoMov cEstmovId) {
        this.cEstmovId = cEstmovId;
    }

    public CUsuarios getCUserId() {
        return cUserId;
    }

    public void setCUserId(CUsuarios cUserId) {
        this.cUserId = cUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tSegId != null ? tSegId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSegMov)) {
            return false;
        }
        TSegMov other = (TSegMov) object;
        if ((this.tSegId == null && other.tSegId != null) || (this.tSegId != null && !this.tSegId.equals(other.tSegId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TSegMov[ tSegId=" + tSegId + " ]";
    }
    
}
