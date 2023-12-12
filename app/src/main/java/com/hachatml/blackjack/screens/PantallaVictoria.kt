package com.hachatml.blackjack.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun VictoryColumn(navController: NavController) {
    Column(
        modifier = Modifier.size(200.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Puntuación del jugador 1 (Arriba):\n ${Mjugador1.puntacion} puntos", fontSize = 20.sp, textAlign = TextAlign.Center)
        Text(text = "Puntuación del jugador 2 (Abajo):\n ${Mjugador2.puntacion} puntos", fontSize = 20.sp, textAlign = TextAlign.Center)
        Text(text = imprimirGanador(), fontSize = 30.sp, textAlign = TextAlign.Center)
        Button(onClick = {
            reiniciarPartida()
            navController.navigate(Routes.ModoPVP.route)
        }) {
            Text(text = "Jugar otra vez")
        }
    }
}
