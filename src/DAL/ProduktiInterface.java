/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Produkti;
import Exceptions.ProduktiException;
import java.util.List;


public interface ProduktiInterface {
    void create(Produkti p)throws ProduktiException;
    void edit(Produkti p )throws ProduktiException;
    void remove(Produkti p)throws ProduktiException;
    List<Produkti>findAll()throws ProduktiException;
   Produkti  findByID(Integer Produkti_ID)throws ProduktiException;
}
