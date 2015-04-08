/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Teo de Renderos
 */
@Entity
@Table(name = "t_tiempo")
@NamedQueries({
    @NamedQuery(name = "TTiempo.findAll", query = "SELECT t FROM TTiempo t"),
    @NamedQuery(name = "TTiempo.findByTTmId", query = "SELECT t FROM TTiempo t WHERE t.tTmId = :tTmId"),
    @NamedQuery(name = "TTiempo.findByTTmFecha", query = "SELECT t FROM TTiempo t WHERE t.tTmFecha = :tTmFecha"),
    @NamedQuery(name = "TTiempo.findByTTmAnio", query = "SELECT t FROM TTiempo t WHERE t.tTmAnio = :tTmAnio"),
    @NamedQuery(name = "TTiempo.findByTTmMes", query = "SELECT t FROM TTiempo t WHERE t.tTmMes = :tTmMes"),
    @NamedQuery(name = "TTiempo.findByTTmDia", query = "SELECT t FROM TTiempo t WHERE t.tTmDia = :tTmDia"),
    @NamedQuery(name = "TTiempo.findByTTmSemana", query = "SELECT t FROM TTiempo t WHERE t.tTmSemana = :tTmSemana"),
    @NamedQuery(name = "TTiempo.findByTTmTrimestre", query = "SELECT t FROM TTiempo t WHERE t.tTmTrimestre = :tTmTrimestre"),
    @NamedQuery(name = "TTiempo.findByTTmCuatrimestre", query = "SELECT t FROM TTiempo t WHERE t.tTmCuatrimestre = :tTmCuatrimestre"),
    @NamedQuery(name = "TTiempo.findByTTmSemestre", query = "SELECT t FROM TTiempo t WHERE t.tTmSemestre = :tTmSemestre"),
    @NamedQuery(name = "TTiempo.findByTTmNomes", query = "SELECT t FROM TTiempo t WHERE t.tTmNomes = :tTmNomes"),
    @NamedQuery(name = "TTiempo.findByTTmNodia", query = "SELECT t FROM TTiempo t WHERE t.tTmNodia = :tTmNodia"),
    @NamedQuery(name = "TTiempo.findByTTmNotrim", query = "SELECT t FROM TTiempo t WHERE t.tTmNotrim = :tTmNotrim"),
    @NamedQuery(name=TTiempo.BUSCAR_TODOS, query="SELECT t FROM TTiempo t"),
    @NamedQuery(name=TTiempo.BUSCAR_UNA, query="SELECT t FROM TTiempo t where t.tTmId = :tTmId"),
    @NamedQuery(name=TTiempo.BUSCAR_FECHA, query="SELECT t FROM TTiempo t where t.tTmFecha = :tTmFecha"),    
    @NamedQuery(name = "TTiempo.findByTTmDiasem", query = "SELECT t FROM TTiempo t WHERE t.tTmDiasem = :tTmDiasem")})
public class TTiempo implements Serializable {
    public static final String BUSCAR_TODOS = "TTiempo.buscarTodos";
    public static final String BUSCAR_UNA = "TTiempo.buscarUna"; 
    public static final String BUSCAR_FECHA = "TTiempo.buscarFecha"; 
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_tm_id")
    private Integer tTmId;
    @Column(name = "t_tm_fecha")
    @Temporal(TemporalType.DATE)
    private Date tTmFecha;
    @Column(name = "t_tm_anio")
    private Short tTmAnio;
    @Column(name = "t_tm_mes")
    private Short tTmMes;
    @Column(name = "t_tm_dia")
    private Short tTmDia;
    @Column(name = "t_tm_semana")
    private Short tTmSemana;
    @Column(name = "t_tm_trimestre")
    private Short tTmTrimestre;
    @Column(name = "t_tm_cuatrimestre")
    private Short tTmCuatrimestre;
    @Column(name = "t_tm_semestre")
    private Short tTmSemestre;
    @Size(max = 12)
    @Column(name = "t_tm_nomes")
    private String tTmNomes;
    @Size(max = 12)
    @Column(name = "t_tm_nodia")
    private String tTmNodia;
    @Size(max = 10)
    @Column(name = "t_tm_notrim")
    private String tTmNotrim;
    @Column(name = "t_tm_diasem")
    private Short tTmDiasem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tTmId")
    private List<TAsigEnca> tAsigEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tTmId")
    private List<TRecepEnca> tRecepEncaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tTmId")
    private List<TSustit> tSustitList;

    public TTiempo() {
    }

    public TTiempo(Integer tTmId) {
        this.tTmId = tTmId;
    }

    public Integer getTTmId() {
        return tTmId;
    }

    public void setTTmId(Integer tTmId) {
        this.tTmId = tTmId;
    }

    public Date getTTmFecha() {
        return tTmFecha;
    }

    public void setTTmFecha(Date tTmFecha) {
        this.tTmFecha = tTmFecha;
    }

    public Short getTTmAnio() {
        return tTmAnio;
    }

    public void setTTmAnio(Short tTmAnio) {
        this.tTmAnio = tTmAnio;
    }

    public Short getTTmMes() {
        return tTmMes;
    }

    public void setTTmMes(Short tTmMes) {
        this.tTmMes = tTmMes;
    }

    public Short getTTmDia() {
        return tTmDia;
    }

    public void setTTmDia(Short tTmDia) {
        this.tTmDia = tTmDia;
    }

    public Short getTTmSemana() {
        return tTmSemana;
    }

    public void setTTmSemana(Short tTmSemana) {
        this.tTmSemana = tTmSemana;
    }

    public Short getTTmTrimestre() {
        return tTmTrimestre;
    }

    public void setTTmTrimestre(Short tTmTrimestre) {
        this.tTmTrimestre = tTmTrimestre;
    }

    public Short getTTmCuatrimestre() {
        return tTmCuatrimestre;
    }

    public void setTTmCuatrimestre(Short tTmCuatrimestre) {
        this.tTmCuatrimestre = tTmCuatrimestre;
    }

    public Short getTTmSemestre() {
        return tTmSemestre;
    }

    public void setTTmSemestre(Short tTmSemestre) {
        this.tTmSemestre = tTmSemestre;
    }

    public String getTTmNomes() {
        return tTmNomes;
    }

    public void setTTmNomes(String tTmNomes) {
        this.tTmNomes = tTmNomes;
    }

    public String getTTmNodia() {
        return tTmNodia;
    }

    public void setTTmNodia(String tTmNodia) {
        this.tTmNodia = tTmNodia;
    }

    public String getTTmNotrim() {
        return tTmNotrim;
    }

    public void setTTmNotrim(String tTmNotrim) {
        this.tTmNotrim = tTmNotrim;
    }

    public Short getTTmDiasem() {
        return tTmDiasem;
    }

    public void setTTmDiasem(Short tTmDiasem) {
        this.tTmDiasem = tTmDiasem;
    }

    public List<TAsigEnca> getTAsigEncaList() {
        return tAsigEncaList;
    }

    public void setTAsigEncaList(List<TAsigEnca> tAsigEncaList) {
        this.tAsigEncaList = tAsigEncaList;
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
        hash += (tTmId != null ? tTmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTiempo)) {
            return false;
        }
        TTiempo other = (TTiempo) object;
        if ((this.tTmId == null && other.tTmId != null) || (this.tTmId != null && !this.tTmId.equals(other.tTmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TTiempo[ tTmId=" + tTmId + " ]";
    }
    
}
