/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Komuna;
import Exceptions.KomunaException;
import java.util.List;


public interface KomunInterface {
        void create(Komuna k)throws KomunaException;
    void edit(Komuna k )throws KomunaException;
    void remove(Komuna k)throws KomunaException;
    List<Komuna>findAll()throws KomunaException;
   Komuna  findByID(Integer K_ID)throws KomunaException;
}
