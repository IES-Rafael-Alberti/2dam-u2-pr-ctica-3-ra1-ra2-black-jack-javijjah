package com.hachatml.blackjack

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hachatml.blackjack.ui.theme.BlackJackTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hachatml.blackjack.screens.JvJViewModel
import com.hachatml.blackjack.screens.MainColumn
import com.hachatml.blackjack.Classes.Routes
import com.hachatml.blackjack.screens.JvIAViewModel
import com.hachatml.blackjack.screens.TitleAndButtons
import com.hachatml.blackjack.screens.VictoryColumn

/**
 * La actividad principal, que genera un NavController
 */
class MainActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            BlackJackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    //Creamos el navController y el VM del BlackJack
                    val navController = rememberNavController()
                    val blackJackJVJVM = JvJViewModel()
                    val blackJackJVIAVM = JvIAViewModel()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainMenu.route
                    ) {
                        composable(Routes.MainMenu.route) { TitleAndButtons(navController) }
                        composable(Routes.ModoPVP.route) {
                            MainColumn(
                                navController,
                                blackJackJVJVM
                            )
                        }
                        composable(Routes.ModoPVIA.route) {
                            MainColumn(
                                navController,
                                blackJackJVIAVM
                            )
                        }
                        composable(Routes.PantallaVictoriaJVJ.route) {
                            VictoryColumn(
                                navController,
                                blackJackJVJVM
                            )
                        }
                        composable(Routes.PantallaVictoriaJVIA.route){
                            VictoryColumn(navController, blackJackJVIAVM)
                        }

                    }
                }
            }
        }
    }
}
