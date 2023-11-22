package com.hachatml.blackjack.Classes

import android.content.Context
import android.content.res.Resources
import androidx.compose.ui.platform.LocalContext
import com.hachatml.blackjack.R
import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos

class Carta(
    var nombre: Naipes,
    var palo: Palos,
    var puntosMin: Int,
    var puntosMax: Int,
    var idDrawable: Int
) {
    //todo getDrawableResource
    companion object {
        fun getDrawableResource(naipe: Naipes, palo: Palos, context: Context): Int {
            var nombreRes = ""
            nombreRes += palo.toString().lowercase()
            nombreRes += "_"
            when (naipe) {
                Naipes.AS, Naipes.VALET, Naipes.DAME, Naipes.ROI -> {
                    nombreRes += naipe.name.lowercase()
                }

                Naipes.DOS, Naipes.TRES, Naipes.CUATRO, Naipes.CINCO, Naipes.SEIS, Naipes.SIETE, Naipes.OCHO,
                Naipes.NUEVE, Naipes.DIEZ -> {
                    nombreRes += naipe.ordinal + 1
                }
            }
            val resourceId = context.resources.getIdentifier(nombreRes, "drawable", "com.hachatml.blackjack")
            return resourceId
        }
    }
}