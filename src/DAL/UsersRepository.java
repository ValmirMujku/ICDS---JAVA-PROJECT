package DAL;

import BLL.Users;
import Exceptions.UsersException;
import java.util.List;

public class UsersRepository extends EntityManagerClasses implements UsersInterface {

    @Override
    public void create(Users p) throws UsersException {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            if(e.getMessage().contains("2627")){
                throw new UsersException("Users Egziston.");
            }else{
                throw new UsersException(e.getMessage());
            }
        }
        
    }

    @Override
    public void edit(Users p)throws UsersException {
        try{
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        }catch(Exception e){
                throw new UsersException(e.getMessage());
        }
    }

    @Override
    public void remove(Users p)throws UsersException {
         try{
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
         }catch(Exception e){
                throw new UsersException(e.getMessage());
        }
    }

    @Override
    public List<Users> findAll()throws UsersException {
          try{
        return (List<Users>) em.createNamedQuery("Users.findAll").getResultList();
         }catch(Exception e){
                throw new UsersException(e.getMessage());
        }
    }

    @Override
    public Users findByID(Integer Users_ID) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
