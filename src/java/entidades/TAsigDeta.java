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
@Table(name = "t_asig_deta")
@NamedQueries({
    @NamedQuery(name = "TAsigDeta.findAll", query = "SELECT t FROM TAsigDeta t"),
    @NamedQuery(name = "TAsigDeta.findByTAsigdId", query = "SELECT t FROM TAsigDeta t WHERE t.tAsigdId = :tAsigdId"),
    @NamedQuery(name = "TAsigDeta.findByTAsigdCodigo", query = "SELECT t FROM TAsigDeta t WHERE t.tAsigdCodigo = :tAsigdCodigo")})
public class TAsigDeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_asigd_id")
    private Integer tAsigdId;
    @Size(max = 12)
    @Column(name = "t_asigd_codigo")
    private String tAsigdCodigo;
    @JoinColumn(name = "t_asige_id", referencedColumnName = "t_asige_id")
    @ManyToOne(optional = false)
    private TAsigEnca tAsigeId;

    public TAsigDeta() {
    }

    public TAsigDeta(Integer tAsigdId) {
        this.tAsigdId = tAsigdId;
    }

    public Integer getTAsigdId() {
        return tAsigdId;
    }

    public void setTAsigdId(Integer tAsigdId) {
        this.tAsigdId = tAsigdId;
    }

    public String getTAsigdCodigo() {
        return tAsigdCodigo;
    }

    public void setTAsigdCodigo(String tAsigdCodigo) {
        this.tAsigdCodigo = tAsigdCodigo;
    }

    public TAsigEnca getTAsigeId() {
        return tAsigeId;
    }

    public void setTAsigeId(TAsigEnca tAsigeId) {
        this.tAsigeId = tAsigeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tAsigdId != null ? tAsigdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAsigDeta)) {
            return false;
        }
        TAsigDeta other = (TAsigDeta) object;
        if ((this.tAsigdId == null && other.tAsigdId != null) || (this.tAsigdId != null && !this.tAsigdId.equals(other.tAsigdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TAsigDeta[ tAsigdId=" + tAsigdId + " ]";
    }
    
}
