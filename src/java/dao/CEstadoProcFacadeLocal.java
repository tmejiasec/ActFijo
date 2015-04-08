/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoProc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CEstadoProcFacadeLocal {

    void create(CEstadoProc cEstadoProc);

    void edit(CEstadoProc cEstadoProc);

    void remove(CEstadoProc cEstadoProc);

    public List getList();
       
    public List busqueda(String desc);
   
    public CEstadoProc getEstpro(Integer estp);

    CEstadoProc find(Object id);

    List<CEstadoProc> findAll();

    List<CEstadoProc> findRange(int[] range);

    int count();
    
}
