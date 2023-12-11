package com.hachatml.blackjack.Classes

import android.content.Context
import com.hachatml.cartamasalta.enums.Naipes
import com.hachatml.cartamasalta.enums.Palos

class Baraja {
    companion object {
        var listaCartas = ArrayList<Carta>()
        fun crearBaraja(context: Context) {
            for (palo in Palos.values()) {
                for (naipe in Naipes.values()) {
                    val pointsMin: Int
                    val pointsMax: Int
                    val idDrawable: Int
                    when (naipe) {
                        Naipes.AS -> {
                            pointsMin = 1
                            pointsMax = 11
                        }

                        Naipes.DOS, Naipes.TRES, Naipes.CUATRO, Naipes.CINCO, Naipes.SEIS,
                        Naipes.SIETE, Naipes.OCHO, Naipes.NUEVE, Naipes.DIEZ -> {
                            pointsMin = naipe.ordinal + 1
                            pointsMax = naipe.ordinal + 1
                        }

                        else -> {
                            pointsMin = 10
                            pointsMax = 10
                        }
                    }
                    idDrawable = Carta.getDrawableResource(naipe, palo, context)
                    val cartaTemp = Carta(naipe, palo, pointsMin, pointsMax, idDrawable)
                    listaCartas.add(cartaTemp)
                }
            }
            barajar()
        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun resetearBaraja(context: Context) {
            listaCartas.clear()
            crearBaraja(context)
        }

        fun dameCarta(): Carta {
            var ultimaCarta = listaCartas.get(listaCartas.size - 1)
            listaCartas.remove(ultimaCarta)
            return ultimaCarta
        }

    }
}