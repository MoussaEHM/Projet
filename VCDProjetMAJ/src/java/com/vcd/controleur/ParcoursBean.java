/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.controleur;

import com.vcd.ejb.ParcoursEjb;
import com.vcd.javabeans.Parcours;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Moussa
 */


@Named
@RequestScoped
public class ParcoursBean {
    
    //Connexion  avec parcoursEjb
    @EJB
    ParcoursEjb parcoursEjb;
    
    
    //Instanciation de Parcours
    private Parcours parcours = new Parcours();
    
    //Liste de Parcours
    private List<Parcours> listerParcours ;
  
     public ParcoursBean(){
    
        }   
     //Charge la page consultation des parcours 
     public void chargerParcours(){
         System.out.println("chargerParours "+this.parcours.getIdParcours());
        //charger le parcours
         this.parcours=parcoursEjb.getParcoursById(this.parcours.getIdParcours());
     }
     
    public Parcours getParcours() {
        
        System.out.println("Tu rentres bien dans le Get parcours");
        return parcours;
    }
    
    public void setParcours(Parcours parcours) {
        System.out.println("Tu rentres bien dans le set parcours");
        this.parcours = parcours;
    }

    public List<Parcours> getListerParcours() {
        this.listerParcours=parcoursEjb.getListerParcours();
        return listerParcours;
    }

    public void setListerParcours(List<Parcours> listerParcours) {
        this.listerParcours = listerParcours;
    }
    
       
        
    
    /***************************************/
    /********Methode pour l'enfant***/
    /**************************************/
    
    public void editerParcours() {

          
        parcoursEjb.editer(this.parcours);
        
        if(this.parcours.getIdParcours()>0){
         FacesMessage message = new FacesMessage("Parcours modifié avec succès !");
         FacesContext.getCurrentInstance().addMessage(null, message);   
        }else {
            FacesMessage message = new FacesMessage("Parcours ajouté avec succès !");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        this.parcours=new Parcours();
    }
    
    
    public void supprimerParcours(Parcours parcours) {

        parcoursEjb.supprimer(parcours);
          FacesMessage message = new FacesMessage("Parcours supprimé avec succès !");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
