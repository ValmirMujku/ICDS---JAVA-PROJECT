
package DAL;

import BLL.Faktura;
import Exceptions.FaturaException;
import java.util.List;


public class FakturaRepository extends EntityManagerClasses implements FakturaInterFace {

    @Override
    public void create(Faktura f) throws FaturaException {
        try{
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(e.getMessage().contains("2627"))
            throw new FaturaException("E dhena egziston.");
            else{
                throw new FaturaException(e.getMessage());
            }
        }
    }

    @Override
    public void edit(Faktura f) throws FaturaException {
        try {
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FaturaException(e.getMessage());
        }
    }

    @Override
    public void remove(Faktura f) throws FaturaException {
        try {
            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FaturaException(e.getMessage());
        }
    }

    @Override
    public List<Faktura> findAll() throws FaturaException {
        try {
            return (List<Faktura>) em.createNamedQuery("Faktura.findAll").getResultList();
        } catch (Exception e) {
            throw new FaturaException(e.getMessage());
        }

    }

    @Override
    public Faktura findByID(Integer Faktura_ID) throws FaturaException {
        return null;
     
    }

}
