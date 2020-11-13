/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.ejb;

import com.vcd.javabeans.Dossard;
import com.vcd.javabeans.Participant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
public class ParticipantEjb {

    @PersistenceContext
    private EntityManager em;

    public ParticipantEjb() {

    }
    
    public List<Participant> getListerParticipant(boolean verification) {
        Query query = em.createQuery("SELECT listeParticipants FROM Participant listeParticipants WHERE listeParticipants.verificationDocument=:verif");
        query.setParameter("verif", verification);
        return query.getResultList();
    }
    
    
    // recupérer un numéro de dossard d'un participant
     public Dossard getNumDossardParticipant(Participant participant) {
        Query query = em.createQuery("SELECT dossard FROM Dossard dossard WHERE dossard.participant=:participant");
        query.setParameter("participant", participant);
        try{
            return (Dossard) query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
// Ajouter

    public void editer(Participant participant) {
        // Permet d'ajouter des données
        em.merge(participant);
    }

    public void supprimer(Participant participant) {

        em.remove(em.merge(participant));

    }

    public Participant getParticipantById(int id) {
        Participant p;
        p = em.find(Participant.class, id);
        return p;
    }
       public Dossard getDossardById(int id) {
        Dossard d;
        d = em.find(Dossard.class, id);
        return d;
    }

}
