package com.vcd.controleur;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class AuthenticationBean {
    
     /*Page Connexion Admin*/
    private String identifiant = "admin";
    private String motdepasse;
    
      //Authentification
    // valider l'authentification
    public String validerAuthentification() {
        FacesMessage message = null;

        String redirection = "authentification";
        // authentification OK
        if (this.identifiant.equals("admin") && this.motdepasse.equals("admin")) {
            message = new FacesMessage("Mode admin activé");
            redirection = "succes";
        } // authentification KO
        else {
            message = new FacesMessage("Erreur lors de l'authentification");
        }
        //ajouter le message JSF
        FacesContext.getCurrentInstance().addMessage(null, message);
        return redirection;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
