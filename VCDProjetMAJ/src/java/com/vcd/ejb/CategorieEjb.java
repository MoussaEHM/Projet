/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.ejb;

import com.vcd.javabeans.Categorie;
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
public class CategorieEjb {
     
    @PersistenceContext
    private EntityManager em;               //Verification
    

    public List<Categorie> getListerCategorie() {

        System.out.println("Liste de categorie");

        Query query = em.createQuery("SELECT categorie FROM Categorie categorie");
        return query.getResultList();
    }
    
     public void editer(Object categorie) {
        em.merge(categorie);
    }

    public void supprimer(Object categorie) {

        em.remove(em.merge(categorie));

    } 
    
        // reprendre l'id de la classe et le mettre dans une autre classe.
    public Categorie getCategorieById(int id)
    {
        System.out.println("Le get parcours ");
       return em.find(Categorie.class, id);
    }
}
