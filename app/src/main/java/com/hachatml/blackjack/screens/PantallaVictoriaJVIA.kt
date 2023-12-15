package com.hachatml.blackjack.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hachatml.blackjack.Classes.Routes
import com.hachatml.blackjack.R

/**
 * Columna principal de la Screen PantallaVictoriaJVJ
 */
@Composable
fun VictoryColumn(navController: NavController, VM: JvIAViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.victory),
                contentScale = ContentScale.Crop
            ),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = VM.imprimirGanador(),
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            lineHeight = 50.sp, color = Color.White
        )
        Text(
            text = "Puntuación de la IA (Arriba):\n ${VM.IA.puntacion} puntos",
            fontSize = 20.sp,
            textAlign = TextAlign.Center, color = Color.White
        )
        Text(text = "Baraja de la IA", fontSize = 15.sp, textAlign = TextAlign.Center)
        LazyRow(horizontalArrangement = Arrangement.Center) {
            items(VM.IA.Mano) {
                Image(
                    painter = painterResource(id = it.idDrawable),
                    contentDescription = "Carta de la IA",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
        Text(
            text = "Puntuación del Jugador (Abajo):\n ${VM.Mjugador1.puntacion} puntos",
            fontSize = 20.sp,
            textAlign = TextAlign.Center, color = Color.White
        )
        Text(text = "Baraja de J1", fontSize = 15.sp, textAlign = TextAlign.Center, color = Color.White)
        LazyRow(horizontalArrangement = Arrangement.Center) {
            items(VM.Mjugador1.Mano) {
                Image(
                    painter = painterResource(id = it.idDrawable),
                    contentDescription = "Carta de J1",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
        Button(
            onClick = {
                VM.reiniciarPartida()
                navController.navigate(Routes.ModoPVIA.route)
            },
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Jugar otra vez", color = Color.Black)
        }
    }
}