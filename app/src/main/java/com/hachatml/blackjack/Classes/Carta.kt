package com.hachatml.blackjack.Classes

import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos

class Carta(
    var nombre: Naipes,
    var palo: Palos,
    var puntosMin: Int,
    var puntosMax: Int,
    var idDrawable: Int
){
    //todo getDrawableResource
}