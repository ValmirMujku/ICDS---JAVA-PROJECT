package DAL;

import BLL.Shitjet;
import java.util.List;
import javax.persistence.TypedQuery;


public class ShitjetRepository extends EntityManagerClasses implements ShitjetInterface {

    BiznesiRepository bsr = new BiznesiRepository();

    @Override
    public void create(Shitjet sh) {
        em.getTransaction().begin();
        em.persist(sh);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Shitjet sh) {
        em.getTransaction().begin();
        em.merge(sh);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Shitjet sh) {
        em.getTransaction().begin();
        em.remove(sh);
        em.getTransaction().commit();
    }

    @Override
    public List<Shitjet> findAll() {
        return (List<Shitjet>) em.createNamedQuery("Shitjet.findAll").getResultList();
    }

    public List<BLL.Shitjet> find(String pattern) {
        if (pattern != null) {
            TypedQuery<Shitjet> query
                    = em.createQuery("SELECT s from Shitjet s where s.biznesiID.emri LIKE :pattern ", Shitjet.class);
            query.setParameter("pattern", pattern + "%");
            if (query.getResultList() != null) {
                return query.getResultList();
            }
        }
        return null;
    }

    @Override
    public Shitjet findByID(Integer Shitjet_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
