package com.vcd.javabeans;

import com.vcd.javabeans.ParcoursCategorie;
import com.vcd.javabeans.Participant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2020-10-02T12:07:41")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile SingularAttribute<Categorie, Boolean> elite;
    public static volatile SingularAttribute<Categorie, Integer> ageMini;
    public static volatile ListAttribute<Categorie, ParcoursCategorie> listeParcoursCategories;
    public static volatile SingularAttribute<Categorie, Integer> ageMaxi;
    public static volatile SingularAttribute<Categorie, String> libelle;
    public static volatile SingularAttribute<Categorie, Integer> idCategorie;
    public static volatile SingularAttribute<Categorie, String> sexe;
    public static volatile ListAttribute<Categorie, Participant> listeParticipants;

}