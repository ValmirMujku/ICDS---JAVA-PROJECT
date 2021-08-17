/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Exceptions.LlojiBiznesitException;
import BLL.LlojiiBiznesit;
import java.util.List;


public class LlojiiBiznesitRepository extends EntityManagerClasses implements LlojiiBiznesitInterface{

    @Override
    public void create(LlojiiBiznesit llb) throws LlojiBiznesitException {
        try{
        em.getTransaction().begin();
        em.persist(llb);
        em.getTransaction().commit();
        } catch (Exception e) {
            if(e.getMessage().contains("2627"))
                 throw new LlojiBiznesitException("ICDS: Një lloj i biznesit i njejtë është i regjistruar në kompani.");
            else{
                 throw new LlojiBiznesitException("ICDS:" + e.getMessage());
            }
           
        }
    }

    @Override
    public void edit(LlojiiBiznesit llb) throws LlojiBiznesitException {
        try{
        em.getTransaction().begin();
        em.merge(llb);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new LlojiBiznesitException("ICDS:" + e.getMessage());
        }
    }

    @Override
    public void remove(LlojiiBiznesit llb) throws LlojiBiznesitException {
         try{
        em.getTransaction().begin();
        em.remove(llb);
        em.getTransaction().commit();
        } catch (Exception e) {
            throw new LlojiBiznesitException("UBT:" + e.getMessage());
        }
    }

    @Override
    public List<LlojiiBiznesit> findAll() throws LlojiBiznesitException {
        try{
        return (List<LlojiiBiznesit>)em.createNamedQuery("LlojiiBiznesit.findAll").getResultList();
        } catch (Exception e) {
            throw new LlojiBiznesitException("UBT:" + e.getMessage());
        }
    }
    
}
