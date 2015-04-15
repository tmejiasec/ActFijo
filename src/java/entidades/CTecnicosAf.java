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
@Table(name = "c_tecnicos_af")
@NamedQueries({
    @NamedQuery(name = "CTecnicosAf.findAll", query = "SELECT c FROM CTecnicosAf c"),
    @NamedQuery(name = "CTecnicosAf.findByCTecafId", query = "SELECT c FROM CTecnicosAf c WHERE c.cTecafId = :cTecafId"),
    @NamedQuery(name = "CTecnicosAf.findByCTecafNombre", query = "SELECT c FROM CTecnicosAf c WHERE c.cTecafNombre = :cTecafNombre"),
    @NamedQuery(name = "CTecnicosAf.findByCTecafCargo", query = "SELECT c FROM CTecnicosAf c WHERE c.cTecafCargo = :cTecafCargo"),
    @NamedQuery(name = "CTecnicosAf.findByCTecafTelefono", query = "SELECT c FROM CTecnicosAf c WHERE c.cTecafTelefono = :cTecafTelefono"),
    @NamedQuery(name = "CTecnicosAf.findByCTecafEstado", query = "SELECT c FROM CTecnicosAf c WHERE c.cTecafEstado = :cTecafEstado")})
public class CTecnicosAf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_tecaf_id")
    private Integer cTecafId;
    @Size(max = 100)
    @Column(name = "c_tecaf_nombre")
    private String cTecafNombre;
    @Size(max = 50)
    @Column(name = "c_tecaf_cargo")
    private String cTecafCargo;
    @Size(max = 20)
    @Column(name = "c_tecaf_telefono")
    private String cTecafTelefono;
    @Column(name = "c_tecaf_estado")
    private Character cTecafEstado;
    @JoinColumn(name = "c_jefesd_id", referencedColumnName = "c_jefesd_id")
    @ManyToOne
    private CJefesDep cJefesdId;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne
    private CDependencias cDepenId;

    public CTecnicosAf() {
    }

    public CTecnicosAf(Integer cTecafId) {
        this.cTecafId = cTecafId;
    }

    public Integer getCTecafId() {
        return cTecafId;
    }

    public void setCTecafId(Integer cTecafId) {
        this.cTecafId = cTecafId;
    }

    public String getCTecafNombre() {
        return cTecafNombre;
    }

    public void setCTecafNombre(String cTecafNombre) {
        this.cTecafNombre = cTecafNombre;
    }

    public String getCTecafCargo() {
        return cTecafCargo;
    }

    public void setCTecafCargo(String cTecafCargo) {
        this.cTecafCargo = cTecafCargo;
    }

    public String getCTecafTelefono() {
        return cTecafTelefono;
    }

    public void setCTecafTelefono(String cTecafTelefono) {
        this.cTecafTelefono = cTecafTelefono;
    }

    public Character getCTecafEstado() {
        return cTecafEstado;
    }

    public void setCTecafEstado(Character cTecafEstado) {
        this.cTecafEstado = cTecafEstado;
    }

    public CJefesDep getCJefesdId() {
        return cJefesdId;
    }

    public void setCJefesdId(CJefesDep cJefesdId) {
        this.cJefesdId = cJefesdId;
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
        hash += (cTecafId != null ? cTecafId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTecnicosAf)) {
            return false;
        }
        CTecnicosAf other = (CTecnicosAf) object;
        if ((this.cTecafId == null && other.cTecafId != null) || (this.cTecafId != null && !this.cTecafId.equals(other.cTecafId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CTecnicosAf[ cTecafId=" + cTecafId + " ]";
    }
    
}
