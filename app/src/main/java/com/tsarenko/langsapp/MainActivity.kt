package com.tsarenko.langsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.presentation.registration.ChooseHowToAuthorizeScreen
import com.tsarenko.langsapp.presentation.registration.ChooseLanguageScreen
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LangsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LangsAppNavigation()
                }
            }
        }
    }
}

@Composable
fun LangsAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.chooseHowToAuthorize
    ) {
        composable(route = Route.chooseHowToAuthorize) {
            ChooseHowToAuthorizeScreen()
        }
        composable(route = Route.chooseLanguage) {
            ChooseLanguageScreen()
        }
        composable(route = Route.chooseYourInterests) {

        }

    }

}