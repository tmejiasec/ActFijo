/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoBien;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CEstadoBienFacadeLocal {

    void create(CEstadoBien cEstadoBien);

    void edit(CEstadoBien cEstadoBien);

    void remove(CEstadoBien cEstadoBien);
    
    public List getList();
       
    public List busqueda(String desc);
    
    public CEstadoBien getEstBien(Integer estb);

    CEstadoBien find(Object id);

    List<CEstadoBien> findAll();

    List<CEstadoBien> findRange(int[] range);

    int count();
    
}
