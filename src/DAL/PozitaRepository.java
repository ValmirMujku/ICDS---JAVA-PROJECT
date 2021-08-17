/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.PozitatException;
import BLL.Pozitat;
import java.util.List;


public class PozitaRepository extends EntityManagerClasses implements PozitaInterface{
    
    @Override
    public void create(Pozitat p) throws PozitatException{
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            if(e.getMessage().contains("2627"))
                 throw new PozitatException("ICDS: Një pozitë me ID të njejtë ekziston në kompani.");
            else{
                 throw new PozitatException("ICDS:" + e.getMessage());
            }
           
        }
    }

    @Override
    public void edit(Pozitat p) throws PozitatException{
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PozitatException("ICDS:" + e.getMessage());
        }
    }

    @Override
    public void remove(Pozitat p) throws PozitatException{
        try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PozitatException("UBT:" + e.getMessage());
        }
    }

    @Override
    public List<Pozitat> findAll() throws PozitatException{
        try{
        return (List<Pozitat>)em.createNamedQuery("Pozitat.findAll").getResultList();
        } catch (Exception e) {
            throw new PozitatException("UBT:" + e.getMessage());
        }
    }
}

    
