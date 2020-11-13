/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.controleur;

import com.vcd.ejb.DossardEjb;
import com.vcd.ejb.ParticipantEjb;
import com.vcd.javabeans.Dossard;
import com.vcd.javabeans.Participant;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class ParticipantBean implements Serializable {

    // connexion avec le participantEjb
    @EJB
    ParticipantEjb participantEjb;

    // connexion avec le dossardEjb
    @EJB
    DossardEjb dossardEjb;

    // copie du fichier image
    private UploadedFile file;
    private final StreamedContent fileDownload;

    // choix du dossard du participant;
    private int numDossard;

    // texte
    private String text;

//******************************************************************************************************************************************************************************//
//                                      INSTANCIATION
//******************************************************************************************************************************************************************************//
//Instanciation de Participant
    private Participant participant = new Participant();

    //Licence
    private String tarif;
//******************************************************************************************************************************************************************************//
//                                      LISTES
//******************************************************************************************************************************************************************************//
//Liste des inscrits   
    private List<Participant> listeInscrits = new ArrayList<>();
    private List<Participant> listePreInscrits = new ArrayList<>();

        //charger le dossard du participant
    public int chargerDossard(Participant participant) {
        //charger le dossard du participant
        // retrouver si il a un dossard déjà affecté
        Dossard dossard=participantEjb.getNumDossardParticipant(participant);
        //Recupère le nom du dossard
        return dossard.getNumDossard();
    }

    
    /*GETTER SETTER*/
    public String ouvrirParticipant(Participant participant) {
        this.participant = participant;
        // retrouver si il a un dossard déjà affecté
        Dossard dossard = participantEjb.getNumDossardParticipant(participant);
        if (dossard != null) {
            numDossard = participantEjb.getNumDossardParticipant(this.participant).getNumDossard();
        }
        return "editerInscrit";
    }

    

    public List<Participant> getListeInscrits() {
        this.listeInscrits = participantEjb.getListerParticipant(true);
        return this.listeInscrits;
    }

    public List<Participant> getListePreInscrits() {
        this.listePreInscrits = participantEjb.getListerParticipant(false);
        return this.listePreInscrits;
    }

//******************************************************************************************************************************************************************************//
//                                      METHODES
//******************************************************************************************************************************************************************************//
    // PAGE INSCRIPTION   
    public String inscription() {
        //editer le participant
        participantEjb.editer(participant);
        //Récuperation de l'ID pour la modification et sinon l'ajout
        FacesMessage message = new FacesMessage("Participant ajouté avec succès !");
        FacesContext.getCurrentInstance().addMessage(null, message);
        //Vide le formulaire 
        this.participant = new Participant();

        return "listeInscrits";
    }
    

    // PAGE INSCRIPTION   
    // Ajouter un Participant
    public String editer() {
        //si le participant avait déjà un dossard, mais on n'a pas changé son dossard
        if (numDossard != 0) {
            //si le participant avait déjà un numéro de dossard
            Dossard dossardAvant = participantEjb.getNumDossardParticipant(participant);
            //si le participant avait deja un dossard, il faut le vider
            if (dossardAvant != null) {
                dossardAvant.setParticipant(null);
                //editer le dossard
                dossardEjb.editer(dossardAvant);
            }
            //retrouver le dossard qui va lui être affecté
            Dossard dossard = dossardEjb.getDossardById(numDossard);
            // affecter son dossard
            dossard.setParticipant(participant);
            //editer le dossard
            dossardEjb.editer(dossard);
        }
        //editer le participant
        participantEjb.editer(participant);
        //Récuperation de l'ID pour la modification et sinon l'ajout
        if (this.participant.getIdParticipant() > 0) {
            FacesMessage message = new FacesMessage("Participant modifié avec succès !");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("Participant ajouté avec succès !");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        //Vide le formulaire 
        this.participant = new Participant();
        return "listeInscrits";
    }

    
    
    //Supprime le participant 
    public void supprimer(Participant participant) {
        //si le participant avait déjà un numéro de dossard
        Dossard dossardAvant = participantEjb.getNumDossardParticipant(participant);
        //si le participant avait deja un dossard, il faut le vider
        if (dossardAvant != null) {
            dossardAvant.setParticipant(null);
            //editer le dossard
            dossardEjb.editer(dossardAvant);
        }
        participantEjb.supprimer(participant);
        FacesMessage message = new FacesMessage("Participant supprimer avec succès !");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //choix de la licence
    public void selectTarif() {

        if (this.participant.getLicence().equalsIgnoreCase("licence")) {
            this.tarif = "28 €";
        } else if (this.participant.getLicence().equalsIgnoreCase("nonLicence")) {
            this.tarif = "30 €";
        } else if (this.participant.getLicence().equalsIgnoreCase("autre")) {
            this.tarif = "15€";
        }
    }

    /**
     * **************************************************************************************************************
     * Faire un upload d'un fichier event/
     *
     ************************************************************************************************
     * @param event
     */
    public void upload(FileUploadEvent event) {

        //System.out.println("DEDANS "+event.getFile().getFileName());
        this.file = event.getFile();

        // fichier uploade
        if (file != null && !file.getFileName().equalsIgnoreCase("")) {
            // verifier si c'est une modification de l'image
//            int idRider=this.rider.getIdRider();
//            System.out.println("VIRE : "+idRider+" file "+file.getFileName());
//            if(idRider>0){
//                Rider r=this.riderEJB.find(idRider);
//                this.removeImg(r.getImgRider());
//            }

            final ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
            final String PATH_IMG_PARTICIPANT = external.getInitParameter("PATH_IMG_PARTICIPANT");

            try {
                // chemin du fichier de destination
                String imgParticipantName = this.generatedRandomNameFile();
                String destinationPath = PATH_IMG_PARTICIPANT + java.io.File.separator + imgParticipantName;
                System.out.println("Copier le fichier dans le répertoire : " + destinationPath);
                // creer le fichier sur le serveur
                File destinationFile = new File(destinationPath);
                // copier le fichier source vers la destination
                Files.copy(file.getInputstream(), destinationFile.toPath());
                // affecter le chemin au rider
                //this.rider.setImgRider(imgRiderName);
                this.participant.setCertificat(imgParticipantName);

                // message de succes
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // generer un nom au hasard
    public String generatedRandomNameFile() {
        int i = (int) (Math.random() * 100000000);
        return String.valueOf(i) + ".pdf";
    }

// Download Img
    public ParticipantBean() {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("D:\\TestUpload\\imgparticipant");
        fileDownload = new DefaultStreamedContent(stream, "image/jpg", "reglementTest.jpg");
    }

    public StreamedContent getFile() {
        return fileDownload;
    }

    public int getNumDossard() {
        return numDossard;
    }

    public void setNumDossard(int numDossard) {
        this.numDossard = numDossard;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
