package com.devforxkill.demokot

// on passe les valeurs du constructeur
class Quote(strQuote : String){
    val strQuote = "$strQuote"
    var rating : Int

    // la méthode appelée à la création de l'objet
    init{
        rating = 0
    }
}