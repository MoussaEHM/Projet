/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.controleur;

import com.vcd.ejb.ParcoursCategorieEjb;
import com.vcd.javabeans.ParcoursCategorie;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Moussa
 */
@Named
@RequestScoped
public class ParcoursCategorieBean {
    
    @EJB
    ParcoursCategorieEjb parcoursCategorieEjb;
    
    
    //Instanciation de ParcoursCategorie
    private ParcoursCategorie parcoursCategorie = new ParcoursCategorie();
    
    //Liste de ParcoursCategorie
    private List<ParcoursCategorie> listerParcoursCategorie;
  
     public ParcoursCategorieBean(){
    
        }   

      public void chargerParcoursCategorie(){
         System.out.println("chargerParours "+this.parcoursCategorie.getIdParcoursCategorie());
         this.parcoursCategorie=parcoursCategorieEjb.getParcoursCategorieById(this.parcoursCategorie.getIdParcoursCategorie());
     }
   
     
    public ParcoursCategorie getParcoursCategorie() {
        System.out.println("Rentre dans le Get de parcoursCategorie");
        return parcoursCategorie;
    }

    public void setParcoursCategorie(ParcoursCategorie parcoursCategorie) {
        this.parcoursCategorie = parcoursCategorie;
    }

    public List<ParcoursCategorie> getListerParcoursCategorie() {
        this.listerParcoursCategorie=parcoursCategorieEjb.getListerParcoursCategorie();
        return listerParcoursCategorie;
    }

    public void setListerParcoursCategorie(List<ParcoursCategorie> listerParcoursCategorie) {
        this.listerParcoursCategorie = listerParcoursCategorie;
    }
     
    
    
    public String editerParcoursCategorie() {
        
        
        System.out.println("Temps ajouter");
        parcoursCategorieEjb.editer(parcoursCategorie);
        FacesMessage message = new FacesMessage("Temps ajouté avec succès!");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        return "listerParcours";
    }
    
    public void supprimerParcoursCategorie(ParcoursCategorie parcoursCategorie) {

        parcoursCategorieEjb.supprimer(parcoursCategorie);
        
          FacesMessage message = new FacesMessage("Le parcours a bien été supprimé");
          FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
 
}
