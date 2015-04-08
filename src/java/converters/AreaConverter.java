/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CAreasFacadeLocal;
import entidades.CAreas;
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
@Named(value = "areaConverter")
@ManagedBean
@ViewScoped
public class AreaConverter implements Converter {
    
 public AreaConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione una...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CAreas area = getDaoArea().find(id);
                return area;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CAreas)) {
            return null;
        }
        return String.valueOf(((CAreas) value).getCAreaId());
    }
     private CAreasFacadeLocal getDaoArea() {
        return (CAreasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CAreasFacade!dao.CAreasFacadeLocal");
    }
    
}
