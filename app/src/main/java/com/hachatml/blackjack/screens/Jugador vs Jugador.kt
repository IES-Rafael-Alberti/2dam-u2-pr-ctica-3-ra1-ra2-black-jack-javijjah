package com.hachatml.blackjack.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Jugador

class Jugador_vs_Jugador {
    var jugador1 = Jugador()
    var jugador2 = Jugador()


    @Composable
    fun MainColumn(context: Context) {
        ComenzarPartida(context)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //cartas de j2
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            )
            {

                jugador2.PintarMano()
            }
            Text(text = "Jugador 2")
            Row {
                Botonera()
            }
            Text(text = "Jugador 1")
            //cartas de j1
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                jugador1.PintarMano()
            }
        }
    }

    //todo forzar dispositivo vertical
    @Composable
    fun Botonera() {
        Button(onClick = {
            devolverJugadorActivo().RobarCarta()
            cambioDeTurno()
        }
        ) { //todo ctp (codigo temporal prueba)
            Text(text = "Robar carta")
        }
        Button(onClick = { devolverJugadorActivo().sePlanta() }) {
            Text(text = "Plantarse")
        }
    }

    @Composable
    fun ComenzarPartida(context: Context) {
        var baraja = Baraja()
        Baraja.crearBaraja(context)
        jugador1.suTurno = true
    }
    fun cambioDeTurno() {
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
        if (devolverJugadorActivo().plantado) {
            jugador1.suTurno = !(jugador1.suTurno)
            jugador2.suTurno = !(jugador2.suTurno)
        }
    }

    fun devolverJugadorActivo(): Jugador {
        if (jugador1.suTurno) {
            return jugador1
        }
        return jugador2
    }
}