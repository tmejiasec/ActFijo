/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "c_munic")
@NamedQueries({
    @NamedQuery(name = "CMunic.findAll", query = "SELECT c FROM CMunic c"),
    @NamedQuery(name = "CMunic.findByCMuniId", query = "SELECT c FROM CMunic c WHERE c.cMuniId = :cMuniId"),
    @NamedQuery(name = "CMunic.findByCMuniDesc", query = "SELECT c FROM CMunic c WHERE c.cMuniDesc = :cMuniDesc"),
    @NamedQuery(name = "CMunic.findByCMuniCateg", query = "SELECT c FROM CMunic c WHERE c.cMuniCateg = :cMuniCateg"),
    @NamedQuery(name = "CMunic.findByCMuniCarret", query = "SELECT c FROM CMunic c WHERE c.cMuniCarret = :cMuniCarret"),
    @NamedQuery(name = "CMunic.findByCDeptoId", query="SELECT m FROM CMunic m WHERE m.cDeptoId.cDeptoId = :cDeptoId"),
    @NamedQuery(name = "CMunic.findByCMuniKm", query = "SELECT c FROM CMunic c WHERE c.cMuniKm = :cMuniKm")})
public class CMunic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_muni_id")
    private Integer cMuniId;
    @Size(max = 100)
    @Column(name = "c_muni_desc")
    private String cMuniDesc;
    @Size(max = 20)
    @Column(name = "c_muni_categ")
    private String cMuniCateg;
    @Size(max = 30)
    @Column(name = "c_muni_carret")
    private String cMuniCarret;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "c_muni_km")
    private BigDecimal cMuniKm;
    @OneToMany(mappedBy = "cMuniId")
    private List<CProveedores> cProveedoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cMuniId")
    private List<CEdificios> cEdificiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cMuniId")
    private List<CProyectos> cProyectosList;
    @JoinColumn(name = "c_depto_id", referencedColumnName = "c_depto_id")
    @ManyToOne(optional = false)
    private CDeptos cDeptoId;

    public CMunic() {
    }

    public CMunic(Integer cMuniId) {
        this.cMuniId = cMuniId;
    }

    public Integer getCMuniId() {
        return cMuniId;
    }

    public void setCMuniId(Integer cMuniId) {
        this.cMuniId = cMuniId;
    }

    public String getCMuniDesc() {
        return cMuniDesc;
    }

    public void setCMuniDesc(String cMuniDesc) {
        this.cMuniDesc = cMuniDesc;
    }

    public String getCMuniCateg() {
        return cMuniCateg;
    }

    public void setCMuniCateg(String cMuniCateg) {
        this.cMuniCateg = cMuniCateg;
    }

    public String getCMuniCarret() {
        return cMuniCarret;
    }

    public void setCMuniCarret(String cMuniCarret) {
        this.cMuniCarret = cMuniCarret;
    }

    public BigDecimal getCMuniKm() {
        return cMuniKm;
    }

    public void setCMuniKm(BigDecimal cMuniKm) {
        this.cMuniKm = cMuniKm;
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

    public List<CProyectos> getCProyectosList() {
        return cProyectosList;
    }

    public void setCProyectosList(List<CProyectos> cProyectosList) {
        this.cProyectosList = cProyectosList;
    }

    public CDeptos getCDeptoId() {
        return cDeptoId;
    }

    public void setCDeptoId(CDeptos cDeptoId) {
        this.cDeptoId = cDeptoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cMuniId != null ? cMuniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CMunic)) {
            return false;
        }
        CMunic other = (CMunic) object;
        if ((this.cMuniId == null && other.cMuniId != null) || (this.cMuniId != null && !this.cMuniId.equals(other.cMuniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CMunic[ cMuniId=" + cMuniId + " ]";
    }
    
}
