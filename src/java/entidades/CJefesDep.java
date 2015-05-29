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
@Table(name = "c_jefes_dep")
@NamedQueries({
    @NamedQuery(name = "CJefesDep.findAll", query = "SELECT c FROM CJefesDep c"),
    @NamedQuery(name = "CJefesDep.findByCJefesdId", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdId = :cJefesdId"),
    @NamedQuery(name = "CJefesDep.findByCJefesdNombre", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdNombre = :cJefesdNombre"),
    @NamedQuery(name = "CJefesDep.findByCJefesdProfesion", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdProfesion = :cJefesdProfesion"),
    @NamedQuery(name = "CJefesDep.findByCJefesdCargo", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdCargo = :cJefesdCargo"),
    @NamedQuery(name = "CJefesDep.findByCJefesdCorreo", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdCorreo = :cJefesdCorreo"),
    @NamedQuery(name = "CJefesDep.findByCJefesdTelofi", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdTelofi = :cJefesdTelofi"),
    @NamedQuery(name = "CJefesDep.findByCJefesdAutoriz", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdAutoriz = :cJefesdAutoriz"),
    @NamedQuery(name = "CJefesDep.findByCDepenId", query = "SELECT c FROM CJefesDep c WHERE c.cDepenId.cDepenId = :cDepenId AND c.cJefesdEstado = 'A'"),
    @NamedQuery(name = "CJefesDep.findByCJefesdEstado", query = "SELECT c FROM CJefesDep c WHERE c.cJefesdEstado = :cJefesdEstado")})
public class CJefesDep implements Serializable {
    @OneToMany(mappedBy = "cJefesdId")
    private List<CTecnicosAf> cTecnicosAfList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_jefesd_id")
    private Integer cJefesdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "c_jefesd_nombre")
    private String cJefesdNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "c_jefesd_profesion")
    private String cJefesdProfesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "c_jefesd_cargo")
    private String cJefesdCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "c_jefesd_correo")
    private String cJefesdCorreo;
    @Size(max = 15)
    @Column(name = "c_jefesd_telofi")
    private String cJefesdTelofi;
    @Size(max = 10)
    @Column(name = "c_jefesd_autoriz")
    private String cJefesdAutoriz;
    @Column(name = "c_jefesd_estado")
    private Character cJefesdEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cJefesdId")
    private List<TRobHur> tRobHurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cJefesdId")
    private List<TDescargEnca> tDescargEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cJefesdId")
    private List<TAsigEnca> tAsigEncaList;
    @JoinColumn(name = "c_depen_id", referencedColumnName = "c_depen_id")
    @ManyToOne
    private CDependencias cDepenId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cJefesdId")
    private List<TRecepEnca> tRecepEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cJefesdId")
    private List<TSustit> tSustitList;

    public CJefesDep() {
    }

    public CJefesDep(Integer cJefesdId) {
        this.cJefesdId = cJefesdId;
    }

    public CJefesDep(Integer cJefesdId, String cJefesdNombre, String cJefesdProfesion, String cJefesdCargo, String cJefesdCorreo) {
        this.cJefesdId = cJefesdId;
        this.cJefesdNombre = cJefesdNombre;
        this.cJefesdProfesion = cJefesdProfesion;
        this.cJefesdCargo = cJefesdCargo;
        this.cJefesdCorreo = cJefesdCorreo;
    }

    public Integer getCJefesdId() {
        return cJefesdId;
    }

    public void setCJefesdId(Integer cJefesdId) {
        this.cJefesdId = cJefesdId;
    }

    public String getCJefesdNombre() {
        return cJefesdNombre;
    }

    public void setCJefesdNombre(String cJefesdNombre) {
        this.cJefesdNombre = cJefesdNombre;
    }

    public String getCJefesdProfesion() {
        return cJefesdProfesion;
    }

    public void setCJefesdProfesion(String cJefesdProfesion) {
        this.cJefesdProfesion = cJefesdProfesion;
    }

    public String getCJefesdCargo() {
        return cJefesdCargo;
    }

    public void setCJefesdCargo(String cJefesdCargo) {
        this.cJefesdCargo = cJefesdCargo;
    }

    public String getCJefesdCorreo() {
        return cJefesdCorreo;
    }

    public void setCJefesdCorreo(String cJefesdCorreo) {
        this.cJefesdCorreo = cJefesdCorreo;
    }

    public String getCJefesdTelofi() {
        return cJefesdTelofi;
    }

    public void setCJefesdTelofi(String cJefesdTelofi) {
        this.cJefesdTelofi = cJefesdTelofi;
    }

    public String getCJefesdAutoriz() {
        return cJefesdAutoriz;
    }

    public void setCJefesdAutoriz(String cJefesdAutoriz) {
        this.cJefesdAutoriz = cJefesdAutoriz;
    }

    public Character getCJefesdEstado() {
        return cJefesdEstado;
    }

    public void setCJefesdEstado(Character cJefesdEstado) {
        this.cJefesdEstado = cJefesdEstado;
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

    public CDependencias getCDepenId() {
        return cDepenId;
    }

    public void setCDepenId(CDependencias cDepenId) {
        this.cDepenId = cDepenId;
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
        hash += (cJefesdId != null ? cJefesdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CJefesDep)) {
            return false;
        }
        CJefesDep other = (CJefesDep) object;
        if ((this.cJefesdId == null && other.cJefesdId != null) || (this.cJefesdId != null && !this.cJefesdId.equals(other.cJefesdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CJefesDep[ cJefesdId=" + cJefesdId + " ]";
    }

    public List<CTecnicosAf> getCTecnicosAfList() {
        return cTecnicosAfList;
    }

    public void setCTecnicosAfList(List<CTecnicosAf> cTecnicosAfList) {
        this.cTecnicosAfList = cTecnicosAfList;
    }
    
}
