/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Biznesi;
import java.util.List;


public class BiznesiRepository extends EntityManagerClasses implements BiznesiInterface{

    @Override
    public void create(Biznesi b) {
      em.getTransaction().begin();
      em.persist(b);
      em.getTransaction().commit();
    }

    @Override
    public void edit(Biznesi b) {
      em.getTransaction().begin();
      em.merge(b);
      em.getTransaction().commit();
    }

    @Override
    public void remove(Biznesi b) {
      em.getTransaction().begin();
      em.remove(b);
      em.getTransaction().commit();
    }

    @Override
    public List<Biznesi> findAll() {
         return (List<Biznesi>)em.createNamedQuery("Biznesi.findAll").getResultList();
    }

    @Override
    public Biznesi findByID(Integer Biznesi_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
