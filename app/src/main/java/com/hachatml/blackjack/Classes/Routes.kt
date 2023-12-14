package com.hachatml.blackjack.Classes

/**
 * Contiene todas las rutas del Navegador
 */
sealed class Routes(val route: String) {
    object MainMenu : Routes("MainMenu")
    object ModoPVP : Routes("ModoJugadorVsJugador")
    object PantallaVictoria : Routes("PantallaVictoria")
}