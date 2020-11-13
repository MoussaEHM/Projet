/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function choixLicence(objet)
{
    if (objet.value === 'licence') {
        document.getElementById('blocElite').style.display = 'block';
    }
    if (objet.value === 'nonLicence') {
        document.getElementById('blocElite').style.display = 'none';
    }

}