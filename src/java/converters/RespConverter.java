/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CResponsablesFacadeLocal;
import entidades.CResponsables;
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
@Named(value = "respConverter")
@ManagedBean
@ViewScoped
public class RespConverter implements Converter {
    
 public RespConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CResponsables resp = getDaoResp().find(id);
                return resp;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro de responsable válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CResponsables)) {
            return null;
        }
        return String.valueOf(((CResponsables) value).getCRespId());
    }

//    public PerspectivaFacade getPerspectivaFacade() {
//        return perspectivaFacade;
//    }

     public CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }
    
}
