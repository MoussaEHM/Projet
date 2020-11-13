package com.vcd.javabeans;

import com.vcd.javabeans.Categorie;
import com.vcd.javabeans.Parcours;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2020-10-02T12:07:41")
@StaticMetamodel(ParcoursCategorie.class)
public class ParcoursCategorie_ { 

    public static volatile SingularAttribute<ParcoursCategorie, Date> tempsMaxOr;
    public static volatile SingularAttribute<ParcoursCategorie, Date> tempsMaxBronze;
    public static volatile SingularAttribute<ParcoursCategorie, Categorie> categorie;
    public static volatile SingularAttribute<ParcoursCategorie, Parcours> parcours;
    public static volatile SingularAttribute<ParcoursCategorie, Integer> idParcoursCategorie;
    public static volatile SingularAttribute<ParcoursCategorie, Date> tempsMaxArgent;

}