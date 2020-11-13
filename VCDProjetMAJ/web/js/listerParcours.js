/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var fenetre = null;

function myFunction(idParcours) {
    if (fenetre === null) {
        fenetre = window.open("editerParcours.jsf?idParcours=" + idParcours, "_blank", "location=no,menubar=no,resizable=no,titlebar=no,toolbar=no");
    } else {
        fenetre = window.open("editerParcours.jsf?idParcours=" + idParcours, "_blank", "location=no,menubar=no,resizable=no,titlebar=no,toolbar=no");
        fenetre.close();
    }
}