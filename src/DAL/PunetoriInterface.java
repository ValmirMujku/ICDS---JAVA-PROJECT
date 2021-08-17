/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Punetori;
import Exceptions.PunetoriException;
import java.util.List;


public interface PunetoriInterface {
    void create(Punetori p)throws PunetoriException;
    void edit(Punetori p )throws PunetoriException;
    void remove(Punetori p)throws PunetoriException;
    List<Punetori>findAll()throws PunetoriException;
   Punetori  findByID(Integer Punetori_ID)throws PunetoriException;
}
