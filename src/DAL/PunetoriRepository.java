package DAL;

import BLL.Punetori;
import Exceptions.PunetoriException;
import java.util.List;


public class PunetoriRepository extends EntityManagerClasses implements PunetoriInterface {

    @Override
    public void create(Punetori p) throws PunetoriException {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            if(e.getMessage().contains("2627")){
                throw new PunetoriException("Punetori Egziston.");
            }else{
                throw new PunetoriException(e.getMessage());
            }
        }
        
    }

    @Override
    public void edit(Punetori p)throws PunetoriException {
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        }catch(Exception e){
                throw new PunetoriException(e.getMessage());
        }
    }

    @Override
    public void remove(Punetori p)throws PunetoriException {
         try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
         }catch(Exception e){
                throw new PunetoriException(e.getMessage());
        }
    }

    @Override
    public List<Punetori> findAll()throws PunetoriException {
          try{
        return (List<Punetori>) em.createNamedQuery("Punetori.findAll").getResultList();
         }catch(Exception e){
                throw new PunetoriException(e.getMessage());
        }
    }

    @Override
    public Punetori findByID(Integer Punetori_ID) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
