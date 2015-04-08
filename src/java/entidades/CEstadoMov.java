/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_estado_mov")
@NamedQueries({
    @NamedQuery(name = "CEstadoMov.findAll", query = "SELECT c FROM CEstadoMov c"),
    @NamedQuery(name = "CEstadoMov.findByCEstmovId", query = "SELECT c FROM CEstadoMov c WHERE c.cEstmovId = :cEstmovId"),
    @NamedQuery(name = "CEstadoMov.findByCEstmovDesc", query = "SELECT c FROM CEstadoMov c WHERE c.cEstmovDesc = :cEstmovDesc")})
public class CEstadoMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_estmov_id")
    private Integer cEstmovId;
    @Size(max = 20)
    @Column(name = "c_estmov_desc")
    private String cEstmovDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cEstmovId")
    private List<TMovimEnca> tMovimEncaList;

    public CEstadoMov() {
    }

    public CEstadoMov(Integer cEstmovId) {
        this.cEstmovId = cEstmovId;
    }

    public Integer getCEstmovId() {
        return cEstmovId;
    }

    public void setCEstmovId(Integer cEstmovId) {
        this.cEstmovId = cEstmovId;
    }

    public String getCEstmovDesc() {
        return cEstmovDesc;
    }

    public void setCEstmovDesc(String cEstmovDesc) {
        this.cEstmovDesc = cEstmovDesc;
    }

    public List<TMovimEnca> getTMovimEncaList() {
        return tMovimEncaList;
    }

    public void setTMovimEncaList(List<TMovimEnca> tMovimEncaList) {
        this.tMovimEncaList = tMovimEncaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cEstmovId != null ? cEstmovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEstadoMov)) {
            return false;
        }
        CEstadoMov other = (CEstadoMov) object;
        if ((this.cEstmovId == null && other.cEstmovId != null) || (this.cEstmovId != null && !this.cEstmovId.equals(other.cEstmovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CEstadoMov[ cEstmovId=" + cEstmovId + " ]";
    }
    
}
