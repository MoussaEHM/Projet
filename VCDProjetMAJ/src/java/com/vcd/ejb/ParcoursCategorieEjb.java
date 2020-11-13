/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.ejb;

import com.vcd.javabeans.ParcoursCategorie;
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
public class ParcoursCategorieEjb {

    @PersistenceContext
    private EntityManager em;               //Verification


    public List<ParcoursCategorie> getListerParcoursCategorie() {

        System.out.println("Liste de temps");

        Query query = em.createQuery("SELECT listeCategorie FROM ParcoursCategorie listeCategorie");
        return query.getResultList();
    }

    public void editer(Object parcCat) {
        em.merge(parcCat);
    }

    public void supprimer(Object parcCat) {

        em.remove(em.merge(parcCat));

    }

    // reprendre l'id de la classe et le mettre dans une autre classe.
    public ParcoursCategorie getParcoursCategorieById(int id) {
        System.out.println("getID parcoursCategorie");
        return em.find(ParcoursCategorie.class, id);
    }
}
