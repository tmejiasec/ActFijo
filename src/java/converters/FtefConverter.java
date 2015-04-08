/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CFuentesFinFacadeLocal;
import entidades.CFuentesFin;
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
@Named(value = "ftefConverter")
@ManagedBean
@ViewScoped
public class FtefConverter implements Converter {
    
 public FtefConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione una...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CFuentesFin ftef = getDaoFtef().find(id);
                return ftef;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CFuentesFin)) {
            return null;
        }
        return String.valueOf(((CFuentesFin) value).getCFuentesId());
    }
     private CFuentesFinFacadeLocal getDaoFtef() {
        return (CFuentesFinFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CFuentesFinFacade!dao.CFuentesFinFacadeLocal");
    }
    
}
