package com.hachatml.blackjack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hachatml.blackjack.ui.theme.BlackJackTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hachatml.blackjack.screens.JvJViewModel
import com.hachatml.blackjack.screens.MainColumn
import com.hachatml.blackjack.Classes.Routes
import com.hachatml.blackjack.screens.TitleAndButtons
import com.hachatml.blackjack.screens.VictoryColumn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlackJackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Creamos el navController y el VM del BlackJack
                    val navController = rememberNavController()
                    val blackJackVM = JvJViewModel()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainMenu.route
                    ) {
                        composable(Routes.MainMenu.route) { TitleAndButtons(navController) }
                        composable(Routes.ModoPVP.route) { MainColumn(navController, blackJackVM) }
                        composable(Routes.PantallaVictoria.route) {
                            VictoryColumn(
                                navController,
                                blackJackVM
                            )
                        }
                    }
                }
            }
        }
    }
}
