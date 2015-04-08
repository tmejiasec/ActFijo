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
@Table(name = "t_prest")
@NamedQueries({
    @NamedQuery(name = "TPrest.findAll", query = "SELECT t FROM TPrest t"),
    @NamedQuery(name = "TPrest.findByTPrestId", query = "SELECT t FROM TPrest t WHERE t.tPrestId = :tPrestId"),
    @NamedQuery(name = "TPrest.findByTPrestInst", query = "SELECT t FROM TPrest t WHERE t.tPrestInst = :tPrestInst"),
    @NamedQuery(name = "TPrest.findByTPrestSolic", query = "SELECT t FROM TPrest t WHERE t.tPrestSolic = :tPrestSolic"),
    @NamedQuery(name = "TPrest.findByTPrestCargo", query = "SELECT t FROM TPrest t WHERE t.tPrestCargo = :tPrestCargo"),
    @NamedQuery(name = "TPrest.findByTPrestTelef", query = "SELECT t FROM TPrest t WHERE t.tPrestTelef = :tPrestTelef")})
public class TPrest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_prest_id")
    private Integer tPrestId;
    @Size(max = 250)
    @Column(name = "t_prest_inst")
    private String tPrestInst;
    @Size(max = 200)
    @Column(name = "t_prest_solic")
    private String tPrestSolic;
    @Size(max = 30)
    @Column(name = "t_prest_cargo")
    private String tPrestCargo;
    @Size(max = 20)
    @Column(name = "t_prest_telef")
    private String tPrestTelef;
    @OneToMany(mappedBy = "tPrestId")
    private List<TMovimEnca> tMovimEncaList;
    @JoinColumn(name = "t_move_id", referencedColumnName = "t_move_id")
    @ManyToOne
    private TMovimEnca tMoveId;

    public TPrest() {
    }

    public TPrest(Integer tPrestId) {
        this.tPrestId = tPrestId;
    }

    public Integer getTPrestId() {
        return tPrestId;
    }

    public void setTPrestId(Integer tPrestId) {
        this.tPrestId = tPrestId;
    }

    public String getTPrestInst() {
        return tPrestInst;
    }

    public void setTPrestInst(String tPrestInst) {
        this.tPrestInst = tPrestInst;
    }

    public String getTPrestSolic() {
        return tPrestSolic;
    }

    public void setTPrestSolic(String tPrestSolic) {
        this.tPrestSolic = tPrestSolic;
    }

    public String getTPrestCargo() {
        return tPrestCargo;
    }

    public void setTPrestCargo(String tPrestCargo) {
        this.tPrestCargo = tPrestCargo;
    }

    public String getTPrestTelef() {
        return tPrestTelef;
    }

    public void setTPrestTelef(String tPrestTelef) {
        this.tPrestTelef = tPrestTelef;
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
        hash += (tPrestId != null ? tPrestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPrest)) {
            return false;
        }
        TPrest other = (TPrest) object;
        if ((this.tPrestId == null && other.tPrestId != null) || (this.tPrestId != null && !this.tPrestId.equals(other.tPrestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TPrest[ tPrestId=" + tPrestId + " ]";
    }
    
}
