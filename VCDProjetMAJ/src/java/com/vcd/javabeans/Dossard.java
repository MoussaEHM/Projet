/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vcd.javabeans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Moussa
 */

//*****************************************************************************************************************************************************************/
//*********************************************************              CLASSE Dossard          ******************************************************************/
//*****************************************************************************************************************************************************************/
@Entity
public class Dossard implements Serializable {

    
    @Id
    private int numDossard;
    private long numRFID;

//*****************************************************************************************************************************************************************/
//*********************************************************             UML NIVEAU 2 CLASSE Dossard          ******************************************************/
//*****************************************************************************************************************************************************************/
   
@OneToOne
private Participant participant ;
  
//*****************************************************************************************************************************************************************/
//********************************************************     CONSTRUCTEURS CLASSE Dossard     *******************************************************************/
//*****************************************************************************************************************************************************************/           
    
    public Dossard() {
    }

    //constructeur par paramètre
    public Dossard( long numRFID, int numDossard, Participant participant) {
        this.numRFID = numRFID;
        this.numDossard = numDossard;
        this.participant = participant;
    }
 

//*****************************************************************************************************************************************************************/
//*****************************************************   CONSTRUCTEURS PAR COPIE CLASSE Dossard   ************************************************************/
//*****************************************************************************************************************************************************************/
    public Dossard(Dossard dossard) {
        this.numRFID = dossard.numRFID;
        this.numDossard = dossard.numDossard;
    }
       
//*****************************************************************************************************************************************************************/
//*********************************************************     GETTER SETTER CLASSE Dossard     ******************************************************************/
//*****************************************************************************************************************************************************************/    

  

    public long getNumRFID() {
        return numRFID;
    }

    public void setNumRFID(long numRFID) {
        this.numRFID = numRFID;
    }

    public int getNumDossard() {
        return numDossard;
    }

    public void setNumDossard(int numDossard) {
        this.numDossard = numDossard;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "Dossard{" + "numDossard=" + numDossard + ", numRFID=" + numRFID + ", participant=" + participant + '}';
    }
    
    
}

