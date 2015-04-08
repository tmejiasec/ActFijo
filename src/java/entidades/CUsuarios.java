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
@Table(name = "c_usuarios")
@NamedQueries({
    @NamedQuery(name = "CUsuarios.findAll", query = "SELECT c FROM CUsuarios c"),
    @NamedQuery(name = "CUsuarios.findByCUserId", query = "SELECT c FROM CUsuarios c WHERE c.cUserId = :cUserId"),
    @NamedQuery(name = "CUsuarios.findByCUserNombre", query = "SELECT c FROM CUsuarios c WHERE c.cUserNombre = :cUserNombre"),
    @NamedQuery(name = "CUsuarios.findByCUserLogin", query = "SELECT c FROM CUsuarios c WHERE c.cUserLogin = :cUserLogin"),
    @NamedQuery(name = "CUsuarios.findByCUserPass", query = "SELECT c FROM CUsuarios c WHERE c.cUserPass = :cUserPass"),
    @NamedQuery(name = "CUsuarios.findByCUserEstado", query = "SELECT c FROM CUsuarios c WHERE c.cUserEstado = :cUserEstado")})
public class CUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_user_id")
    private Integer cUserId;
    @Size(max = 50)
    @Column(name = "c_user_nombre")
    private String cUserNombre;
    @Size(max = 15)
    @Column(name = "c_user_login")
    private String cUserLogin;
    @Size(max = 15)
    @Column(name = "c_user_pass")
    private String cUserPass;
    @Column(name = "c_user_estado")
    private Character cUserEstado;
    @JoinColumn(name = "c_rol_id", referencedColumnName = "c_rol_id")
    @ManyToOne(optional = false)
    private CRoles cRolId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne
    private CDependencias cDepenId;
    
    public CUsuarios() {
    }

    public CUsuarios(Integer cUserId) {
        this.cUserId = cUserId;
    }

    public Integer getCUserId() {
        return cUserId;
    }

    public void setCUserId(Integer cUserId) {
        this.cUserId = cUserId;
    }

    public String getCUserNombre() {
        return cUserNombre;
    }

    public void setCUserNombre(String cUserNombre) {
        this.cUserNombre = cUserNombre;
    }

    public String getCUserLogin() {
        return cUserLogin;
    }

    public void setCUserLogin(String cUserLogin) {
        this.cUserLogin = cUserLogin;
    }

    public String getCUserPass() {
        return cUserPass;
    }

    public void setCUserPass(String cUserPass) {
        this.cUserPass = cUserPass;
    }

    public Character getCUserEstado() {
        return cUserEstado;
    }

    public void setCUserEstado(Character cUserEstado) {
        this.cUserEstado = cUserEstado;
    }

    public CRoles getCRolId() {
        return cRolId;
    }

    public void setCRolId(CRoles cRolId) {
        this.cRolId = cRolId;
    }
    
    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cUserId != null ? cUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CUsuarios)) {
            return false;
        }
        CUsuarios other = (CUsuarios) object;
        if ((this.cUserId == null && other.cUserId != null) || (this.cUserId != null && !this.cUserId.equals(other.cUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CUsuarios[ cUserId=" + cUserId + " ]";
    }
    
}
