/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.ejb;

import com.vcd.javabeans.Parcours;
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
public class ParcoursEjb {
    
    @PersistenceContext
    private EntityManager em;               //Verification
    

    public List<Parcours> getListerParcours() {

        System.out.println("Liste de parours");

        Query query = em.createQuery("SELECT listeParcours FROM Parcours listeParcours");
        return query.getResultList();
    }
    
     public void editer(Parcours parc) {
        em.merge(parc);
    }

    public void supprimer(Parcours parc) {

        em.remove(em.merge(parc));

    } 
    
    // reprendre l'id de la classe et le mettre dans une autre classe.
    public Parcours getParcoursById(int id)
    {
        System.out.println("Le get parcours ");
       return em.find(Parcours.class, id);
    }
}
