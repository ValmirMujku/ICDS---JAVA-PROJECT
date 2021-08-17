/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Komuna;
import BLL.Produkti;
import Exceptions.KomunaException;
import java.util.List;


public class KomunaRepository extends EntityManagerClasses implements KomunInterface {

    @Override
    public void create(Komuna k)throws KomunaException {
        try{
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
        }catch(Exception e){
             if(e.getMessage().contains("2627"))
                 throw new KomunaException("E dhena egziston.");
            else{
                 throw new KomunaException( e.getMessage());
             }
        }
    }

    @Override
    public void edit(Komuna k)throws KomunaException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new KomunaException(e.getMessage());
        }
    }

    @Override
    public void remove(Komuna k)throws KomunaException {
        try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new KomunaException(e.getMessage());
        }
    }

    @Override
    public List<Komuna> findAll()throws KomunaException {
        try{
        return (List<Komuna>) em.createNamedQuery("Komuna.findAll").getResultList();
        }catch(Exception e){
            throw new KomunaException(e.getMessage());
        }
    }

    @Override
    public Komuna findByID(Integer K_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
