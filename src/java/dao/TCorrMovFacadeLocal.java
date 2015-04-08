/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TCorrMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TCorrMovFacadeLocal {

    void create(TCorrMov tCorrMov);

    void edit(TCorrMov tCorrMov);

    void remove(TCorrMov tCorrMov);

    TCorrMov find(Object id);

    List<TCorrMov> findAll();

    List<TCorrMov> findRange(int[] range);

    int count();
    
}
