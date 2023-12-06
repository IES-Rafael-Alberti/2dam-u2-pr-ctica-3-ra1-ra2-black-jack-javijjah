package com.hachatml.blackjack.screens
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Jugador
val Mjugador1 = Jugador()
val Mjugador2 = Jugador()
var partidaFinalizada = MutableLiveData<Boolean>()
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
        finalizarPartida(jugador1, jugador2)
    }
}
fun finalizarPartida(jugador1: Jugador, jugador2: Jugador) {
    var puntuacionJugador1 = 0
    var puntuacionJugador2 = 0
    //todo
    for (carta in jugador1.Mano) {
        puntuacionJugador1 += carta.puntosMax
    }
    for (carta in jugador2.Mano) {
        puntuacionJugador2 += carta.puntosMax
    }
    //todo condiciones de victoria
    partidaFinalizada.value = true
}
fun dameCarta(){
    if (Baraja.listaCartas.isEmpty()){
        Baraja.crearBaraja()
    }
    devolverJugadorActivo(Mjugador1, Mjugador2).RobarCarta()
}
fun Plantarse(){
    devolverJugadorActivo(Mjugador1, Mjugador2).sePlanta()
}
/*
class JvJViewModel {
    fun cambioDeTurno(jugador1: Jugador, jugador2: Jugador) {
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
        if (devolverJugadorActivo(jugador1, jugador2).plantado) {
            jugador1.suTurno = !(jugador1.suTurno)
            jugador2.suTurno = !(jugador2.suTurno)
        }
        if (jugador1.plantado && jugador2.plantado) {
            finalizarPartida(jugador1, jugador2)
        }
    }

    fun devolverJugadorActivo(jugador1: Jugador, jugador2: Jugador): Jugador {
        if (jugador1.suTurno) {
            return jugador1
        }
        return jugador2
    }

    fun finalizarPartida(jugador1: Jugador, jugador2: Jugador) {
        var puntuacionJugador1 = 0
        var puntuacionJugador2 = 0
        //todo
        for (carta in jugador1.Mano) {
            puntuacionJugador1 += carta.puntosMax
        }
        for (carta in jugador2.Mano) {
            puntuacionJugador2 += carta.puntosMax
        }
        //todo condiciones de victoria, preguntar cómo mostrar algo
        partidaFinalizada = true
    }
}
*/