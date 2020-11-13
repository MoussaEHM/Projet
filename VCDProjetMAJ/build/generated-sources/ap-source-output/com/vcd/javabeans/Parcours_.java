package com.vcd.javabeans;

import com.vcd.javabeans.ParcoursCategorie;
import com.vcd.javabeans.Participant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2020-10-02T12:07:41")
@StaticMetamodel(Parcours.class)
public class Parcours_ { 

    public static volatile SingularAttribute<Parcours, Integer> idParcours;
    public static volatile SingularAttribute<Parcours, String> image;
    public static volatile SingularAttribute<Parcours, Float> distance;
    public static volatile ListAttribute<Parcours, ParcoursCategorie> listeParcoursCategories;
    public static volatile SingularAttribute<Parcours, String> libelle;
    public static volatile SingularAttribute<Parcours, String> couleur;
    public static volatile ListAttribute<Parcours, Participant> listeParticipants;
    public static volatile SingularAttribute<Parcours, Date> heureDepart;

}