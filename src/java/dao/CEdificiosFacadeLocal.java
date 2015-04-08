/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEdificios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CEdificiosFacadeLocal {

    void create(CEdificios cEdificios);

    void edit(CEdificios cEdificios);

    void remove(CEdificios cEdificios);
    
    public List getList();
   
    public List busqueda(String desc);
    
    public CEdificios getEdif(Integer edif);


    CEdificios find(Object id);

    List<CEdificios> findAll();

    List<CEdificios> findRange(int[] range);

    int count();
    
}
