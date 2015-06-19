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
@Table(name = "c_otros_mov")
@NamedQueries({
    @NamedQuery(name = "COtrosMov.findAll", query = "SELECT c FROM COtrosMov c"),
    @NamedQuery(name = "COtrosMov.findByCOtrosmId", query = "SELECT c FROM COtrosMov c WHERE c.cOtrosmId = :cOtrosmId"),
    @NamedQuery(name = "COtrosMov.findByCOtrosmDesc", query = "SELECT c FROM COtrosMov c WHERE c.cOtrosmDesc = :cOtrosmDesc")})
public class COtrosMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_otrosm_id")
    private Integer cOtrosmId;
    @Size(max = 50)
    @Column(name = "c_otrosm_desc")
    private String cOtrosmDesc;
    @OneToMany(mappedBy = "cOtrosmId")
    private List<TCorrOtr> tCorrOtrList;

    public COtrosMov() {
    }

    public COtrosMov(Integer cOtrosmId) {
        this.cOtrosmId = cOtrosmId;
    }

    public Integer getCOtrosmId() {
        return cOtrosmId;
    }

    public void setCOtrosmId(Integer cOtrosmId) {
        this.cOtrosmId = cOtrosmId;
    }

    public String getCOtrosmDesc() {
        return cOtrosmDesc;
    }

    public void setCOtrosmDesc(String cOtrosmDesc) {
        this.cOtrosmDesc = cOtrosmDesc;
    }

    public List<TCorrOtr> getTCorrOtrList() {
        return tCorrOtrList;
    }

    public void setTCorrOtrList(List<TCorrOtr> tCorrOtrList) {
        this.tCorrOtrList = tCorrOtrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOtrosmId != null ? cOtrosmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COtrosMov)) {
            return false;
        }
        COtrosMov other = (COtrosMov) object;
        if ((this.cOtrosmId == null && other.cOtrosmId != null) || (this.cOtrosmId != null && !this.cOtrosmId.equals(other.cOtrosmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.COtrosMov[ cOtrosmId=" + cOtrosmId + " ]";
    }
    
}
