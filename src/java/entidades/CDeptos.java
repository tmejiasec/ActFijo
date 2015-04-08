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
@Table(name = "c_deptos")
@NamedQueries({
    @NamedQuery(name = "CDeptos.findAll", query = "SELECT c FROM CDeptos c"),
    @NamedQuery(name = "CDeptos.findByCDeptoId", query = "SELECT c FROM CDeptos c WHERE c.cDeptoId = :cDeptoId"),
    @NamedQuery(name = "CDeptos.findByCDeptoDesc", query = "SELECT c FROM CDeptos c WHERE c.cDeptoDesc = :cDeptoDesc")})
public class CDeptos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_depto_id")
    private Integer cDeptoId;
    @Size(max = 15)
    @Column(name = "c_depto_desc")
    private String cDeptoDesc;
    @OneToMany(mappedBy = "cDeptoId")
    private List<CProveedores> cProveedoresList;
    @OneToMany(mappedBy = "cDeptoId")
    private List<CEdificios> cEdificiosList;
    @JoinColumn(name = "c_zona_id", referencedColumnName = "c_zona_id")
    @ManyToOne(optional = false)
    private CZonas cZonaId;
    @OneToMany(mappedBy = "cDeptoId")
    private List<CProyectos> cProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDeptoId")
    private List<CMunic> cMunicList;

    public CDeptos() {
    }

    public CDeptos(Integer cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    public Integer getCDeptoId() {
        return cDeptoId;
    }

    public void setCDeptoId(Integer cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    public String getCDeptoDesc() {
        return cDeptoDesc;
    }

    public void setCDeptoDesc(String cDeptoDesc) {
        this.cDeptoDesc = cDeptoDesc;
    }

    public List<CProveedores> getCProveedoresList() {
        return cProveedoresList;
    }

    public void setCProveedoresList(List<CProveedores> cProveedoresList) {
        this.cProveedoresList = cProveedoresList;
    }

    public List<CEdificios> getCEdificiosList() {
        return cEdificiosList;
    }

    public void setCEdificiosList(List<CEdificios> cEdificiosList) {
        this.cEdificiosList = cEdificiosList;
    }

    public CZonas getCZonaId() {
        return cZonaId;
    }

    public void setCZonaId(CZonas cZonaId) {
        this.cZonaId = cZonaId;
    }

    public List<CProyectos> getCProyectosList() {
        return cProyectosList;
    }

    public void setCProyectosList(List<CProyectos> cProyectosList) {
        this.cProyectosList = cProyectosList;
    }

    public List<CMunic> getCMunicList() {
        return cMunicList;
    }

    public void setCMunicList(List<CMunic> cMunicList) {
        this.cMunicList = cMunicList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDeptoId != null ? cDeptoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDeptos)) {
            return false;
        }
        CDeptos other = (CDeptos) object;
        if ((this.cDeptoId == null && other.cDeptoId != null) || (this.cDeptoId != null && !this.cDeptoId.equals(other.cDeptoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CDeptos[ cDeptoId=" + cDeptoId + " ]";
    }
    
}
