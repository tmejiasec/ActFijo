/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_proveedores")
@NamedQueries({
    @NamedQuery(name = "CProveedores.findAll", query = "SELECT c FROM CProveedores c"),
    @NamedQuery(name = "CProveedores.findByCProvId", query = "SELECT c FROM CProveedores c WHERE c.cProvId = :cProvId"),
    @NamedQuery(name = "CProveedores.findByCProvNumreg", query = "SELECT c FROM CProveedores c WHERE c.cProvNumreg = :cProvNumreg"),
    @NamedQuery(name = "CProveedores.findByCProvNit", query = "SELECT c FROM CProveedores c WHERE c.cProvNit = :cProvNit"),
    @NamedQuery(name = "CProveedores.findByCProvNombre", query = "SELECT c FROM CProveedores c WHERE c.cProvNombre = :cProvNombre"),
    @NamedQuery(name = "CProveedores.findByCProvDirec", query = "SELECT c FROM CProveedores c WHERE c.cProvDirec = :cProvDirec"),
    @NamedQuery(name = "CProveedores.findByCProvContacto", query = "SELECT c FROM CProveedores c WHERE c.cProvContacto = :cProvContacto"),
    @NamedQuery(name = "CProveedores.findByCProvCorreo", query = "SELECT c FROM CProveedores c WHERE c.cProvCorreo = :cProvCorreo"),
    @NamedQuery(name = "CProveedores.findByCProvTelef", query = "SELECT c FROM CProveedores c WHERE c.cProvTelef = :cProvTelef"),
    @NamedQuery(name = "CProveedores.findByCProvFax", query = "SELECT c FROM CProveedores c WHERE c.cProvFax = :cProvFax"),
    @NamedQuery(name = "CProveedores.findByCProvEstado", query = "SELECT c FROM CProveedores c WHERE c.cProvEstado = :cProvEstado")})
public class CProveedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_prov_id")
    private Integer cProvId;
    @Size(max = 12)
    @Column(name = "c_prov_numreg")
    private String cProvNumreg;
    @Size(max = 17)
    @Column(name = "c_prov_nit")
    private String cProvNit;
    @Size(max = 100)
    @Column(name = "c_prov_nombre")
    private String cProvNombre;
    @Size(max = 150)
    @Column(name = "c_prov_direc")
    private String cProvDirec;
    @Size(max = 100)
    @Column(name = "c_prov_contacto")
    private String cProvContacto;
    @Size(max = 75)
    @Column(name = "c_prov_correo")
    private String cProvCorreo;
    @Size(max = 15)
    @Column(name = "c_prov_telef")
    private String cProvTelef;
    @Size(max = 15)
    @Column(name = "c_prov_fax")
    private String cProvFax;
    @Column(name = "c_prov_estado")
    private Character cProvEstado;
    @JoinColumn(name = "c_muni_id", referencedColumnName = "c_muni_id")
    @ManyToOne
    private CMunic cMuniId;
    @JoinColumn(name = "c_depto_id", referencedColumnName = "c_depto_id")
    @ManyToOne
    private CDeptos cDeptoId;
    @OneToMany(mappedBy = "cProvId")
    private List<TBienes> tBienesList;

    public CProveedores() {
    }

    public CProveedores(Integer cProvId) {
        this.cProvId = cProvId;
    }

    public Integer getCProvId() {
        return cProvId;
    }

    public void setCProvId(Integer cProvId) {
        this.cProvId = cProvId;
    }

    public String getCProvNumreg() {
        return cProvNumreg;
    }

    public void setCProvNumreg(String cProvNumreg) {
        this.cProvNumreg = cProvNumreg;
    }

    public String getCProvNit() {
        return cProvNit;
    }

    public void setCProvNit(String cProvNit) {
        this.cProvNit = cProvNit;
    }

    public String getCProvNombre() {
        return cProvNombre;
    }

    public void setCProvNombre(String cProvNombre) {
        this.cProvNombre = cProvNombre;
    }

    public String getCProvDirec() {
        return cProvDirec;
    }

    public void setCProvDirec(String cProvDirec) {
        this.cProvDirec = cProvDirec;
    }

    public String getCProvContacto() {
        return cProvContacto;
    }

    public void setCProvContacto(String cProvContacto) {
        this.cProvContacto = cProvContacto;
    }

    public String getCProvCorreo() {
        return cProvCorreo;
    }

    public void setCProvCorreo(String cProvCorreo) {
        this.cProvCorreo = cProvCorreo;
    }

    public String getCProvTelef() {
        return cProvTelef;
    }

    public void setCProvTelef(String cProvTelef) {
        this.cProvTelef = cProvTelef;
    }

    public String getCProvFax() {
        return cProvFax;
    }

    public void setCProvFax(String cProvFax) {
        this.cProvFax = cProvFax;
    }

    public Character getCProvEstado() {
        return cProvEstado;
    }

    public void setCProvEstado(Character cProvEstado) {
        this.cProvEstado = cProvEstado;
    }

    public CMunic getCMuniId() {
        return cMuniId;
    }

    public void setCMuniId(CMunic cMuniId) {
        this.cMuniId = cMuniId;
    }

    public CDeptos getCDeptoId() {
        return cDeptoId;
    }

    public void setCDeptoId(CDeptos cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProvId != null ? cProvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProveedores)) {
            return false;
        }
        CProveedores other = (CProveedores) object;
        if ((this.cProvId == null && other.cProvId != null) || (this.cProvId != null && !this.cProvId.equals(other.cProvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CProveedores[ cProvId=" + cProvId + " ]";
    }
    
}
