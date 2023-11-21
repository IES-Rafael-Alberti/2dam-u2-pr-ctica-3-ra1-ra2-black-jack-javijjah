package com.hachatml.blackjack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hachatml.blackjack.Classes.Jugador

class Jugador_vs_Jugador {
    var jugador1 = Jugador()
    var jugador2 = Jugador()


    @Preview(showBackground = true)
    @Composable
    fun MainColumn() {
        ComenzarPartida()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally){
            //cartas de j2
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            )
            {
                jugador2.PintarMano()
            }
            Row {
                Botonera()
            }
            //cartas de j1
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                jugador1.PintarMano()
            }
        }
    }
    @Composable
    fun Botonera(){
        Button(onClick = { jugador1.RobarCarta() }) { //todo codigo de prueba
            Text(text = "Robar carta")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Plantarse")
        }
    }
    @Composable
    fun ComenzarPartida(){
        jugador1.suTurno = true
    }
    @Composable
    fun cambioDeTurno(){
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
    }
}