/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CRolesFacadeLocal {

    void create(CRoles cRoles);

    void edit(CRoles cRoles);

    void remove(CRoles cRoles);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CRoles getRol(Integer rol);
 
    CRoles find(Object id);

    List<CRoles> findAll();

    List<CRoles> findRange(int[] range);

    int count();
    
}
