/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CProveedores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CProveedoresFacadeLocal {

    void create(CProveedores cProveedores);

    void edit(CProveedores cProveedores);

    void remove(CProveedores cProveedores);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CProveedores getProv(Integer prov);

    CProveedores find(Object id);

    List<CProveedores> findAll();

    List<CProveedores> findRange(int[] range);

    int count();
    
}
