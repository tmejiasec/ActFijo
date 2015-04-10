/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEspecificos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CEspecificosFacadeLocal {

    void create(CEspecificos cEspecificos);

    void edit(CEspecificos cEspecificos);

    void remove(CEspecificos cEspecificos);
    
    public List getList();
    
    public List<CEspecificos> getListM(Integer rubro);
   
    public List busqueda(String desc);
    
    public CEspecificos getEspec(Integer espec);
    
    public Integer updateC(Integer espec,Integer corr);    

    CEspecificos find(Object id);

    List<CEspecificos> findAll();

    List<CEspecificos> findRange(int[] range);

    int count();
    
}
