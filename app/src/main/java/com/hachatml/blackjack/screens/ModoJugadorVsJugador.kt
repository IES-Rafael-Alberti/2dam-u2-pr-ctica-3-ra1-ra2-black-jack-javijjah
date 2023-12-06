package com.hachatml.blackjack.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MainColumn(){
Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
    Botonera()
}
}
/*
@Composable
fun PintarJugador1(){

}*/
@Composable
fun Botonera(){
    val context = LocalContext.current
    Button(onClick = { dameCarta(context)}) {
        Text(text = "Dame Carta")
    }
    Button(onClick = { Plantarse()}) {
        Text(text = "Plantarse")
    }

}






/*
@Preview(showBackground = true)
@Composable
fun MainColumnPreview() {
    var VM = JvJViewModel()
    var context = LocalContext.current
    MainColumn(context,VM)
}

var partidaFinalizada = false

@Composable
fun MainColumn(context: Context,VM: JvJViewModel) {
    val jugador1 = Jugador()
    val jugador2 = Jugador()
    var ciclarCarta = true
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
            //todo añadir pintado
        }
        Text(
            text = "Jugador 2",
            modifier = Modifier.rotate(-180f),
            color = Color.White,
            fontSize = 30.sp
        )
        Row {
            Botonera(jugador1, jugador2,VM)
        }
        //todo ver cómo hacer que el texto se vea mejor
        Text(text = "Jugador 1", color = Color.White, fontSize = 30.sp)
        //cartas de j1
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
        //todo añadir pintado
        }
    }
    if (partidaFinalizada) {
        AlertDialog(
            onDismissRequest = { partidaFinalizada = false },
            confirmButton = { /*TODO*/ })//todo
    }
}
/*
@Composable
fun PintarMano(jugador: Jugador, ciclarCarta: Boolean) {
    println("PintarMano llamado")
    ciclarCarta
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
 */

//todo forzar dispositivo vertical
@Composable
fun Botonera(jugador1: Jugador, jugador2: Jugador,VM:JvJViewModel) {
    Button(onClick = {
        VM.devolverJugadorActivo(jugador1, jugador2).RobarCarta()
        VM.cambioDeTurno(jugador1, jugador2)
    }
    ) {
        Text(text = "Robar carta")
    }
    Button(onClick = {
        VM.devolverJugadorActivo(jugador1, jugador2).sePlanta()
        VM.cambioDeTurno(jugador1, jugador2)
    }) {
        Text(text = "Plantarse")
    }
}

@Composable
fun ComenzarPartida(jugador: Jugador, context: Context) {
    Baraja.crearBaraja(context)
    jugador.suTurno = true
}


@Composable
fun cuadroVictoria(puntuacionJ1: Int, puntuacionJ2: Int) {

}
*/