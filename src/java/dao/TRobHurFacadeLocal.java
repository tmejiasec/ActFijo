/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRobHur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TRobHurFacadeLocal {

    void create(TRobHur tRobHur);

    void edit(TRobHur tRobHur);

    void remove(TRobHur tRobHur);

    TRobHur find(Object id);

    List<TRobHur> findAll();

    List<TRobHur> findRange(int[] range);

    int count();
    
}
