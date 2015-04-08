/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TSustit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TSustitFacadeLocal {

    void create(TSustit tSustit);

    void edit(TSustit tSustit);

    void remove(TSustit tSustit);

    TSustit find(Object id);

    List<TSustit> findAll();

    List<TSustit> findRange(int[] range);

    int count();
    
}
