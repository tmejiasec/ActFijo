/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CEstadoMovFacadeLocal {

    void create(CEstadoMov cEstadoMov);

    void edit(CEstadoMov cEstadoMov);

    void remove(CEstadoMov cEstadoMov);

    public List getList();
       
    public List busqueda(String desc);
   
    public CEstadoMov getEstMov(Integer estm);
    
    CEstadoMov find(Object id);

    List<CEstadoMov> findAll();

    List<CEstadoMov> findRange(int[] range);

    int count();
    
}
