package com.hachatml.blackjack.screens

sealed class Routes(val route:String) {
    object MainMenu : Routes("MainMenu")
    object ModoPVP : Routes("ModoJugadorVsJugador")
    object PantallaVictoria : Routes("PantallaVictoria")
}