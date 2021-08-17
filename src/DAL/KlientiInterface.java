/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import Exceptions.KlientiException;
import java.util.List;


public interface KlientiInterface {
    void create(Klienti p)throws KlientiException;
    void edit(Klienti p )throws KlientiException;
    void remove(Klienti p)throws KlientiException;
    List<Klienti>findAll()throws KlientiException;
   Klienti  findByID(Integer Klienti_ID)throws KlientiException;
}
