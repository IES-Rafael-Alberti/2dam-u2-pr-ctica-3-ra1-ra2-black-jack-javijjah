package com.hachatml.blackjack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hachatml.blackjack.R

/**
 * Contiene el Logo principal y el botón "Jugar"
 */
@Composable
fun TitleAndButtons(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.casino),
                contentScale = ContentScale.Crop
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo del BlackJack",
            modifier = Modifier.size(300.dp).padding(50.dp)
        )
        Button(
            onClick = { navController.navigate(Routes.ModoPVP.route) },
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                androidx.compose.ui.graphics.Color.White
            ),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Jugar")
        }
    }
}