/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.FaturaHyrese;
import Exceptions.FaturaHyreseException;
import java.util.List;


public class FaturaHyreseRepository extends EntityManagerClasses implements FatuaHyreseInterface {

    @Override
    public void create(FaturaHyrese fh) throws FaturaHyreseException {
        try {
            em.getTransaction().begin();
            em.persist(fh);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (e.getMessage().contains("2627")) {
                throw new FaturaHyreseException("E dhena egziston.");
            } else {
                throw new FaturaHyreseException(e.getMessage());
            }
        }
    }

    @Override
    public void edit(FaturaHyrese fh) throws FaturaHyreseException{
        try{
        em.getTransaction().begin();
        em.merge(fh);
        em.getTransaction().commit();
        }catch(Exception e){
            throw new FaturaHyreseException(e.getMessage());
        }
    }

    @Override
    public void remove(FaturaHyrese fh) throws FaturaHyreseException {
        try{
        em.getTransaction().begin();
        em.remove(fh);
        em.getTransaction().commit();
        }catch(Exception e){
                 throw new FaturaHyreseException(e.getMessage());
        }
    }

    @Override
    public List<FaturaHyrese> findAll() throws FaturaHyreseException{
        try{
        return (List<FaturaHyrese>) em.createNamedQuery("FaturaHyrese.findAll").getResultList();
        }catch(Exception e){
            throw new FaturaHyreseException(e.getMessage());
        }
    }

    @Override
    public FaturaHyrese findByID(Integer FaturaH_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
