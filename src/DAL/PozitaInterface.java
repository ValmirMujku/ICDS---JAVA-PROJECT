/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.PozitatException;
import BLL.Pozitat;
import java.util.List;


public interface PozitaInterface {
    void create(Pozitat p) throws PozitatException;
    void edit(Pozitat p)throws PozitatException;
    void remove(Pozitat p)throws PozitatException;
    List<Pozitat> findAll()throws PozitatException;
    
}
