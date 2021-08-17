package DAL;

import BLL.Produkti;
import Exceptions.ProduktiException;
import java.util.List;


public class ProduktiRepository extends EntityManagerClasses implements ProduktiInterface {

    @Override
    public void create(Produkti p) throws ProduktiException {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            if(e.getMessage().contains("2627")){
                throw new ProduktiException("Produkti Egziston.");
            }else{
                throw new ProduktiException(e.getMessage());
            }
        }
        
    }

    @Override
    public void edit(Produkti p)throws ProduktiException {
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        }catch(Exception e){
                throw new ProduktiException(e.getMessage());
        }
    }

    @Override
    public void remove(Produkti p)throws ProduktiException {
         try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
         }catch(Exception e){
                throw new ProduktiException(e.getMessage());
        }
    }

    @Override
    public List<Produkti> findAll()throws ProduktiException {
          try{
        return (List<Produkti>) em.createNamedQuery("Produkti.findAll").getResultList();
         }catch(Exception e){
                throw new ProduktiException(e.getMessage());
        }
    }

    @Override
    public Produkti findByID(Integer Produkti_ID) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
