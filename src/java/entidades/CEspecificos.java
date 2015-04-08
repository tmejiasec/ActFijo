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
@Table(name = "c_especificos")
@NamedQueries({
    @NamedQuery(name = "CEspecificos.findAll", query = "SELECT c FROM CEspecificos c"),
    @NamedQuery(name = "CEspecificos.findByCEspecId", query = "SELECT c FROM CEspecificos c WHERE c.cEspecId = :cEspecId"),
    @NamedQuery(name = "CEspecificos.findByCEspecCodigo", query = "SELECT c FROM CEspecificos c WHERE c.cEspecCodigo = :cEspecCodigo"),
    @NamedQuery(name = "CEspecificos.findByCRubroId", query="SELECT m FROM CEspecificos m WHERE m.cRubroId.cRubroId = :cRubroId"),
    @NamedQuery(name = "CEspecificos.findByCEspecDesc", query = "SELECT c FROM CEspecificos c WHERE c.cEspecDesc = :cEspecDesc")})
public class CEspecificos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_espec_id")
    private Integer cEspecId;
    @Size(max = 4)
    @Column(name = "c_espec_codigo")
    private String cEspecCodigo;
    @Size(max = 100)
    @Column(name = "c_espec_desc")
    private String cEspecDesc;
    @Column(name="c_espec_corr")
    private Integer cEspecCorr;

    @JoinColumn(name = "c_rubro_id", referencedColumnName = "c_rubro_id")
    @ManyToOne(optional = false)
    private CRubros cRubroId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cEspecId")
    private List<TBienes> tBienesList;

    public CEspecificos() {
    }

    public CEspecificos(Integer cEspecId) {
        this.cEspecId = cEspecId;
    }

    public Integer getCEspecId() {
        return cEspecId;
    }

    public void setCEspecId(Integer cEspecId) {
        this.cEspecId = cEspecId;
    }

    public String getCEspecCodigo() {
        return cEspecCodigo;
    }

    public void setCEspecCodigo(String cEspecCodigo) {
        this.cEspecCodigo = cEspecCodigo;
    }

    public String getCEspecDesc() {
        return cEspecDesc;
    }

    public void setCEspecDesc(String cEspecDesc) {
        this.cEspecDesc = cEspecDesc;
    }

    public Integer getCEspecCorr() {
        return cEspecCorr;
    }

    public void setCEspecCorr(Integer cEspecCorr) {
        this.cEspecCorr = cEspecCorr;
    }

    
    public CRubros getCRubroId() {
        return cRubroId;
    }

    public void setCRubroId(CRubros cRubroId) {
        this.cRubroId = cRubroId;
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
        hash += (cEspecId != null ? cEspecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CEspecificos)) {
            return false;
        }
        CEspecificos other = (CEspecificos) object;
        if ((this.cEspecId == null && other.cEspecId != null) || (this.cEspecId != null && !this.cEspecId.equals(other.cEspecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CEspecificos[ cEspecId=" + cEspecId + " ]";
    }
    
}
