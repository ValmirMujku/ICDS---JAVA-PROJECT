/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.FaturaHyrese;
import Exceptions.FaturaHyreseException;
import java.util.List;


public interface FatuaHyreseInterface {
    void create(FaturaHyrese fh)throws FaturaHyreseException;
    void edit(FaturaHyrese fh )throws FaturaHyreseException;
    void remove(FaturaHyrese fh)throws FaturaHyreseException;
    List<FaturaHyrese>findAll()throws FaturaHyreseException;
    FaturaHyrese  findByID(Integer FaturaH_ID)throws FaturaHyreseException;
}
