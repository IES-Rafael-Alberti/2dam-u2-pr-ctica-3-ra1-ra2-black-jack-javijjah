package com.hachatml.blackjack.screens

import android.content.Context
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Jugador

val Mjugador1 = Jugador()
val Mjugador2 = Jugador()
var partidaFinalizada = false


fun iniciarPartida(context: Context) {
    Baraja.crearBaraja(context)
    Mjugador1.RobarCarta()
    Mjugador2.RobarCarta()
    Mjugador1.suTurno = true
}

fun devolverJugadorActivo(jugador1: Jugador, jugador2: Jugador): Jugador {
    if (jugador1.suTurno) {
        return jugador1
    }
    return jugador2
}

fun cambioDeTurno(jugador1: Jugador, jugador2: Jugador) {
    jugador1.suTurno = !(jugador1.suTurno)
    jugador2.suTurno = !(jugador2.suTurno)
    if (devolverJugadorActivo(jugador1, jugador2).plantado) {
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
    }
    if (jugador1.plantado && jugador2.plantado) {
        finalizarPartida()
    }
}

fun finalizarPartida() {
    partidaFinalizada = true
    calcularPuntos()
    calcularGanador()
}
fun calcularGanador(){
    if (Mjugador1.puntacion < 21 && Mjugador2.puntacion < 21) {
        if (Mjugador1.puntacion > Mjugador2.puntacion) {
            Mjugador1.ganador=true
        } else if (Mjugador2.puntacion > Mjugador1.puntacion) {
            Mjugador2.ganador=true
        }
    }
    else{
        if (Mjugador1.puntacion>21){
            Mjugador2.ganador=true
        }
        else if (Mjugador2.puntacion>21){
            Mjugador1.ganador=true
        }
    }
}
fun imprimirGanador():String{
    if (Mjugador1.ganador && Mjugador2.ganador){
        return "Error de cálculo"
    }
    else if (Mjugador1.ganador){
        return "¡Ha ganado el jugador 1 con ${Mjugador1.puntacion} puntos! "
    }
    else if (Mjugador2.ganador){
        return "¡Ha ganado el jugador 2 con ${Mjugador2.puntacion} puntos! "
    }
 return "Es un empate!"
}
fun calcularPuntos() {
    Mjugador1.puntacion = 0
    Mjugador2.puntacion = 0
    //todo puntos del AS
    for (carta in Mjugador1.Mano) {
        Mjugador1.puntacion += carta.puntosMax
    }
    for (carta in Mjugador2.Mano) {
        Mjugador2.puntacion += carta.puntosMax
    }
}

fun dameCarta() {
    devolverJugadorActivo(Mjugador1, Mjugador2).RobarCarta()
    cambioDeTurno(Mjugador1, Mjugador2)
}

fun plantarse() {
    devolverJugadorActivo(Mjugador1, Mjugador2).sePlanta()
    cambioDeTurno(Mjugador1, Mjugador2)
}

fun reiniciarPartida(){
    Mjugador1.reiniciarJugador()
    Mjugador2.reiniciarJugador()
    partidaFinalizada = false
}