/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CEdificiosFacadeLocal;
import entidades.CEdificios;
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
@Named(value = "edifConverter")
@ManagedBean
@ViewScoped
public class EdifConverter implements Converter {
    
 public EdifConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CEdificios edif = getDaoEdif().find(id);
                return edif;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de edificio válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CEdificios)) {
            return null;
        }
        return String.valueOf(((CEdificios) value).getCEdifId());
    }

//    public PerspectivaFacade getPerspectivaFacade() {
//        return perspectivaFacade;
//    }

     private CEdificiosFacadeLocal getDaoEdif() {
        return (CEdificiosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEdificiosFacade!dao.CEdificiosFacadeLocal");
    }
    
}
