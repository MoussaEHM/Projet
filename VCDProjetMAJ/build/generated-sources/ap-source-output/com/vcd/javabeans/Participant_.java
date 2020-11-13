package com.vcd.javabeans;

import com.vcd.javabeans.Categorie;
import com.vcd.javabeans.Parcours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2020-10-02T12:07:41")
@StaticMetamodel(Participant.class)
public class Participant_ { 

    public static volatile SingularAttribute<Participant, String> licence;
    public static volatile SingularAttribute<Participant, String> ville;
    public static volatile SingularAttribute<Participant, Categorie> categorie;
    public static volatile SingularAttribute<Participant, String> mail;
    public static volatile SingularAttribute<Participant, Date> dateNaissance;
    public static volatile SingularAttribute<Participant, Parcours> parcours;
    public static volatile SingularAttribute<Participant, Boolean> verificationDocument;
    public static volatile SingularAttribute<Participant, String> sexe;
    public static volatile SingularAttribute<Participant, String> codePostal;
    public static volatile SingularAttribute<Participant, String> nom;
    public static volatile SingularAttribute<Participant, Boolean> isArrive;
    public static volatile SingularAttribute<Participant, Integer> idParticipant;
    public static volatile SingularAttribute<Participant, String> certificat;
    public static volatile SingularAttribute<Participant, Date> dateInscription;
    public static volatile SingularAttribute<Participant, String> tempsParcours;
    public static volatile SingularAttribute<Participant, String> adresse;
    public static volatile SingularAttribute<Participant, Boolean> isAbandon;
    public static volatile SingularAttribute<Participant, String> prenom;
    public static volatile SingularAttribute<Participant, String> remarque;
    public static volatile SingularAttribute<Participant, String> pays;

}