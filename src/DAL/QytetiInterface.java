/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Qyteti;
import Exceptions.QytetiException;
import java.util.List;


public interface QytetiInterface {
     void create(Qyteti q)throws QytetiException;
    void edit(Qyteti q )throws QytetiException;
    void remove(Qyteti q)throws QytetiException;
    List<Qyteti>findAll()throws QytetiException;
   Qyteti  findByID(Integer Qyteti_ID)throws QytetiException;
}
