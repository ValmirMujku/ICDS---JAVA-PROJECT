/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Stoku;
import java.util.List;

/**
 *
 * @author hp
 */
public interface StokuInterface {
     void create(Stoku s) ;
    void edit(Stoku s );
    void remove(Stoku s);
    List<Stoku>findAll();
    Stoku  findByID(Integer Stoku_ID);
}
