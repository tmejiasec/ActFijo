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
@Table(name = "c_tip_descarg")
@NamedQueries({
    @NamedQuery(name = "CTipDescarg.findAll", query = "SELECT c FROM CTipDescarg c"),
    @NamedQuery(name = "CTipDescarg.findByCTipdescId", query = "SELECT c FROM CTipDescarg c WHERE c.cTipdescId = :cTipdescId"),
    @NamedQuery(name = "CTipDescarg.findByCTipdescDesc", query = "SELECT c FROM CTipDescarg c WHERE c.cTipdescDesc = :cTipdescDesc")})
public class CTipDescarg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_tipdesc_id")
    private Integer cTipdescId;
    @Size(max = 25)
    @Column(name = "c_tipdesc_desc")
    private String cTipdescDesc;
    @OneToMany(mappedBy = "cTipdescId")
    private List<TBienes> tBienesList;

    public CTipDescarg() {
    }

    public CTipDescarg(Integer cTipdescId) {
        this.cTipdescId = cTipdescId;
    }

    public Integer getCTipdescId() {
        return cTipdescId;
    }

    public void setCTipdescId(Integer cTipdescId) {
        this.cTipdescId = cTipdescId;
    }

    public String getCTipdescDesc() {
        return cTipdescDesc;
    }

    public void setCTipdescDesc(String cTipdescDesc) {
        this.cTipdescDesc = cTipdescDesc;
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
        hash += (cTipdescId != null ? cTipdescId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipDescarg)) {
            return false;
        }
        CTipDescarg other = (CTipDescarg) object;
        if ((this.cTipdescId == null && other.cTipdescId != null) || (this.cTipdescId != null && !this.cTipdescId.equals(other.cTipdescId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CTipDescarg[ cTipdescId=" + cTipdescId + " ]";
    }
    
}
