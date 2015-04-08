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
@Table(name = "c_tip_doc")
@NamedQueries({
    @NamedQuery(name = "CTipDoc.findAll", query = "SELECT c FROM CTipDoc c"),
    @NamedQuery(name = "CTipDoc.findByCTipdId", query = "SELECT c FROM CTipDoc c WHERE c.cTipdId = :cTipdId"),
    @NamedQuery(name = "CTipDoc.findByCTipdDesc", query = "SELECT c FROM CTipDoc c WHERE c.cTipdDesc = :cTipdDesc")})
public class CTipDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_tipd_id")
    private Integer cTipdId;
    @Size(max = 25)
    @Column(name = "c_tipd_desc")
    private String cTipdDesc;
    @OneToMany(mappedBy = "cTipdId")
    private List<TBienes> tBienesList;

    public CTipDoc() {
    }

    public CTipDoc(Integer cTipdId) {
        this.cTipdId = cTipdId;
    }

    public Integer getCTipdId() {
        return cTipdId;
    }

    public void setCTipdId(Integer cTipdId) {
        this.cTipdId = cTipdId;
    }

    public String getCTipdDesc() {
        return cTipdDesc;
    }

    public void setCTipdDesc(String cTipdDesc) {
        this.cTipdDesc = cTipdDesc;
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
        hash += (cTipdId != null ? cTipdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTipDoc)) {
            return false;
        }
        CTipDoc other = (CTipDoc) object;
        if ((this.cTipdId == null && other.cTipdId != null) || (this.cTipdId != null && !this.cTipdId.equals(other.cTipdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CTipDoc[ cTipdId=" + cTipdId + " ]";
    }
    
}
