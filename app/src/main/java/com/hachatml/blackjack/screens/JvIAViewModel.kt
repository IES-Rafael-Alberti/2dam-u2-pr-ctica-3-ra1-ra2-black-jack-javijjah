package com.hachatml.blackjack.screens

import android.content.Context
import androidx.navigation.NavController
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Jugador
import com.hachatml.blackjack.Classes.Routes
import com.hachatml.cartamasalta.enums.Naipes

class JvIAViewModel {
    val Mjugador1 = Jugador()
    val IA = Jugador()
    var partidaFinalizada = false
    var VMnavController: NavController? = null

    /**
     * Llamado antes de comenzar una partida. Roba una carta para cada jugador, le da el turno
     * al jugador 1 y pasa el navController al VM.
     */
    fun iniciarPartida(context: Context, navController: NavController) {
        Baraja.crearBaraja(context)
        Mjugador1.RobarCarta()
        IA.RobarCarta()
        Mjugador1.suTurno = true
        VMnavController = navController
    }

    /**
     * Función para uso interno. Devuelve el jugador al que le toca en el momento de llamada.
     */
    fun devolverJugadorActivo(jugador1: Jugador, jugador2: Jugador): Jugador {
        if (jugador1.suTurno) {
            return jugador1
        }
        return jugador2
    }

    /**
     * Pasa el turno a otro jugador. Si este está plantado, vuelve a invertir los turnos. Si
     * ambos jugadores están plantados, esta función llama a la de fin de partida.
     */
    fun cambioDeTurno(jugador1: Jugador, jugador2: Jugador) {
        do {
            cambiarTurno(jugador1, jugador2)
            if (devolverJugadorActivo(jugador1, jugador2).plantado) {
                cambiarTurno(jugador1, jugador2)
            }
            if (devolverJugadorActivo(jugador1, jugador2) == IA) {
                JugadaIA()
                cambiarTurno(jugador1, jugador2)
            }
            if (jugador1.plantado && jugador2.plantado) {
                finalizarPartida()
            }
        } while (Mjugador1.plantado&&!partidaFinalizada)
    }

    fun cambiarTurno(jugador1: Jugador,jugador2: Jugador){
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
    }
    fun JugadaIA() {
        calcularPuntos()
        var nombre:String = Baraja.ultimaCarta().nombre.toString()
        var punt:Int = Baraja.ultimaCarta().puntosMax
        if (Baraja.ultimaCarta().puntosMax + IA.puntacion < 21) {
            IA.RobarCarta()
        }
        else{
            IA.sePlanta()
        }
    }

    /**
     * Llamada al acabar una partida. Calcula los puntos y el ganador con otras funciones
     * y navega a la Screen de Victoria.
     */
    fun finalizarPartida() {
        partidaFinalizada = true
        calcularPuntos()
        calcularGanador()
        VMnavController?.navigate(Routes.PantallaVictoriaJVIA.route)
    }

    /**
     * Calcula el ganador con la puntuación guardada en ambos objetos Jugador y lo guarda en
     * la variable ganador en el objeto Jugador.
     */
    fun calcularGanador() {
        if (Mjugador1.puntacion <= 21 && IA.puntacion <= 21) {
            if (Mjugador1.puntacion > IA.puntacion) {
                Mjugador1.ganador = true
            } else if (IA.puntacion > Mjugador1.puntacion) {
                IA.ganador = true
            }
        } else {
            if (Mjugador1.puntacion > 21 && IA.puntacion > 21) {
                Mjugador1.ganador = false
                IA.ganador = false
            } else if (Mjugador1.puntacion > 21) {
                IA.ganador = true
            } else if (IA.puntacion > 21) {
                Mjugador1.ganador = true
            }
        }
    }

    /**
     * Devuelve un String con la condición de victoria que se ha cumplido.
     */
    fun imprimirGanador(): String {
        if (Mjugador1.ganador && IA.ganador) {
            return "Error de cálculo"
        } else if (Mjugador1.ganador) {
            return "¡Ha ganado el jugador con ${Mjugador1.puntacion} puntos! ¡Enhorabuena!"
        } else if (IA.ganador) {
            return "¡Ha ganado la IA con ${IA.puntacion} puntos! ¡Mala suerte!"
        }
        return "Es un empate!"
    }

    /**
     * Calcula los puntos de cada jugador y los mete en su respectivo objeto Jugador en la var puntuacion
     */
    fun calcularPuntos() {
        var j1tieneAS = false
        var j2tieneAS = false
        Mjugador1.puntacion = 0
        IA.puntacion = 0
        for (carta in Mjugador1.Mano) {
            if (carta.nombre != Naipes.AS) {
                Mjugador1.puntacion += carta.puntosMax
            } else {
                j1tieneAS = true
            }
        }
        if (Mjugador1.puntacion + 11 > 21 && j1tieneAS) {
            Mjugador1.puntacion += 1
        } else if (j1tieneAS) {
            Mjugador1.puntacion += 11
        }
        for (carta in IA.Mano) {
            if (carta.nombre != Naipes.AS) {
                IA.puntacion += carta.puntosMax
            } else {
                j2tieneAS = true
            }
            if (IA.puntacion + 11 > 21 && j2tieneAS) {
                IA.puntacion += 1
            } else if (j2tieneAS) {
                IA.puntacion += 11
            }
        }
    }

    /**
     * Le da una carta al jugador activo y cambia de turno.
     */
    fun dameCarta() {
        devolverJugadorActivo(Mjugador1, IA).RobarCarta()
        cambioDeTurno(Mjugador1, IA)
    }

    /**
     * Planta al jugador activo y cambia de turno.
     */
    fun plantarse() {
        devolverJugadorActivo(Mjugador1, IA).sePlanta()
        cambioDeTurno(Mjugador1, IA)
    }

    /**
     * Deja la partida lista para volver a jugar.
     */
    fun reiniciarPartida() {
        Mjugador1.reiniciarJugador()
        IA.reiniciarJugador()
        partidaFinalizada = false
    }
}
