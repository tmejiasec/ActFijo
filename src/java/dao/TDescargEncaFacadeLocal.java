/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TDescargEnca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TDescargEncaFacadeLocal {

    void create(TDescargEnca tDescargEnca);

    void edit(TDescargEnca tDescargEnca);

    void remove(TDescargEnca tDescargEnca);

    TDescargEnca find(Object id);

    List<TDescargEnca> findAll();

    List<TDescargEnca> findRange(int[] range);
    
    public List<TDescargEnca> getListJ(Integer jefe);


    int count();
    
}
