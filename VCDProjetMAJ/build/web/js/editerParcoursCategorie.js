/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function closeWin() {
    window.close();
}


 var fenetre = null;

                function myFunction(idParcoursCategorie) {
                    if (fenetre === null) {
                        fenetre=window.open("editerParcoursCategorie.jsf?idParcoursCategorie=" + idParcoursCategorie, "_blank", "location=no,menubar=no,resizable=no,titlebar=no,toolbar=no");
                    } else {
                         fenetre.close();
                        fenetre=window.open("editerParcoursCategorie.jsf?idParcoursCategorie=" + idParcoursCategorie, "_blank", "location=no,menubar=no,resizable=no,titlebar=no,toolbar=no");
                       
                    }
                }