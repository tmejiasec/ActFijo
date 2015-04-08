/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CUbic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CUbicFacadeLocal {

    void create(CUbic cUbic);

    void edit(CUbic cUbic);

    void remove(CUbic cUbic);
    
    public List getList();
    
    public List<CUbic> getListA(Integer area);
    
     public List<CUbic> getListE(Integer edif);
   
    public List busqueda(String desc);
    
    public CUbic getUbic(Integer ubic);

    CUbic find(Object id);

    List<CUbic> findAll();

    List<CUbic> findRange(int[] range);

    int count();
    
}
