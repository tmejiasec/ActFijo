/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TDeprec;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TDeprecFacadeLocal {

    void create(TDeprec tDeprec);

    void edit(TDeprec tDeprec);

    void remove(TDeprec tDeprec);

    TDeprec find(Object id);

    List<TDeprec> findAll();

    List<TDeprec> findRange(int[] range);

    int count();
    
}
