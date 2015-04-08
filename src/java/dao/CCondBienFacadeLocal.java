/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CCondBien;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CCondBienFacadeLocal {

    void create(CCondBien cCondBien);

    void edit(CCondBien cCondBien);

    void remove(CCondBien cCondBien);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CCondBien getCondb(Integer condb);

    CCondBien find(Object id);

    List<CCondBien> findAll();

    List<CCondBien> findRange(int[] range);

    int count();
    
}
