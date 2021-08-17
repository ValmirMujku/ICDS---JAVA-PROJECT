/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Qyteti;
import Exceptions.QytetiException;
import java.util.List;


public class QytetiRepository extends EntityManagerClasses implements QytetiInterface{

    @Override
    public void create(Qyteti q)throws QytetiException {
        try{
        em.getTransaction().begin();
      em.persist(q);
      em.getTransaction().commit();
      } catch (Exception e) {
            if(e.getMessage().contains("2627"))
            throw new QytetiException("E dhena egziston.");
            else{
                throw new QytetiException(e.getMessage());
            }
        }
    }

    @Override
    public void edit(Qyteti q) throws QytetiException{
        try{
        em.getTransaction().begin();
      em.merge(q);
      em.getTransaction().commit();
        }catch(Exception qex){
            throw new QytetiException(qex.getMessage());
        }
    }

    @Override
    public void remove(Qyteti q)throws QytetiException {
        try{
         em.getTransaction().begin();
      em.remove(q);
      em.getTransaction().commit();
       }catch(Exception qex){
            throw new QytetiException(qex.getMessage());
        }
    }

    @Override
    public List<Qyteti> findAll()throws QytetiException {
        try{
       return (List<Qyteti>)em.createNamedQuery("Qyteti.findAll").getResultList();
        }catch(Exception qex){
            throw new QytetiException(qex.getMessage());
        }
    }

    @Override
    public Qyteti findByID(Integer Qyteti_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
