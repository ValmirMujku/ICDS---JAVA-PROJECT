/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Porosite;
import Exceptions.PorosiaException;
import java.util.List;


public interface PorositeInterface {
    void create(Porosite p) throws PorosiaException;
    void edit(Porosite p)throws PorosiaException;
    void remove(Porosite p)throws PorosiaException;
    List<Porosite> findAll()throws PorosiaException;
}
