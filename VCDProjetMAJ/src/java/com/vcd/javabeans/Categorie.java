/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.javabeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Moussa
 */
//*****************************************************************************************************************************************************************/
//*********************************************************              CLASSE Categorie          ****************************************************************/
//*****************************************************************************************************************************************************************/
@Entity
public class Categorie implements Serializable {

    //attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;
    private int ageMini;
    private int ageMaxi;
    private String libelle;
    private String sexe;
    private boolean elite = false;

//*****************************************************************************************************************************************************************/
//*********************************************************             UML NIVEAU 2 CLASSE Categorie          ****************************************************/
//****************************<*************************************************************************************************************************************/
   
    @OneToMany(mappedBy = "categorie")
    private List<Participant> listeParticipants;
    
    @OneToMany(mappedBy = "categorie")
    private List<ParcoursCategorie> listeParcoursCategories;
    
    


//*****************************************************************************************************************************************************************/
//********************************************************     CONSTRUCTEURS CLASSE Categorie     *****************************************************************/
//*****************************************************************************************************************************************************************/        
//constructeur vide
    public Categorie() {
    }
//*****************************************************************************************************************************************************************/
//*****************************************************   CONSTRUCTEURS PAR COPIE CLASSE Categorie   ************************************************************/
//*****************************************************************************************************************************************************************/

    public Categorie(int idCategorie, int ageMini, int ageMaxi, String libelle, String sexe) {
        this.idCategorie = idCategorie;
        this.ageMini = ageMini;
        this.ageMaxi = ageMaxi;
        this.libelle = libelle;
        this.sexe = sexe;
    }

    
    
    public Categorie(Categorie categorie) {
        this.idCategorie = categorie.idCategorie;
        this.ageMini = categorie.ageMini;
        this.ageMaxi = categorie.ageMaxi;
        this.libelle = categorie.libelle;
        this.sexe = categorie.sexe;
    }

//*****************************************************************************************************************************************************************/
//*********************************************************     GETTER SETTER CLASSE Categorie     ****************************************************************/
//*****************************************************************************************************************************************************************/ 
    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getAgeMini() {
        return ageMini;
    }

    public void setAgeMini(int ageMini) {
        this.ageMini = ageMini;
    }

    public int getAgeMaxi() {
        return ageMaxi;
    }

    public void setAgeMaxi(int ageMaxi) {
        this.ageMaxi = ageMaxi;
    }
//*****************************************************************************************************************************************************************/
//*********************************************************     GETTER SETTER LISTE CLASSE Categorie     ****************************************************************/
//*****************************************************************************************************************************************************************/ 

    public List<Participant> getListeParticipants() {
        return listeParticipants;
    }

    public void setListeParticipants(List<Participant> listeParticipants) {
        this.listeParticipants = listeParticipants;
    }

    public List<ParcoursCategorie> getListeParcoursCategories() {
        return listeParcoursCategories;
    }

    public void setListeParcoursCategories(List<ParcoursCategorie> listeParcoursCategories) {
        this.listeParcoursCategories = listeParcoursCategories;
    }

    public void messageElite() {
        String summary = elite ? "Création d'une catgorie Elite" : "Création d'une catgorie NON Elite";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));

    }

    public void messageEliteInscription() {
        String summary = elite ? "Catégorie Elite selectionnée" : "Catégorie Elite NON Sélectionnée";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));

    }
}
