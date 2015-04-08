/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CUbicFacadeLocal;
import entidades.CUbic;
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
@Named(value = "ubicConverter")
@ManagedBean
@ViewScoped
public class UbicConverter implements Converter {
    
 public UbicConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione una...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CUbic ubic = getDaoUbic().find(id);
                return ubic;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de dependencia válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CUbic)) {
            return null;
        }
        return String.valueOf(((CUbic) value).getCUbicId());
    }
     private CUbicFacadeLocal getDaoUbic() {
        return (CUbicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CUbicFacade!dao.CUbicFacadeLocal");
    }
    
}
