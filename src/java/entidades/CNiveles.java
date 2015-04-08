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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_niveles")
@NamedQueries({
    @NamedQuery(name = "CNiveles.findAll", query = "SELECT c FROM CNiveles c"),
    @NamedQuery(name = "CNiveles.findByCNivelId", query = "SELECT c FROM CNiveles c WHERE c.cNivelId = :cNivelId"),
    @NamedQuery(name = "CNiveles.findByCNivelCodigo", query = "SELECT c FROM CNiveles c WHERE c.cNivelCodigo = :cNivelCodigo"),
    @NamedQuery(name = "CNiveles.findByCNivelDescrip", query = "SELECT c FROM CNiveles c WHERE c.cNivelDescrip = :cNivelDescrip"),
    @NamedQuery(name = "CNiveles.findByCNivelJerar", query = "SELECT c FROM CNiveles c WHERE c.cNivelJerar = :cNivelJerar")})
public class CNiveles implements Serializable {
    @OneToMany(mappedBy = "cNivelId")
    private List<CProyectos> cProyectosList;
    @OneToMany(mappedBy = "cNivelId")
    private List<TBienes> tBienesList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_nivel_id")
    private Integer cNivelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "c_nivel_codigo")
    private String cNivelCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "c_nivel_descrip")
    private String cNivelDescrip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "c_nivel_jerar")
    private short cNivelJerar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cNivelId")
    private List<CDependencias> cDependenciasList;
    @OneToMany(mappedBy = "cNivelId")
    private List<CResponsables> cResponsablesList;

    public CNiveles() {
    }

    public CNiveles(Integer cNivelId) {
        this.cNivelId = cNivelId;
    }

    public CNiveles(Integer cNivelId, String cNivelCodigo, String cNivelDescrip, short cNivelJerar) {
        this.cNivelId = cNivelId;
        this.cNivelCodigo = cNivelCodigo;
        this.cNivelDescrip = cNivelDescrip;
        this.cNivelJerar = cNivelJerar;
    }

    public Integer getCNivelId() {
        return cNivelId;
    }

    public void setCNivelId(Integer cNivelId) {
        this.cNivelId = cNivelId;
    }

    public String getCNivelCodigo() {
        return cNivelCodigo;
    }

    public void setCNivelCodigo(String cNivelCodigo) {
        this.cNivelCodigo = cNivelCodigo;
    }

    public String getCNivelDescrip() {
        return cNivelDescrip;
    }

    public void setCNivelDescrip(String cNivelDescrip) {
        this.cNivelDescrip = cNivelDescrip;
    }

    public short getCNivelJerar() {
        return cNivelJerar;
    }

    public void setCNivelJerar(short cNivelJerar) {
        this.cNivelJerar = cNivelJerar;
    }

    public List<CDependencias> getCDependenciasList() {
        return cDependenciasList;
    }

    public void setCDependenciasList(List<CDependencias> cDependenciasList) {
        this.cDependenciasList = cDependenciasList;
    }

    public List<CResponsables> getCResponsablesList() {
        return cResponsablesList;
    }

    public void setCResponsablesList(List<CResponsables> cResponsablesList) {
        this.cResponsablesList = cResponsablesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cNivelId != null ? cNivelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CNiveles)) {
            return false;
        }
        CNiveles other = (CNiveles) object;
        if ((this.cNivelId == null && other.cNivelId != null) || (this.cNivelId != null && !this.cNivelId.equals(other.cNivelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CNiveles[ cNivelId=" + cNivelId + " ]";
    }

    public List<CProyectos> getCProyectosList() {
        return cProyectosList;
    }

    public void setCProyectosList(List<CProyectos> cProyectosList) {
        this.cProyectosList = cProyectosList;
    }

    public List<TBienes> getTBienesList() {
        return tBienesList;
    }

    public void setTBienesList(List<TBienes> tBienesList) {
        this.tBienesList = tBienesList;
    }
    
}
