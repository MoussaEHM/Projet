/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.javabeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Moussa
 */
//*****************************************************************************************************************************************************************/
//********************************************************              CLASSE PARTICIPANT          ***************************************************************/
//*****************************************************************************************************************************************************************/
@Entity
public class Participant implements Serializable {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParticipant;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance = new Date();
    private String sexe;
    private String adresse;
    private String codePostal;
    private String ville;
    private String pays;
    private String mail;
    private String remarque;
    private String certificat;
    private String licence;
    private boolean verificationDocument;
    private String tempsParcours;
    @Temporal(TemporalType.DATE)
    private Date dateInscription = new Date();
    private boolean isAbandon;
    private boolean isArrive;
   
//*****************************************************************************************************************************************************************/
//*********************************************************             UML NIVEAU 2 CLASSE Participant          **************************************************/
//*****************************************************************************************************************************************************************/    
    @ManyToOne(fetch = FetchType.EAGER)
    private Parcours parcours = new Parcours();

    @ManyToOne
    private Categorie categorie = new Categorie();

//    @OneToOne(optional = false)
//    private Dossard dossard = new Dossard();

//*****************************************************************************************************************************************************************/
//********************************************************     CONSTRUCTEURS CLASSE Participant     ***************************************************************/
//*****************************************************************************************************************************************************************/    
    public Participant() {
    }

    public Participant(int idParticipant, String nom, String prenom, String sexe, String adresse, String codePostal, String ville, String pays, String mail, String remarque, String certificat, String licence, String verificationParticipant, boolean verificationDocument, String tempsParcours,String verif, boolean isAbandon, Parcours parcours, Categorie categorie, Dossard dossard, boolean isArrive) {
        this.idParticipant = idParticipant;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.mail = mail;
        this.remarque = remarque;
        this.certificat = certificat;
        this.licence = licence;
        this.verificationDocument = verificationDocument;
        this.tempsParcours = tempsParcours;
        this.parcours = parcours;
        this.categorie = categorie;
       // this.dossard = dossard;
        this.isAbandon = isAbandon;
        this.isArrive = isArrive;
    }

//*****************************************************************************************************************************************************************/
//*****************************************************   CONSTRUCTEURS PAR COPIE CLASSE Participant   ************************************************************/
//*****************************************************************************************************************************************************************/
    public Participant(Participant participant) {
        this.idParticipant = participant.idParticipant;
        this.nom = participant.nom;
        this.prenom = participant.prenom;
        this.dateNaissance = participant.dateNaissance;
        this.sexe = participant.sexe;
        this.adresse = participant.adresse;
        this.codePostal = participant.codePostal;
        this.ville = participant.ville;
        this.pays = participant.pays;
        this.mail = participant.mail;
        this.remarque = participant.remarque;
        this.certificat = participant.certificat;
        this.licence = participant.licence;
        this.verificationDocument = participant.verificationDocument;
        this.tempsParcours = participant.tempsParcours;
        this.dateInscription = participant.dateInscription;
        this.isAbandon = participant.isAbandon;
        this.isArrive = participant.isArrive;
    }



//*****************************************************************************************************************************************************************/
//********************************************************     GETTER SETTER CLASSE Participant     ***************************************************************/
//*****************************************************************************************************************************************************************/ 
    
    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

  
    public boolean isVerificationDocument() {
        return verificationDocument;
    }

    public void setVerificationDocument(boolean verificationDocument) {
        this.verificationDocument = verificationDocument;
    }

    public String getTempsParcours() {
        return tempsParcours;
    }

    public void setTempsParcours(String tempsParcours) {
        this.tempsParcours = tempsParcours;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isIsAbandon() {
        return isAbandon;
    }

    public void setIsAbandon(boolean isAbandon) {
        this.isAbandon = isAbandon;
    }

    public boolean isIsArrive() {
        return isArrive;
    }

    public void setIsArrive(boolean isArrive) {
        this.isArrive = isArrive;
    }

//*****************************************************************************************************************************************************************/
//********************************************************     GETTER SETTER UML 2 CLASSE Participant     *********************************************************/
//*****************************************************************************************************************************************************************/    
    public Parcours getParcours() {
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

//    public Dossard getDossard() {
//        return dossard;
//    }
//
//    public void setDossard(Dossard dossard) {
//        this.dossard = dossard;
//    }

    public String getTypeSexe() {
        if (this.sexe.equals(false)) {
            return "Homme";
        }
        if (this.sexe.equals(true)) {
            return "Femme";
        }
        return "Mixte";
    }
    
    public String getTypeVerif() {
        if (this.sexe.equals(false)) {
            return "Oui";
        }
        if (this.sexe.equals(true)) {
            return "Non";
        }
        return "";
    }

    @Override
    public String toString() {
        return "Participant{" + "idParticipant=" + idParticipant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + ", mail=" + mail + ", remarque=" + remarque + ", certificat=" + certificat + ", licence=" + licence + ", verificationDocument=" + verificationDocument + ", tempsParcours=" + tempsParcours + ", dateInscription=" + dateInscription + ", isAbandon=" + isAbandon + ", isArrive=" + isArrive + ", parcours=" + parcours + ", categorie=" + categorie + '}';
    }
    
    
    
    
    
    
}
