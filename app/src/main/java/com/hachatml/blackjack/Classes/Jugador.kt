package com.hachatml.blackjack.Classes

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hachatml.blackjack.R
import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos

class Jugador {
    var Mano = mutableStateListOf<Carta>()
    var plantado: Boolean = false
    var suTurno: Boolean = false
    var puntacion: Int = 0
    var ganador: Boolean = false

    fun sePlanta() {
        plantado = true
    }

    fun RobarCarta() {
        if (Baraja.listaCartas.size!=0){
            Mano.add(Baraja.dameCarta())
        }
    }
    fun ultimaCarta():Carta{
        return Mano[Mano.size-1]
    }

    fun reiniciarJugador(){
        Mano.clear()
        plantado = false
        suTurno = false
        puntacion = 0
        ganador = false
    }
}
