/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTipDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CTipDocFacadeLocal {

    void create(CTipDoc cTipDoc);

    void edit(CTipDoc cTipDoc);

    void remove(CTipDoc cTipDoc);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CTipDoc getTipdoc(Integer tipdoc);

    CTipDoc find(Object id);

    List<CTipDoc> findAll();

    List<CTipDoc> findRange(int[] range);

    int count();
    
}
