/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.javabeans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
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

/******************************************************************************************************************************************************************/
/******************************************************              CLASSE ParcoursCategorie          ************************************************************/
/******************************************************************************************************************************************************************/

//@IdClass(ParcoursCategorieID.class)
@Entity
public class ParcoursCategorie implements Serializable{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int  idParcoursCategorie;


    //attributs
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsMaxOr = new Date();
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsMaxArgent = new Date();
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsMaxBronze = new Date();
    
    @ManyToOne 
     private Categorie categorie = new Categorie();  

    
     @ManyToOne  
     private Parcours parcours = new Parcours();

//*****************************************************************************************************************************************************************/
//********************************************************     CONSTRUCTEURS CLASSE ParcoursCategorie     *********************************************************/
//*****************************************************************************************************************************************************************/               
    
    public ParcoursCategorie() {
    }
    
      //constructeur par paramètre
    public ParcoursCategorie(Date tempsMaxOr, Date tempsMaxArgent, Date tempsMaxBronze) {
        this.tempsMaxOr = tempsMaxOr;
        this.tempsMaxArgent = tempsMaxArgent;
        this.tempsMaxBronze = tempsMaxBronze;
    }


//*****************************************************************************************************************************************************************/
//*****************************************************   CONSTRUCTEURS PAR COPIE CLASSE ParcoursCategorie   ******************************************************/
//*****************************************************************************************************************************************************************/
    

    
    //contructeur par copie
    public ParcoursCategorie(ParcoursCategorie parcoursCategorie) {
        this.tempsMaxOr = parcoursCategorie.tempsMaxOr;
        this.tempsMaxArgent = parcoursCategorie.tempsMaxArgent;
        this.tempsMaxBronze = parcoursCategorie.tempsMaxBronze;
    }


    
//******************************************************************************************************************************************************************/
//**********************************************************     GETTER SETTER CLASSE ParcoursCategorie     ********************************************************/
//******************************************************************************************************************************************************************/        
    
    public Date getTempsMaxOr() {
        System.out.println("Classe de parcoursCategorie");
        return tempsMaxOr;
    }

    public void setTempsMaxOr(Date tempsMaxOr) {
        System.out.println("Classe de parcoursCategorie");
        this.tempsMaxOr = tempsMaxOr;
    }

    public Date getTempsMaxArgent() {
        return tempsMaxArgent;
    }

    public void setTempsMaxArgent(Date tempsMaxArgent) {
        this.tempsMaxArgent = tempsMaxArgent;
    }

    public Date getTempsMaxBronze() {
        return tempsMaxBronze;
    }

    public void setTempsMaxBronze(Date tempsMaxBronze) {
        this.tempsMaxBronze = tempsMaxBronze;
    }

//******************************************************************************************************************************************************************/
//**********************************************************     GETTER SETTER UML 2 CLASSE ParcoursCategorie     **************************************************/
//******************************************************************************************************************************************************************/        

    public int getIdParcoursCategorie() {
        return idParcoursCategorie;
    }

    public void setIdParcoursCategorie(int idParcoursCategorie) {
        this.idParcoursCategorie = idParcoursCategorie;
    }

  
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Parcours getParcours() {
        System.out.println("Rentre dans le parcoursCategorie");
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        
        System.out.println("Rentre dans le parcoursCategorie");
        this.parcours = parcours;
    }
}