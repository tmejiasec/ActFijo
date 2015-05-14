/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CRubros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CRubrosFacadeLocal {

    void create(CRubros cRubros);

    void edit(CRubros cRubros);

    void remove(CRubros cRubros);

    public List getList();
   
    public List busqueda(String desc);
    
    public CRubros getRubro(Integer rubro);
    
    public Integer busCodR(String cod);
    
    CRubros find(Object id);

    List<CRubros> findAll();

    List<CRubros> findRange(int[] range);

    int count();
    
}
