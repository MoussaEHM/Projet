/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.controleur;

import com.vcd.ejb.CategorieEjb;
import com.vcd.javabeans.Categorie;
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
public class CategorieBean {

    //Connexion avec la categorieEjb
    @EJB
    CategorieEjb categorieEjb;

    //Instanciation de Parcours
    private Categorie categorie = new Categorie();

    //Liste de Parcours
    private List<Categorie> listerCategorie;

    //Constructeur par défault
    public CategorieBean() {

    }
//Permet de charger les valeurs de l'Id Catégorie

    public void chargerCategorie() {
        System.out.println("chargerParours " + this.categorie.getIdCategorie());
          //Charger la catégorie
        this.categorie = categorieEjb.getCategorieById(this.categorie.getIdCategorie());
    }
// Getter et Setter

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getListerCategorie() {
        this.listerCategorie = categorieEjb.getListerCategorie();
        return listerCategorie;
    }

    public void setListerCategorie(List<Categorie> listerCategorie) {
        this.listerCategorie = listerCategorie;
    }

    //Editer la catégorie
    public void editerCategorie() {

        // Si l'âge mini est inferieur ou égal à l'âge maxi ou si elite est cocher et que l'âge mini et maxi est égal à 0
        if (this.categorie.getAgeMini() <= this.categorie.getAgeMaxi() && this.categorie.getAgeMaxi() !=0 && this.categorie.getAgeMaxi() != 0 
                || this.categorie.isElite()== true && this.categorie.getAgeMini()== 0 && this.categorie.getAgeMini()== 0) {
            //On peut editer 
            categorieEjb.editer(this.categorie);
            //Si l'ID récuperé est supérieur à 0, la modification est faite
            if (this.categorie.getIdCategorie() > 0) {
                FacesMessage message = new FacesMessage("Catégorie modifiée avec succès !");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } //Sinon l'ajout est fait
            else {
                FacesMessage message = new FacesMessage("Catégorie ajouter avec succès !");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            //Vide le formulaire
            this.categorie = new Categorie();
        } // Affiche un message d'erreur âges incorrectes
        else {
            FacesMessage message = new FacesMessage("Erreur les âges ne conviennent pas!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //Supprime la catégorie
    public void supprimerCategorie(Categorie categorie) {
        categorieEjb.supprimer(categorie);
        FacesMessage message = new FacesMessage("Categorie supprimée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
