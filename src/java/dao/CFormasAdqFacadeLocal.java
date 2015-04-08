/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CFormasAdq;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CFormasAdqFacadeLocal {

    void create(CFormasAdq cFormasAdq);

    void edit(CFormasAdq cFormasAdq);

    void remove(CFormasAdq cFormasAdq);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CFormasAdq getFormad(Integer forma);

    CFormasAdq find(Object id);

    List<CFormasAdq> findAll();

    List<CFormasAdq> findRange(int[] range);

    int count();
    
}
