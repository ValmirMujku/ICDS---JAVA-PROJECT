/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Hyrjet;
import Exceptions.HyrjetException;
import java.util.List;


public class HyrjetRepository extends EntityManagerClasses implements HyrjetInterface{

    @Override
    public void create(Hyrjet f) throws HyrjetException {
        try{
         em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        }catch(Exception e){
            if(e.getMessage().contains("2627"))
            throw new HyrjetException("E dhena egziston.");
            else{
                throw new HyrjetException(e.getMessage());
            }
        }
    }

    @Override
    public void edit(Hyrjet f)throws HyrjetException{
        try{
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new HyrjetException(e.getMessage());
        }
    }

    @Override
    public void remove(Hyrjet f)throws HyrjetException {
        try{
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new HyrjetException(e.getMessage());
        }
    }

    @Override
    public List<Hyrjet> findAll()throws HyrjetException {
        try{
         return (List<Hyrjet>) em.createNamedQuery("Hyrjet.findAll").getResultList();
        }catch(Exception e){
            throw new HyrjetException(e.getMessage());
        }
    }

    @Override
    public Hyrjet findByID(Integer Hyrjet_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
