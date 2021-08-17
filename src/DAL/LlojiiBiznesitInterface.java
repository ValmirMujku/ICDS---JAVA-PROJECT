/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.LlojiBiznesitException;
import BLL.LlojiiBiznesit;
import java.util.List;


public interface LlojiiBiznesitInterface {
    void create(LlojiiBiznesit llb) throws LlojiBiznesitException;
    void edit(LlojiiBiznesit llb) throws LlojiBiznesitException;
    void remove(LlojiiBiznesit llb) throws LlojiBiznesitException;
    List<LlojiiBiznesit> findAll() throws LlojiBiznesitException ;
}
