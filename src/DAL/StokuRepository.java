/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Shitjet;
import BLL.Stoku;
import java.util.List;
import javax.persistence.TypedQuery;


public class StokuRepository extends EntityManagerClasses implements StokuInterface {

    @Override
    public void create(Stoku s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Stoku s) {
        em.getTransaction().begin();
        em.merge(s);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Stoku s) {
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
    }

    @Override
    public List<Stoku> findAll() {
        return (List<Stoku>) em.createNamedQuery("Stoku.findAll").getResultList();
    }
    
    public List<Stoku> findByDate() {
        TypedQuery<Stoku> query
                = em.createQuery("SELECT s FROM Stoku s order by s.dataSkadencesProd", Stoku.class);
        if (query.getResultList() != null) {
            return query.getResultList();
        }
    return null;
    }

    @Override
    public Stoku findByID(Integer Stoku_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
