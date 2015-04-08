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
@Table(name = "c_roles")
@NamedQueries({
    @NamedQuery(name = "CRoles.findAll", query = "SELECT c FROM CRoles c"),
    @NamedQuery(name = "CRoles.findByCRolId", query = "SELECT c FROM CRoles c WHERE c.cRolId = :cRolId"),
    @NamedQuery(name = "CRoles.findByCRolNombre", query = "SELECT c FROM CRoles c WHERE c.cRolNombre = :cRolNombre"),
    @NamedQuery(name = "CRoles.findByCRolDesc", query = "SELECT c FROM CRoles c WHERE c.cRolDesc = :cRolDesc")})
public class CRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_rol_id")
    private Integer cRolId;
    @Size(max = 50)
    @Column(name = "c_rol_nombre")
    private String cRolNombre;
    @Size(max = 75)
    @Column(name = "c_rol_desc")
    private String cRolDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRolId")
    private List<CUsuarios> cUsuariosList;

    public CRoles() {
    }

    public CRoles(Integer cRolId) {
        this.cRolId = cRolId;
    }

    public Integer getCRolId() {
        return cRolId;
    }

    public void setCRolId(Integer cRolId) {
        this.cRolId = cRolId;
    }

    public String getCRolNombre() {
        return cRolNombre;
    }

    public void setCRolNombre(String cRolNombre) {
        this.cRolNombre = cRolNombre;
    }

    public String getCRolDesc() {
        return cRolDesc;
    }

    public void setCRolDesc(String cRolDesc) {
        this.cRolDesc = cRolDesc;
    }

    public List<CUsuarios> getCUsuariosList() {
        return cUsuariosList;
    }

    public void setCUsuariosList(List<CUsuarios> cUsuariosList) {
        this.cUsuariosList = cUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRolId != null ? cRolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRoles)) {
            return false;
        }
        CRoles other = (CRoles) object;
        if ((this.cRolId == null && other.cRolId != null) || (this.cRolId != null && !this.cRolId.equals(other.cRolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CRoles[ cRolId=" + cRolId + " ]";
    }
    
}
