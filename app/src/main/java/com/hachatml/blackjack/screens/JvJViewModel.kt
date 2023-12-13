package com.hachatml.blackjack.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Jugador
class JvJViewModel{
    val Mjugador1 = MutableLiveData<Jugador>()
    val Mjugador2 = MutableLiveData<Jugador>()
var partidaFinalizada = false
var VMnavController:NavController? = null

fun iniciarPartida(context: Context, navController: NavController) {
    Baraja.crearBaraja(context)
    Mjugador1.value?.RobarCarta()
    Mjugador2.value?.RobarCarta()
    Mjugador1.value?.suTurno = true
    VMnavController = navController
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
    VMnavController?.navigate(Routes.PantallaVictoria.route)
}
fun calcularGanador(){
    if (Mjugador1.value!!!!.puntacion < 21 && Mjugador2.value!!!!.puntacion < 21) {
        if (Mjugador1.value!!!!.puntacion > Mjugador2.value!!.puntacion) {
            Mjugador1.value?.ganador=true
        } else if (Mjugador2.value!!.puntacion > Mjugador1.value!!.puntacion) {
            Mjugador2.value?.ganador=true
        }
    }
    else{
        if (Mjugador1.value!!.puntacion>21&& Mjugador2.value!!.puntacion>21){
            Mjugador1.value?.ganador=false
            Mjugador2.value?.ganador=false
        }
        else if (Mjugador1.value!!.puntacion>21){
            Mjugador2.value?.ganador=true
        }
        else if (Mjugador2.value!!.puntacion>21){
            Mjugador1.value?.ganador=true
        }
    }
}
fun imprimirGanador():String{
    if (Mjugador1.value!!.ganador && Mjugador2.value!!.ganador){
        return "Error de cálculo"
    }
    else if (Mjugador1.value!!.ganador){
        return "¡Ha ganado el jugador 1 con ${Mjugador1.value?.puntacion} puntos! "
    }
    else if (Mjugador2.value!!.ganador){
        return "¡Ha ganado el jugador 2 con ${Mjugador2.value?.puntacion} puntos! "
    }
 return "Es un empate!"
}
fun calcularPuntos() {
    Mjugador1.value?.puntacion = 0
    Mjugador2.value?.puntacion = 0
    //todo puntos del AS
    for (carta in Mjugador1.value!!.Mano) {
        Mjugador1.value!!.puntacion += carta.puntosMax
    }
    for (carta in Mjugador2.value!!.Mano) {
        Mjugador2.value!!.puntacion += carta.puntosMax
    }
}

fun dameCarta() {
    devolverJugadorActivo(Mjugador1.value!!, Mjugador2.value!!).RobarCarta()
    cambioDeTurno(Mjugador1.value!!, Mjugador2.value!!)
}

fun plantarse() {
    devolverJugadorActivo(Mjugador1.value!!, Mjugador2.value!!).sePlanta()
    cambioDeTurno(Mjugador1.value!!, Mjugador2.value!!)
}

fun reiniciarPartida(){
    Mjugador1.value?.reiniciarJugador()
    Mjugador2.value?.reiniciarJugador()
    partidaFinalizada = false
}
}