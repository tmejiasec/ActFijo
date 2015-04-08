/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CEstadoProcFacadeLocal;
import entidades.CEstadoProc;
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
@Named(value = "estpConverter")
@ManagedBean
@ViewScoped
public class EstpConverter implements Converter {
    
 public EstpConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CEstadoProc estp = getDaoEstp().find(id);
                return estp;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CEstadoProc)) {
            return null;
        }
        return String.valueOf(((CEstadoProc) value).getCEstproId());
    }
     private CEstadoProcFacadeLocal getDaoEstp() {
        return (CEstadoProcFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoProcFacade!dao.CEstadoProcFacadeLocal");
    }
    
}
