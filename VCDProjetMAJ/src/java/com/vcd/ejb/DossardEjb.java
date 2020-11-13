/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.ejb;

import com.vcd.javabeans.Dossard;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Moussa
 */
@LocalBean
@Stateless
public class DossardEjb {

    @PersistenceContext
    private EntityManager em;               //Verification

    public List<Dossard> getListerDossard() {
        Query query = em.createQuery("SELECT dossard FROM Dossard dossard");
        return query.getResultList();
    }
    
    
    public List<Dossard> getListerDossardNonAffectes() {
        Query query = em.createQuery("SELECT dossard FROM Dossard dossard WHERE dossard.participant=null");
        return query.getResultList();
    }
    
    
    

    public void editer(Object dossard) {
        em.merge(dossard);
    }

    public void supprimer(Object dossard) {

        em.remove(em.merge(dossard));

    }
        // reprendre l'id de la classe et le mettre dans une autre classe.
    public Dossard getDossardById(int id)
    {
        System.out.println("Le get dossard ");
       return em.find(Dossard.class, id);
    }
    
    
        // reprendre l'id de la classe et le mettre dans une autre classe.
    public Dossard getIdDossardByNum(int num)
    {
        Query query = em.createQuery("SELECT listedossard FROM Dossard listedossard WHERE listedossard.numDossard:num");
        query.setParameter("num", num);
        return (Dossard)query.getSingleResult();
    }
    
    
}
