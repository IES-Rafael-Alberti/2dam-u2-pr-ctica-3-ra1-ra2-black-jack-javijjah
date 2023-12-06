package com.hachatml.blackjack.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.hachatml.blackjack.R
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog

@Composable
fun MainColumn() {
    val context = LocalContext.current
    if (Mjugador1.Mano.size==0&& Mjugador2.Mano.size==0)
    iniciarPartida(context)
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(50.dp)
    ) {
        val cycle = true
        if (partidaFinalizada){
            Dialog(onDismissRequest = { partidaFinalizada=false }, content = {
                Column(modifier = Modifier
                    .background(Color.White)
                    .size(200.dp), verticalArrangement = Arrangement.SpaceEvenly){
                    Text(text = "Puntuación del jugador 1: ${Mjugador1.puntacion}")
                    Text(text = "Puntuación del jugador 2: ${Mjugador2.puntacion}")
                    Text(text = imprimirGanador())
                }
            })
        }
        PintarJugador1(cycle)
        Botonera()
        PintarJugador2(cycle)
    }
}

@Composable
fun PintarJugador2(cycle:Boolean) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(-200.dp)) {
        //todo hacer que se vea la carta de a quien le toque
        if (Mjugador2.suTurno){
            items(Mjugador2.Mano){
                Image(painter = painterResource(id = it.idDrawable), contentDescription ="Carta de J2",modifier = Modifier.size(300.dp))
            }
        }
        else{
            items(Mjugador2.Mano){
                Image(painter = painterResource(id = R.drawable.facedown), contentDescription ="Carta de J2",modifier = Modifier.size(300.dp))
            }
        }
    }

}

@Composable
fun Botonera() {
    Row {
        Button(onClick = { dameCarta() }) {
            Text(text = "Dame Carta")
        }
        Button(onClick = { Plantarse() }) {
            Text(text = "Plantarse")
        }
    }
}

@Composable
fun PintarJugador1(cycle:Boolean) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(-200.dp)) {
        if (Mjugador1.suTurno){
        items(Mjugador1.Mano){
            Image(painter = painterResource(id = it.idDrawable), contentDescription ="Carta de J1",modifier = Modifier.size(300.dp))
        }
        }
            else{
                items(Mjugador1.Mano){
                    Image(painter = painterResource(id = R.drawable.facedown), contentDescription ="Carta de J1",modifier = Modifier.size(300.dp))
            }
        }
    }
}
@Composable
fun mostrarToast(msj:String){
    Toast.makeText(LocalContext.current, msj, Toast.LENGTH_SHORT).show()
}
