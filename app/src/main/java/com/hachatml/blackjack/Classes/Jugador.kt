package com.hachatml.blackjack.Classes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hachatml.blackjack.R
import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos

class Jugador {
    var Mano = mutableListOf<Carta>()
    var plantado: Boolean = false
    var suTurno: Boolean = false


    fun sePlanta() {
        plantado = true
    }

    fun RobarCarta() {
        Mano.add(Carta(Naipes.CUATRO, Palos.PICAS, 3, 5, R.drawable.corazones_2)) //todo ctp
    }
}
