/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Porosite;
import java.util.List;
import Exceptions.PorosiaException;


public class PorositeRepository extends EntityManagerClasses implements PorositeInterface{

    @Override
    public void create(Porosite p) throws PorosiaException{
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            if(e.getMessage().contains("2627"))
                 throw new PorosiaException("ICDS: Një porosi me ID të njejtë është i regjistruar në kompani.");
            else{
                 throw new PorosiaException("ICDS:" + e.getMessage());
            }
           
        }
           
        }

    @Override
    public void edit(Porosite p) throws PorosiaException {
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PorosiaException("ICDS:" + e.getMessage());
        }
    }

    @Override
    public void remove(Porosite p) throws PorosiaException {
        try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PorosiaException("UBT:" + e.getMessage());
        }
    }

    @Override
    public List<Porosite> findAll() throws PorosiaException{
        try{
        return (List<Porosite>)em.createNamedQuery("Porosite.findAll").getResultList();
        } catch (Exception e) {
            throw new PorosiaException("UBT:" + e.getMessage());
        }
    }
}

    
    

