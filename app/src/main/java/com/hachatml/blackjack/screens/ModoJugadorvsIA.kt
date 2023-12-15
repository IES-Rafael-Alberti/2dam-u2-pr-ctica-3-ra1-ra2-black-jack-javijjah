package com.hachatml.blackjack.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import com.hachatml.blackjack.Classes.Routes
import com.hachatml.blackjack.R

/**
 *Columna principal la cual contiene el resto de objetos
 */
@Composable
fun MainColumn(navController: NavController, VM: JvIAViewModel) {
    //Este contexto se utilizará para obtener los Drawables
    val context = LocalContext.current
    //Esta variable se pasa simplemente para actualizar los datos, pero no hace nada
    val cycle = true
    BackHandler {
        navController.navigate(Routes.MainMenu.route)
    }
    if (VM.Mjugador1.Mano.size == 0 && VM.IA.Mano.size == 0) {
        VM.iniciarPartida(context, navController)
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.fondo),
                contentScale = ContentScale.Crop
            )
    ) {
        PintarIA(cycle, VM)
        Botonera(cycle, navController, VM)
        PintarJugador1(cycle, VM)
    }
}

/**
 * Impresión de las cartas de la IA
 */
@Composable
fun PintarIA(cycle: Boolean, VM: JvIAViewModel) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy((-200).dp),
        modifier = Modifier.padding(20.dp)
    ) {
        items(VM.IA.Mano) {
                Image(
                    painter = painterResource(id = R.drawable.facedown),
                    contentDescription = "Carta de La IA",
                    modifier = Modifier.size(300.dp)
                )
        }
    }
}

/**
 * Botonera que da carta, permite plantarse, o muestra la posibilidad de ir a la screen de Victoria
 * si la partida se ha terminado.
 */
@Composable
fun Botonera(cycle: Boolean, navController: NavController, VM: JvIAViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Button(
                onClick = { VM.dameCarta() },
                enabled = !(VM.partidaFinalizada),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Dame Carta", color = Color.Black)
            }
            Button(
                onClick = { VM.plantarse() },
                enabled = !(VM.partidaFinalizada),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Plantarse", color = Color.Black)
            }
        }
        if (VM.partidaFinalizada) {
            Button(
                onClick = { navController.navigate(Routes.PantallaVictoriaJVJ.route) },
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Ver ganador", color = Color.Black)
            }
        }
    }
}

/**
 * Impresión del Jugador
 */
@Composable
fun PintarJugador1(cycle: Boolean, VM: JvIAViewModel) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy((-200).dp),
        modifier = Modifier.padding(20.dp)
    ) {
        items(VM.Mjugador1.Mano) {
            if (!(VM.Mjugador1.suTurno)) {
                Image(
                    painter = painterResource(id = it.idDrawable),
                    contentDescription = "Carta de La IA",
                    modifier = Modifier.size(300.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = it.idDrawable), //painter = painterResource(id = R.drawable.facedown),
                    contentDescription = "Carta de La IA",
                    modifier = Modifier.size(300.dp)
                )
            }
        }
    }
}
