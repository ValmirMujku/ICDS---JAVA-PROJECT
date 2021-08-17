/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Hyrjet;
import Exceptions.HyrjetException;
import java.util.List;


public interface HyrjetInterface {
     void create(Hyrjet f) throws HyrjetException;
    void edit(Hyrjet f )throws HyrjetException;
    void remove(Hyrjet f)throws HyrjetException;
    List<Hyrjet>findAll()throws HyrjetException;
    Hyrjet  findByID(Integer Hyrjet_ID)throws HyrjetException;
}
