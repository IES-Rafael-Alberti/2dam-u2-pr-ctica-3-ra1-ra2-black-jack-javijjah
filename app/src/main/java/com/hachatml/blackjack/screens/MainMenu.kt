package com.hachatml.blackjack.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

    @Composable
    fun TitleAndButtons(navController: NavHostController){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(10.dp)
        ) {
            Text(text = "BLACKJACK", fontSize = 50.sp,modifier = Modifier.padding(20.dp))
            Button(onClick = { navController.navigate(Routes.ModoPVP.route) },modifier = Modifier.padding(20.dp)) {
                Text(text = "Jugador vs Jugador")
            }
            Button(onClick = { navController.navigate(Routes.ModoPVP.route) },modifier = Modifier.padding(20.dp)) {
                Text(text = "Jugador vs CPU")
            }
        }
    }