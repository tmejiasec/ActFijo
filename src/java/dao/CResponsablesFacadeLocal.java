/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CResponsables;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CResponsablesFacadeLocal {

    void create(CResponsables cResponsables);

    void edit(CResponsables cResponsables);

    void remove(CResponsables cResponsables);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CResponsables getResp(Integer resp);

    CResponsables find(Object id);

    List<CResponsables> findAll();

    List<CResponsables> findRange(int[] range);

    int count();
    
}
