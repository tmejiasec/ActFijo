/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.naming.NamingException;

import dao.CDependenciasFacadeLocal;
import dao.CNivelesFacadeLocal;

import entidades.CDependencias;
import entidades.CNiveles;
import entidades.CProveedores;
import entidades.CRubros;

import util.AbstractBaseReportBean;
import util.FacesUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 */
@ManagedBean
@RequestScoped
public class ReporteBean extends AbstractBaseReportBean implements Serializable {

   private List<CDependencias> dependencias;
   private List<CRubros> rubros;
   private List<CProveedores> provee;
   
   private List total;
   private Object[] ingre;
   private int depen;
   private int nivel;
   private int prov;
   private Date fechD;
   private Date fechH;
   private Date fech;
   private String mes;
   private String anio;
   private String tipo;
   private String rubro;
   private String tiprep;
   
    /**
     * Creates a new instance of UsuarioBean
     * @throws NamingException 
     */
    public ReporteBean() throws NamingException {
        reportDir = "/reportes/";
        dependencias = getDaoDepen().getList();
       

    }

    @Override
    protected Map<String, Object> getReportParameters() {
    	
//    	reportParameters.put("mes",getMes());
//    	reportParameters.put("anio",getAnio());
        return reportParameters;
    }

    @Override
    protected JRDataSource getJRDataSource() {
        return new JRBeanCollectionDataSource(objetosReporte);
    }

    public String execute() {
        try {
            super.prepareReport();
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }

        return null;
    }

    public void addParametro(String key, Object valor) {
        reportParameters.put(key, valor);
    }

    public void setObjeto(Object objetos) {
        objetosReporte.clear();
        objetosReporte.add(objetos);
        execute();
    }
    
    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }


    public void repor() {
        this.setReportDir("/reportes/");
        execute();
    }
    
    
    public void lib_com() {
        this.setReportDir("/reportes/");
       
       if(mes !=null){    	
        	this.addParametro("mes",getMes());
        	this.addParametro("anio",getAnio());
      }
        execute();
    }


    public void dispo() throws NamingException {
        this.setReportDir("/reportes/");
       if(mes !=null){    	
        	this.addParametro("mes",getMes());
        	this.addParametro("anio",getAnio());
      }
        execute();
    }
    
    public void diarios() {
        this.setReportDir("/reportes/");
       	this.addParametro("fech",getFech());
        execute();
    }

    public void rango() {
        this.setReportDir("/reportes/");
       	this.addParametro("fechD",getFechD());
       	this.addParametro("fechH",getFechH());

        execute();
    }
    
    public void vrubro() {
        this.setReportDir("/reportes/");
        this.addParametro("rub",getRubro());
       	this.addParametro("fechD",getFechD());
       	this.addParametro("fechH",getFechH());
        execute();
    }
    
    public void vprovee() {
        this.setReportDir("/reportes/");
        this.addParametro("prov",getProv());
       	this.addParametro("fechD",getFechD());
       	this.addParametro("fechH",getFechH());
        execute();
    }
    public void verif() {
        this.setReportDir("/reportes/");
       
       if(mes !=null){   
    	    this.addParametro("tipo",getTipo());
        	this.addParametro("mes",getMes());
        	this.addParametro("anio",getAnio());

      }
        execute();
    }
    
    public void tipcol() {
        this.setReportDir("/reportes/");
       
       if(mes !=null){   
    	    this.addParametro("tipo",getTipo());
        	this.addParametro("mes",getMes());
        	this.addParametro("anio",getAnio());

      }
        execute();
    }
    
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Date getFech() {
		return fech;
	}

	public void setFech(Date fech) {
		this.fech = fech;
	}

	public Date getFechD() {
		return fechD;
	}

	public void setFechD(Date fechD) {
		this.fechD = fechD;
	}

	public Date getFechH() {
		return fechH;
	}

	public void setFechH(Date fechH) {
		this.fechH = fechH;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<CProveedores> getProvee() {
		return provee;
	}

	public void setProvee(List<CProveedores> provee) {
		this.provee = provee;
	}

	public int getProv() {
		return prov;
	}

	public void setProv(int prov) {
		this.prov = prov;
	}

	
	public String getTiprep() {
		return tiprep;
	}

	public void setTiprep(String tiprep) {
		this.tiprep = tiprep;
	}

	public List<CRubros> getRubros() {
		return rubros;
	}

	public void setRubros(List<CRubros> rubros) {
		this.rubros = rubros;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Object[] getIngre() {
		return ingre;
	}

	public void setIngre(Object[] ingre) {
		this.ingre = ingre;
	}

	public List getTotal() {
		return total;
	}

	public void setTotal(List total) {
		this.total = total;
	}

    public List<CDependencias> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<CDependencias> dependencias) {
        this.dependencias = dependencias;
    }

    public int getDepen() {
        return depen;
    }

    public void setDepen(int depen) {
        this.depen = depen;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

        private String comillas(String valor){
		return "'"+valor+"'";
	}

}
