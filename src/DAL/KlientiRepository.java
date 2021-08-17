package DAL;

import BLL.Klienti;
import Exceptions.KlientiException;
import java.util.List;


public class KlientiRepository extends EntityManagerClasses implements KlientiInterface {

    @Override
    public void create(Klienti k) throws KlientiException {
        try{
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
        }catch(Exception e){
            if(e.getMessage().contains("2627")){
                throw new KlientiException("Klienti Egziston.");
            }else{
                throw new KlientiException(e.getMessage());
            }
        }
        
    }

    @Override
    public void edit(Klienti k)throws KlientiException {
        try{
        em.getTransaction().begin();
        em.merge(k);
        em.getTransaction().commit();
        }catch(Exception e){
                throw new KlientiException(e.getMessage());
        }
    }

    @Override
    public void remove(Klienti k)throws KlientiException {
         try{
        em.getTransaction().begin();
        em.remove(k);
        em.getTransaction().commit();
         }catch(Exception e){
                throw new KlientiException(e.getMessage());
        }
    }

    @Override
    public List<Klienti> findAll()throws KlientiException {
          try{
        return (List<Klienti>) em.createNamedQuery("Klienti.findAll").getResultList();
         }catch(Exception e){
                throw new KlientiException(e.getMessage());
        }
    }

    @Override
    public Klienti findByID(Integer Klienti_ID) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
