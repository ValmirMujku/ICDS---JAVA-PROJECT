/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Users;
import Exceptions.UsersException;
import java.util.List;


public interface UsersInterface {
    void create(Users p)throws UsersException;
    void edit(Users p )throws UsersException;
    void remove(Users p)throws UsersException;
    List<Users>findAll()throws UsersException;
   Users  findByID(Integer Users_ID)throws UsersException;
}
