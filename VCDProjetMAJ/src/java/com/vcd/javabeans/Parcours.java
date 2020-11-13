/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Moussa
 */

//*****************************************************************************************************************************************************************/
//*********************************************************              CLASSE Parcours          *****************************************************************/
//*****************************************************************************************************************************************************************/
@Entity
public class Parcours implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idParcours;
    private String libelle;
    private float distance;
    @Temporal(TemporalType.TIME)
    private Date heureDepart = new Date();
    private String image;
    private String couleur;

//*****************************************************************************************************************************************************************/
//*********************************************************             UML NIVEAU 2 CLASSE Parcours         ******************************************************/
//*****************************************************************************************************************************************************************/
    

    @OneToMany(mappedBy = "parcours", cascade = CascadeType.PERSIST)
    private List<Participant> listeParticipants;
    
    @OneToMany(mappedBy = "parcours", cascade = CascadeType.PERSIST)
    private List<ParcoursCategorie> listeParcoursCategories;


//****************************************************************************************************************************************************************/
//********************************************************     CONSTRUCTEURS CLASSE Participant     ***************************************************************/
//*****************************************************************************************************************************************************************/        
    
    public Parcours() {
    }

        //constructeur par parametres
    public Parcours(int idParcours, String libelle, float distance, String image, String couleur) {
        this.idParcours = idParcours;
        this.libelle = libelle;
        this.distance = distance;
        this.image = image;
        this.couleur = couleur;
    }


    
    
//*****************************************************************************************************************************************************************/
//*****************************************************   CONSTRUCTEURS PAR COPIE CLASSE Parcours   ***************************************************************/
//*****************************************************************************************************************************************************************/
    
    public Parcours(Parcours parcours){
        this.idParcours = parcours.idParcours;
        this.libelle = parcours.libelle;
        this.distance = parcours.distance;
        this.heureDepart = parcours.heureDepart;
        this.image = parcours.image;
        this.couleur = parcours.couleur;

}    
    
//*******************************************************************************************************************************************************************/
//**********************************************************     GETTER SETTER CLASSE Participant     ***************************************************************/
//*******************************************************************************************************************************************************************/ 
   
    public int getIdParcours() {
        return idParcours;
    }

    public void setIdParcours(int idParcours) {
        this.idParcours = idParcours;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
    

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

 
    

//*******************************************************************************************************************************************************************/
//**********************************************************     GETTER SETTER UML 2 CLASSE Participant     ***************************************************************/
//*******************************************************************************************************************************************************************/ 
    
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
    
}


