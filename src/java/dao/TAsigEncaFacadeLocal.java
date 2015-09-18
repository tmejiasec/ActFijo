/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TAsigEnca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TAsigEncaFacadeLocal {

    void create(TAsigEnca tAsigEnca);

    void edit(TAsigEnca tAsigEnca);

    void remove(TAsigEnca tAsigEnca);

    TAsigEnca find(Object id);

    List<TAsigEnca> findAll();

    List<TAsigEnca> findRange(int[] range);
    
    public TAsigEnca getEnca(Integer move);
    
    public List getList();
    
    public List<TAsigEnca> getListJ(Integer jefe);


    int count();
    
}
