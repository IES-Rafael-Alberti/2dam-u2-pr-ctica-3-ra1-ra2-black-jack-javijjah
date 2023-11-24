package com.hachatml.blackjack.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hachatml.blackjack.Classes.Baraja
import com.hachatml.blackjack.Classes.Carta
import com.hachatml.blackjack.Classes.Jugador
import com.hachatml.blackjack.R
import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos


@Preview(showBackground = true)
@Composable
fun MainColumnPreview() {
    var context = LocalContext.current
    MainColumn(context)
}

@Composable
fun MainColumn(context: Context) {
    var jugador1 = Jugador()
    var jugador2 = Jugador()
    ComenzarPartida(jugador1, context)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.fondo),
                contentScale = ContentScale.FillBounds
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //cartas de j2
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        )
        {
            PintarMano(jugador2)
        }
        Text(text = "Jugador 2", modifier = Modifier.rotate(-180f), color = Color.White, fontSize = 30.sp)
        Row {
            Botonera(jugador1, jugador2)
        }
        //todo ver cómo hacer que el texto se vea mejor
        Text(text = "Jugador 1", color = Color.White, fontSize = 30.sp)
        //cartas de j1
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            PintarMano(jugador1)
        }
    }
}

@Composable
fun PintarMano(jugador: Jugador) {
    println("PintarMano llamado")
    for (card in jugador.Mano) {
        if (jugador.suTurno) {
            Image(
                painter = painterResource(id = card.idDrawable),
                contentDescription = "Carta de la mano",
                modifier = Modifier.size(150.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.facedown),
                contentDescription = "Carta de la mano",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

//todo forzar dispositivo vertical
@Composable
fun Botonera(jugador1: Jugador, jugador2: Jugador) {
    Button(onClick = {
        devolverJugadorActivo(jugador1, jugador2).RobarCarta()
        cambioDeTurno(jugador1, jugador2)
    }
    ) {
        Text(text = "Robar carta")
    }
    Button(onClick = { devolverJugadorActivo(jugador1, jugador2).sePlanta()
    cambioDeTurno(jugador1,jugador2)}) {
        Text(text = "Plantarse")
    }
}

@Composable
fun ComenzarPartida(jugador: Jugador, context: Context) {
    Baraja.crearBaraja(context)
    jugador.suTurno = true
}

fun cambioDeTurno(jugador1: Jugador, jugador2: Jugador) {
    jugador1.suTurno = !(jugador1.suTurno)
    jugador2.suTurno = !(jugador2.suTurno)
    if (devolverJugadorActivo(jugador1, jugador2).plantado) {
        jugador1.suTurno = !(jugador1.suTurno)
        jugador2.suTurno = !(jugador2.suTurno)
    }
    if (jugador1.plantado && jugador2.plantado) {
        finalizarPartida(jugador1,jugador2)
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
    if (puntuacionJugador1>puntuacionJugador2){

    }
}