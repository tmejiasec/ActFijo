/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CProyectosFacadeLocal;
import entidades.CProyectos;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import util.FacesUtil;
/**
 *
 * @author Teo de Renderos
 */
@Named(value = "proyConverter")
@ManagedBean
@ViewScoped
public class ProyConverter implements Converter {
    
 public ProyConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CProyectos proy = getDaoProy().find(id);
                return proy;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CProyectos)) {
            return null;
        }
        return String.valueOf(((CProyectos) value).getCProyId());
    }
     private CProyectosFacadeLocal getDaoProy() {
        return (CProyectosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CProyectosFacade!dao.CProyectosFacadeLocal");
    }
    
}
