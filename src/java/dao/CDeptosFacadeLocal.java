/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CDeptos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CDeptosFacadeLocal {

    void create(CDeptos cDeptos);

    void edit(CDeptos cDeptos);

    void remove(CDeptos cDeptos);
    
    public List getList();
   
    public List busqueda(String desc);
    
    public CDeptos getDepto (Integer depto);

    CDeptos find(Object id);

    List<CDeptos> findAll();

    List<CDeptos> findRange(int[] range);

    int count();
    
}
