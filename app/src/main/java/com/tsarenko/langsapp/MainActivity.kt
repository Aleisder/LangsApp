package com.tsarenko.langsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.presentation.registration.AuthorizeScreen
import com.tsarenko.langsapp.presentation.registration.InterestsScreen
import com.tsarenko.langsapp.presentation.registration.LanguageScreen
import com.tsarenko.langsapp.presentation.registration.RegistrationViewModel
import com.tsarenko.langsapp.presentation.registration.WordsPerDayScreen
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
    val registrationViewModel = hiltViewModel<RegistrationViewModel>()
    val state by registrationViewModel.state.collectAsState()
    val onEvent = registrationViewModel::onEvent

    NavHost(
        navController = navController,
        startDestination = Route.authorization
    ) {
        composable(route = Route.authorization) {
            AuthorizeScreen(navController, state, onEvent)
        }

        composable(route = Route.language) {
            LanguageScreen(navController, state, onEvent)
        }

        composable(route = Route.interests) {
            InterestsScreen(navController, state, onEvent)
        }

        composable(route = Route.wordsPerDay) {
            WordsPerDayScreen(navController, state)
        }

    }

}