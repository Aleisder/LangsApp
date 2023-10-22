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
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.presentation.home.HomeViewModel
import com.tsarenko.langsapp.presentation.home.SyllabusScreen
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
    val registrationState by registrationViewModel.state.collectAsState()
    val registrationOnEvent = registrationViewModel::onEvent

    val homeViewModel = hiltViewModel<HomeViewModel>()
    val homeState by homeViewModel.state.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Route.Feature.registration
    ) {
        navigation(
            startDestination = Route.Screen.authorization,
            route = Route.Feature.registration
        ) {
            composable(route = Route.Screen.authorization) {
                AuthorizeScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.Screen.language) {
                LanguageScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.Screen.interests) {
                InterestsScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.Screen.wordsPerDay) {
                WordsPerDayScreen(navController, registrationState)
            }
        }

        navigation(
            startDestination = Route.Screen.syllabus,
            route = Route.Feature.home
        ) {
            composable(route = Route.Screen.syllabus) {
                SyllabusScreen(navController, homeState)
            }
        }


    }

}