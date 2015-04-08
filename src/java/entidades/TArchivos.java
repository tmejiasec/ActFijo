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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_archivos")
@NamedQueries({
    @NamedQuery(name = "TArchivos.findAll", query = "SELECT t FROM TArchivos t"),
    @NamedQuery(name = "TArchivos.findByTArchId", query = "SELECT t FROM TArchivos t WHERE t.tArchId = :tArchId"),
    @NamedQuery(name = "TArchivos.findByTArchNombre", query = "SELECT t FROM TArchivos t WHERE t.tArchNombre = :tArchNombre"),
    @NamedQuery(name = "TArchivos.findByTArchDesc", query = "SELECT t FROM TArchivos t WHERE t.tArchDesc = :tArchDesc"),
    @NamedQuery(name = "TArchivos.findByTArchTipref", query = "SELECT t FROM TArchivos t WHERE t.tArchTipref = :tArchTipref"),
    @NamedQuery(name = "TArchivos.findByTArchCodref", query = "SELECT t FROM TArchivos t WHERE t.tArchCodref = :tArchCodref"),
    @NamedQuery(name = "TArchivos.findByTArchTipo", query = "SELECT t FROM TArchivos t WHERE t.tArchTipo = :tArchTipo"),
    @NamedQuery(name = "TArchivos.findByTArchUrl", query = "SELECT t FROM TArchivos t WHERE t.tArchUrl = :tArchUrl")})
public class TArchivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_arch_id")
    private Integer tArchId;
    @Size(max = 75)
    @Column(name = "t_arch_nombre")
    private String tArchNombre;
    @Size(max = 100)
    @Column(name = "t_arch_desc")
    private String tArchDesc;
    @Size(max = 3)
    @Column(name = "t_arch_tipref")
    private String tArchTipref;
    @Size(max = 12)
    @Column(name = "t_arch_codref")
    private String tArchCodref;
    @Column(name = "t_arch_tipo")
    private Character tArchTipo;
    @Size(max = 150)
    @Column(name = "t_arch_url")
    private String tArchUrl;

    public TArchivos() {
    }

    public TArchivos(Integer tArchId) {
        this.tArchId = tArchId;
    }

    public Integer getTArchId() {
        return tArchId;
    }

    public void setTArchId(Integer tArchId) {
        this.tArchId = tArchId;
    }

    public String getTArchNombre() {
        return tArchNombre;
    }

    public void setTArchNombre(String tArchNombre) {
        this.tArchNombre = tArchNombre;
    }

    public String getTArchDesc() {
        return tArchDesc;
    }

    public void setTArchDesc(String tArchDesc) {
        this.tArchDesc = tArchDesc;
    }

    public String getTArchTipref() {
        return tArchTipref;
    }

    public void setTArchTipref(String tArchTipref) {
        this.tArchTipref = tArchTipref;
    }

    public String getTArchCodref() {
        return tArchCodref;
    }

    public void setTArchCodref(String tArchCodref) {
        this.tArchCodref = tArchCodref;
    }

    public Character getTArchTipo() {
        return tArchTipo;
    }

    public void setTArchTipo(Character tArchTipo) {
        this.tArchTipo = tArchTipo;
    }

    public String getTArchUrl() {
        return tArchUrl;
    }

    public void setTArchUrl(String tArchUrl) {
        this.tArchUrl = tArchUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tArchId != null ? tArchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TArchivos)) {
            return false;
        }
        TArchivos other = (TArchivos) object;
        if ((this.tArchId == null && other.tArchId != null) || (this.tArchId != null && !this.tArchId.equals(other.tArchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TArchivos[ tArchId=" + tArchId + " ]";
    }
    
}
