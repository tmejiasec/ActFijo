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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "c_dependencias")
@NamedQueries({
    @NamedQuery(name = "CDependencias.findAll", query = "SELECT c FROM CDependencias c"),
    @NamedQuery(name = "CDependencias.findByCDepenId", query = "SELECT c FROM CDependencias c WHERE c.cDepenId = :cDepenId"),
    @NamedQuery(name = "CDependencias.findByCDepenCodigo", query = "SELECT c FROM CDependencias c WHERE c.cDepenCodigo = :cDepenCodigo"),
    @NamedQuery(name = "CDependencias.findByCDepenDesc", query = "SELECT c FROM CDependencias c WHERE c.cDepenDesc = :cDepenDesc"),
    @NamedQuery(name = "CDependencias.findByCNivelId", query="SELECT m FROM CDependencias m WHERE m.cNivelId.cNivelId = :cNivelId"),
    @NamedQuery(name = "CDependencias.findByCDepenJerar", query = "SELECT c FROM CDependencias c WHERE c.cDepenJerar = :cDepenJerar")})
public class CDependencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_depen_id")
    private Integer cDepenId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "c_depen_codigo")
    private String cDepenCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "c_depen_desc")
    private String cDepenDesc;
    @Size(max = 12)
    @Column(name = "c_depen_jerar")
    private String cDepenJerar;
    @OneToMany(mappedBy = "cDepenId")
    private List<CTecnicosAf> cTecnicosAfList;
    @OneToMany(mappedBy = "cDepenId")
    private List<CProyectos> cProyectosList;
    @OneToMany(mappedBy = "cDepenId")
    private List<TBienes> tBienesList;

    @JoinColumn(name = "c_nivel_id", referencedColumnName = "c_nivel_id")
    @ManyToOne(optional = false)
    private CNiveles cNivelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<TRobHur> tRobHurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<TDescargEnca> tDescargEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<TAsigEnca> tAsigEncaList;
    @OneToMany(mappedBy = "cDepenId")
    private List<CJefesDep> cJefesDepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<CResponsables> cResponsablesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<TRecepEnca> tRecepEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cDepenId")
    private List<TSustit> tSustitList;

    public CDependencias() {
    }

    public CDependencias(Integer cDepenId) {
        this.cDepenId = cDepenId;
    }

    public CDependencias(Integer cDepenId, String cDepenCodigo, String cDepenDesc) {
        this.cDepenId = cDepenId;
        this.cDepenCodigo = cDepenCodigo;
        this.cDepenDesc = cDepenDesc;
    }

    public Integer getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(Integer cDepenId) {
        this.cDepenId = cDepenId;
    }

    public String getCDepenCodigo() {
        return cDepenCodigo;
    }

    public void setCDepenCodigo(String cDepenCodigo) {
        this.cDepenCodigo = cDepenCodigo;
    }

    public String getCDepenDesc() {
        return cDepenDesc;
    }

    public void setCDepenDesc(String cDepenDesc) {
        this.cDepenDesc = cDepenDesc;
    }

    public CNiveles getCNivelId() {
        return cNivelId;
    }

    public void setCNivelId(CNiveles cNivelId) {
        this.cNivelId = cNivelId;
    }

    public List<TRobHur> getTRobHurList() {
        return tRobHurList;
    }

    public void setTRobHurList(List<TRobHur> tRobHurList) {
        this.tRobHurList = tRobHurList;
    }

    public List<TDescargEnca> getTDescargEncaList() {
        return tDescargEncaList;
    }

    public void setTDescargEncaList(List<TDescargEnca> tDescargEncaList) {
        this.tDescargEncaList = tDescargEncaList;
    }

    public List<TAsigEnca> getTAsigEncaList() {
        return tAsigEncaList;
    }

    public void setTAsigEncaList(List<TAsigEnca> tAsigEncaList) {
        this.tAsigEncaList = tAsigEncaList;
    }

    public List<CJefesDep> getCJefesDepList() {
        return cJefesDepList;
    }

    public void setCJefesDepList(List<CJefesDep> cJefesDepList) {
        this.cJefesDepList = cJefesDepList;
    }

    public List<CResponsables> getCResponsablesList() {
        return cResponsablesList;
    }

    public void setCResponsablesList(List<CResponsables> cResponsablesList) {
        this.cResponsablesList = cResponsablesList;
    }

    public List<TRecepEnca> getTRecepEncaList() {
        return tRecepEncaList;
    }

    public void setTRecepEncaList(List<TRecepEnca> tRecepEncaList) {
        this.tRecepEncaList = tRecepEncaList;
    }

    public List<TSustit> getTSustitList() {
        return tSustitList;
    }

    public void setTSustitList(List<TSustit> tSustitList) {
        this.tSustitList = tSustitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDepenId != null ? cDepenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDependencias)) {
            return false;
        }
        CDependencias other = (CDependencias) object;
        if ((this.cDepenId == null && other.cDepenId != null) || (this.cDepenId != null && !this.cDepenId.equals(other.cDepenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CDependencias[ cDepenId=" + cDepenId + " ]";
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

    public List<CTecnicosAf> getCTecnicosAfList() {
        return cTecnicosAfList;
    }

    public void setCTecnicosAfList(List<CTecnicosAf> cTecnicosAfList) {
        this.cTecnicosAfList = cTecnicosAfList;
    }

    public String getCDepenJerar() {
        return cDepenJerar;
    }

    public void setCDepenJerar(String cDepenJerar) {
        this.cDepenJerar = cDepenJerar;
    }
    
}
