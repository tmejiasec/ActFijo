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
@Table(name = "c_rubros")
@NamedQueries({
    @NamedQuery(name = "CRubros.findAll", query = "SELECT c FROM CRubros c"),
    @NamedQuery(name = "CRubros.findByCRubroId", query = "SELECT c FROM CRubros c WHERE c.cRubroId = :cRubroId"),
    @NamedQuery(name = "CRubros.findByCRubroCodigo", query = "SELECT c FROM CRubros c WHERE c.cRubroCodigo = :cRubroCodigo"),
    @NamedQuery(name = "CRubros.findByCRubroDesc", query = "SELECT c FROM CRubros c WHERE c.cRubroDesc = :cRubroDesc")})
public class CRubros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_rubro_id")
    private Integer cRubroId;
    @Size(max = 2)
    @Column(name = "c_rubro_codigo")
    private String cRubroCodigo;
    @Size(max = 100)
    @Column(name = "c_rubro_desc")
    private String cRubroDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cRubroId")
    private List<CEspecificos> cEspecificosList;
    @OneToMany(mappedBy = "cRubroId")
    private List<TBienes> tBienesList;

    public CRubros() {
    }

    public CRubros(Integer cRubroId) {
        this.cRubroId = cRubroId;
    }

    public Integer getCRubroId() {
        return cRubroId;
    }

    public void setCRubroId(Integer cRubroId) {
        this.cRubroId = cRubroId;
    }

    public String getCRubroCodigo() {
        return cRubroCodigo;
    }

    public void setCRubroCodigo(String cRubroCodigo) {
        this.cRubroCodigo = cRubroCodigo;
    }

    public String getCRubroDesc() {
        return cRubroDesc;
    }

    public void setCRubroDesc(String cRubroDesc) {
        this.cRubroDesc = cRubroDesc;
    }

    public List<CEspecificos> getCEspecificosList() {
        return cEspecificosList;
    }

    public void setCEspecificosList(List<CEspecificos> cEspecificosList) {
        this.cEspecificosList = cEspecificosList;
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
        hash += (cRubroId != null ? cRubroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRubros)) {
            return false;
        }
        CRubros other = (CRubros) object;
        if ((this.cRubroId == null && other.cRubroId != null) || (this.cRubroId != null && !this.cRubroId.equals(other.cRubroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CRubros[ cRubroId=" + cRubroId + " ]";
    }
    
}
