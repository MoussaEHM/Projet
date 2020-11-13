/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.controleur;

import com.vcd.ejb.DossardEjb;
import com.vcd.javabeans.Dossard;
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
public class DossardBean {

    @EJB
    DossardEjb dossardEjb;

    //Instanciation de Parcours
    private Dossard dossard = new Dossard();

    //Liste de Parcours
    private List<Dossard> listerDossard;
    private List<Dossard> listerDossardNonAffectes;



       public DossardBean(){
    
        }  
     

    public Dossard getDossard() {
        
        System.out.println("Tu rentres bien dans le set dossard");
        return dossard;
    }

    public void setDossard(Dossard dossard) {
        
        System.out.println("Tu rentres bien dans le set dossard");
        this.dossard = dossard;
    }

    public List<Dossard> getListerDossard() {
        this.listerDossard=dossardEjb.getListerDossard();
        return listerDossard;
    }

    public void setListerDossard(List<Dossard> listerDossard) {
        this.listerDossard = listerDossard;
    }

    public List<Dossard> getListerDossardNonAffectes() {
        this.listerDossardNonAffectes=dossardEjb.getListerDossardNonAffectes();
        return listerDossardNonAffectes;
    }

    public void setListerDossardNonAffectes(List<Dossard> listerDossardNonAffectes) {
        this.listerDossardNonAffectes = listerDossardNonAffectes;
    }
       
         
    /***************************************/
    /********Methode pour la categorie***/
    /**************************************/
    
    public void editerDossard() {

        //pas de participant par defaut
        this.dossard.setParticipant(null);
        dossardEjb.editer(this.dossard);
        
        //Récuperation de l'ID pour la modification et sinon l'ajout
        if(this.dossard.getNumDossard()>0){
         FacesMessage message = new FacesMessage("Dossard modifié avec succès !");
         FacesContext.getCurrentInstance().addMessage(null, message);   }
        else {
            FacesMessage message = new FacesMessage("Dossard ajouté avec succès !");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        //Vide le formulaire 
        this.dossard=new Dossard();
    }
    
    
    public void supprimerDossard(Dossard dossard) {

        dossardEjb.supprimer(dossard);
          FacesMessage message = new FacesMessage("Dossard supprimé avec succès !");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
       
}
