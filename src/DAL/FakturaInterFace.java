/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Faktura;
import Exceptions.FaturaException;
import java.util.List;


public interface FakturaInterFace {
    void create(Faktura f) throws FaturaException;
    void edit(Faktura f )throws FaturaException;
    void remove(Faktura f)throws FaturaException;
    List<Faktura>findAll()throws FaturaException;
    Faktura  findByID(Integer Faktura_ID)throws FaturaException;
}
