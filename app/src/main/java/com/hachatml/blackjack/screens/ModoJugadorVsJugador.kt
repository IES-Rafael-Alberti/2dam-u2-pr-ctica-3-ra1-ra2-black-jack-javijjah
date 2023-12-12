package com.hachatml.blackjack.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.hachatml.blackjack.R

@Composable
fun MainColumn(navController: NavController) {
    val context = LocalContext.current
    val cycle = true
    if (Mjugador1.Mano.size == 0 && Mjugador2.Mano.size == 0)
        iniciarPartida(context, navController)
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(50.dp)
    ) {
        PintarJugador1(cycle)
        Botonera(cycle, navController)
        PintarJugador2(cycle)
    }
}

@Composable
fun PintarJugador2(cycle: Boolean) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy((-200).dp)) {
        //todo hacer que se vea la carta de a quien le toque
        items(Mjugador2.Mano) {
            if (!(Mjugador2.suTurno)) {
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

@Composable
fun Botonera(cycle: Boolean, navController: NavController) {
    Row {
        Button(onClick = { dameCarta() }) {
            Text(text = "Dame Carta")
        }
        Button(onClick = { plantarse() }) {
            Text(text = "plantarse")
        }
        if (partidaFinalizada) {
            Button(onClick = { navController.navigate(Routes.PantallaVictoria.route) }) {
                Text(text = "Ver ganador")
            }
        }
    }
}

@Composable
fun PintarJugador1(cycle: Boolean) {
    //todo hacer que se muestren cartas solo en el turno de uno
    LazyRow(horizontalArrangement = Arrangement.spacedBy((-200).dp)) {
        items(Mjugador1.Mano) {
            if (!(Mjugador1.suTurno)) {
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
@Composable
fun mostrarToast(msj: String) {
    Toast.makeText(LocalContext.current, msj, Toast.LENGTH_SHORT).show()
}
