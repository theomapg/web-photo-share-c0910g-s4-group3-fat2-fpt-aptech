/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Acount;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

/**
 *
 * @author luancv_b00973
 */
public class AcountJpaController implements Serializable {

    private EntityManagerFactory factory = null;
    private EntityManager em = null;

    public AcountJpaController() {
        factory = Persistence.createEntityManagerFactory("PhotoSharePU");
    }

    public AcountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    //function create a account

    public void create(Acount acount) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(acount);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //function login account
    public boolean LoginAccount(Integer role) {
        try {

            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Query query = em.createNativeQuery("{call SP_LOGIN (?)}");
            query.setParameter(1, role);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
