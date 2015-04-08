/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTiposMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CTiposMovFacadeLocal {

    void create(CTiposMov cTiposMov);

    void edit(CTiposMov cTiposMov);

    void remove(CTiposMov cTiposMov);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CTiposMov getTipmov(Integer tipm);

    CTiposMov find(Object id);

    List<CTiposMov> findAll();

    List<CTiposMov> findRange(int[] range);

    int count();
    
}
