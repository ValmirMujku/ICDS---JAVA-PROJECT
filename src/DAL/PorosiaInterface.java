/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.PorosiaException;
import BLL.Porosia;
import java.util.List;


public interface PorosiaInterface {
    void create(Porosia p) throws PorosiaException;
    void edit(Porosia p) throws PorosiaException;
    void remove(Porosia p) throws PorosiaException;
    List<Porosia> findAll() throws PorosiaException ;
}
