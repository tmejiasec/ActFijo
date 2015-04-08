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
@Table(name = "t_repar")
@NamedQueries({
    @NamedQuery(name = "TRepar.findAll", query = "SELECT t FROM TRepar t"),
    @NamedQuery(name = "TRepar.findByTReparId", query = "SELECT t FROM TRepar t WHERE t.tReparId = :tReparId"),
    @NamedQuery(name = "TRepar.findByTReparTaller", query = "SELECT t FROM TRepar t WHERE t.tReparTaller = :tReparTaller"),
    @NamedQuery(name = "TRepar.findByTReparDirec", query = "SELECT t FROM TRepar t WHERE t.tReparDirec = :tReparDirec"),
    @NamedQuery(name = "TRepar.findByTReparContacto", query = "SELECT t FROM TRepar t WHERE t.tReparContacto = :tReparContacto"),
    @NamedQuery(name = "TRepar.findByTReparTelef", query = "SELECT t FROM TRepar t WHERE t.tReparTelef = :tReparTelef"),
    @NamedQuery(name = "TRepar.findByTReparPret", query = "SELECT t FROM TRepar t WHERE t.tReparPret = :tReparPret"),
    @NamedQuery(name = "TRepar.findByTReparPretCargo", query = "SELECT t FROM TRepar t WHERE t.tReparPretCargo = :tReparPretCargo")})
public class TRepar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_repar_id")
    private Integer tReparId;
    @Size(max = 250)
    @Column(name = "t_repar_taller")
    private String tReparTaller;
    @Size(max = 250)
    @Column(name = "t_repar_direc")
    private String tReparDirec;
    @Size(max = 150)
    @Column(name = "t_repar_contacto")
    private String tReparContacto;
    @Size(max = 20)
    @Column(name = "t_repar_telef")
    private String tReparTelef;
    @Size(max = 100)
    @Column(name = "t_repar_pret")
    private String tReparPret;
    @Size(max = 100)
    @Column(name = "t_repar_pret_cargo")
    private String tReparPretCargo;
    @OneToMany(mappedBy = "tReparId")
    private List<TMovimEnca> tMovimEncaList;
    @JoinColumn(name = "t_move_id", referencedColumnName = "t_move_id")
    @ManyToOne
    private TMovimEnca tMoveId;

    public TRepar() {
    }

    public TRepar(Integer tReparId) {
        this.tReparId = tReparId;
    }

    public Integer getTReparId() {
        return tReparId;
    }

    public void setTReparId(Integer tReparId) {
        this.tReparId = tReparId;
    }

    public String getTReparTaller() {
        return tReparTaller;
    }

    public void setTReparTaller(String tReparTaller) {
        this.tReparTaller = tReparTaller;
    }

    public String getTReparDirec() {
        return tReparDirec;
    }

    public void setTReparDirec(String tReparDirec) {
        this.tReparDirec = tReparDirec;
    }

    public String getTReparContacto() {
        return tReparContacto;
    }

    public void setTReparContacto(String tReparContacto) {
        this.tReparContacto = tReparContacto;
    }

    public String getTReparTelef() {
        return tReparTelef;
    }

    public void setTReparTelef(String tReparTelef) {
        this.tReparTelef = tReparTelef;
    }

    public String getTReparPret() {
        return tReparPret;
    }

    public void setTReparPret(String tReparPret) {
        this.tReparPret = tReparPret;
    }

    public String getTReparPretCargo() {
        return tReparPretCargo;
    }

    public void setTReparPretCargo(String tReparPretCargo) {
        this.tReparPretCargo = tReparPretCargo;
    }

    public List<TMovimEnca> getTMovimEncaList() {
        return tMovimEncaList;
    }

    public void setTMovimEncaList(List<TMovimEnca> tMovimEncaList) {
        this.tMovimEncaList = tMovimEncaList;
    }

    public TMovimEnca getTMoveId() {
        return tMoveId;
    }

    public void setTMoveId(TMovimEnca tMoveId) {
        this.tMoveId = tMoveId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tReparId != null ? tReparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TRepar)) {
            return false;
        }
        TRepar other = (TRepar) object;
        if ((this.tReparId == null && other.tReparId != null) || (this.tReparId != null && !this.tReparId.equals(other.tReparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TRepar[ tReparId=" + tReparId + " ]";
    }
    
}
