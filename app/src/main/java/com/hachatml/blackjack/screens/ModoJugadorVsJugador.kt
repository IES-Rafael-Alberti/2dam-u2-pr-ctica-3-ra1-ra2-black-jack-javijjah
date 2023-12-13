package com.hachatml.blackjack.screens

import android.graphics.drawable.shapes.Shape
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import com.hachatml.blackjack.R

/**
 *Columna principal la cual contiene el resto de objetos
 */
@Composable
fun MainColumn(navController: NavController, VM: JvJViewModel) {
    val context = LocalContext.current
    val cycle = true
    if (VM.Mjugador1.Mano.size == 0 && VM.Mjugador2.Mano.size == 0) {
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
        PintarJugador1(cycle, VM)
        Botonera(cycle, navController, VM)
        PintarJugador2(cycle, VM)
    }
}

/**
 * Impresión del jugador 2
 */
@Composable
fun PintarJugador2(cycle: Boolean, VM: JvJViewModel) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy((-200).dp),
        modifier = Modifier.padding(20.dp)
    ) {
        //todo hacer que se vea la carta de a quien le toque
        items(VM.Mjugador2.Mano) {
            if (!(VM.Mjugador2.suTurno)) {
                Image(
                    painter = painterResource(id = it.idDrawable),
                    contentDescription = "Carta de J2",
                    modifier = Modifier.size(300.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = it.idDrawable), //painter = painterResource(id = R.drawable.facedown),
                    contentDescription = "Carta de J2",
                    modifier = Modifier.size(300.dp)
                )
            }
        }
    }

}

/**
 * Botonera que da carta, permite plantarse, o muestra la posibilidad de ir a la screen de Victoria
 * si la partida se ha terminado.
 */
@Composable
fun Botonera(cycle: Boolean, navController: NavController, VM: JvJViewModel) {
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
                Text(text = "Dame Carta")
            }
            Button(
                onClick = { VM.plantarse() },
                enabled = !(VM.partidaFinalizada),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "plantarse")
            }
        }
        if (VM.partidaFinalizada) {
            Button(
                onClick = { navController.navigate(Routes.PantallaVictoria.route) },
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "Ver ganador")
            }
        }
    }
}

/**
 * Impresión del Jugador 1
 */
@Composable
fun PintarJugador1(cycle: Boolean, VM: JvJViewModel) {
    //todo hacer que se muestren cartas solo en el turno de uno
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy((-200).dp),
        modifier = Modifier.padding(20.dp)
    ) {
        items(VM.Mjugador1.Mano) {
            if (!(VM.Mjugador1.suTurno)) {
                Image(
                    painter = painterResource(id = it.idDrawable),
                    contentDescription = "Carta de J2",
                    modifier = Modifier.size(300.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = it.idDrawable), //painter = painterResource(id = R.drawable.facedown),
                    contentDescription = "Carta de J2",
                    modifier = Modifier.size(300.dp)
                )
            }
        }
    }
}

/*
Sustituido por una Screen completa
@Composable
fun pantallaVictoria(cycle: Boolean) {
if (partidaFinalizada){
    //todo que se muestre el diálogo al plantarse ambos
    AlertDialog(onDismissRequest = { partidaFinalizada = false }, text = {
        Column(
            modifier = Modifier
                .size(200.dp), verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Puntuación del jugador 1 (Arriba): ${Mjugador1.puntacion}")
            Text(text = "Puntuación del jugador 2 (Abajo): ${Mjugador2.puntacion}")
            Text(text = imprimirGanador())
        }
    }, confirmButton = {
        Button(onClick = { partidaFinalizada = false}) {
            Text(text = "Aceptar")
        }
    })
}
}
*/