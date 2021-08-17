/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.PorosiaException;
import BLL.Porosia;
import java.util.List;


public class PorosiaRepository extends EntityManagerClasses implements PorosiaInterface{

    @Override
    public void create(Porosia p) throws PorosiaException {
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
    public void edit(Porosia p) throws PorosiaException {
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PorosiaException("ICDS:" + e.getMessage());
        }
    }

    @Override
    public void remove(Porosia p) throws PorosiaException {
        try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new PorosiaException("UBT:" + e.getMessage());
        }
    }

    @Override
    public List<Porosia> findAll() throws PorosiaException {
        try{
        return (List<Porosia>)em.createNamedQuery("Porosia.findAll").getResultList();
        } catch (Exception e) {
            throw new PorosiaException("UBT:" + e.getMessage());
        }
    }
    
}
