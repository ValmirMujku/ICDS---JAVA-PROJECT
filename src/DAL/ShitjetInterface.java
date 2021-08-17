/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Shitjet;
import java.util.List;


public interface ShitjetInterface {
    void create(Shitjet sh);
    void edit(Shitjet sh );
    void remove(Shitjet sh);
    List<Shitjet>findAll();
   Shitjet  findByID(Integer Shitjet_ID);
}
