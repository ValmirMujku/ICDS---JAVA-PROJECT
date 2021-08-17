/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Biznesi;
import java.util.List;


public interface BiznesiInterface {

    void create(Biznesi b);

    void edit(Biznesi b);

    void remove(Biznesi b);

    List<Biznesi> findAll();

    Biznesi findByID(Integer Biznesi_ID);
}
