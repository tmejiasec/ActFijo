/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TCorrOtr;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Soporte
 */
@Local
public interface TCorrOtrFacadeLocal {

    void create(TCorrOtr tCorrOtr);

    void edit(TCorrOtr tCorrOtr);

    void remove(TCorrOtr tCorrOtr);

    TCorrOtr find(Object id);

    List<TCorrOtr> findAll();

    List<TCorrOtr> findRange(int[] range);

    int count();

    public List<TCorrOtr> getList();

    public Integer updateC(int anio, int nvoCorr);
    
    public TCorrOtr getCorrel(int corId, int anio);
    
}