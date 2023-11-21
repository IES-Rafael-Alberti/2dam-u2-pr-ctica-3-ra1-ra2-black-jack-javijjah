package com.hachatml.blackjack.Classes

class Jugador {
    var Mazo = mutableListOf<Carta>()
    var plantado:Boolean = false
    var suTurno:Boolean = false


    fun sePlanta(){
        plantado = true
    }
    fun leToca(){
        suTurno = true
    }
}