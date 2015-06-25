/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TMovimDeta;
import entidades.TMovimEnca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TMovimDetaFacadeLocal {

    void create(TMovimDeta tMovimDeta);

    void edit(TMovimDeta tMovimDeta);

    void remove(TMovimDeta tMovimDeta);

    TMovimDeta find(Object id);

    List<TMovimDeta> findAll();

    List<TMovimDeta> findRange(int[] range);

    int count();
    
   public List getList();
       
   public List<TMovimDeta> getListM(Integer move);
    
   public TMovimDeta getMoved(Integer moved);
   
   public Integer busCod(String cod, Integer move);

    
    
}
