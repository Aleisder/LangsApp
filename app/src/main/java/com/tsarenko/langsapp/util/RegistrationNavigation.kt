package com.tsarenko.langsapp.util

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.tsarenko.langsapp.presentation.registration.AuthorizeScreen
import com.tsarenko.langsapp.presentation.registration.InterestsScreen
import com.tsarenko.langsapp.presentation.registration.LanguageScreen
import com.tsarenko.langsapp.presentation.registration.RegistrationEvent
import com.tsarenko.langsapp.presentation.registration.RegistrationState
import com.tsarenko.langsapp.presentation.registration.WordsPerDayScreen

fun NavGraphBuilder.registrationGraph(
    navController: NavHostController,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {
    navigation(
        startDestination = Route.AUTHORIZATION,
        route = Graph.REGISTRATION
    ) {
        composable(route = Route.AUTHORIZATION) {
            AuthorizeScreen(navController, state, onEvent)
        }

        composable(route = Route.LANGUAGE) {
            LanguageScreen(navController, state, onEvent)
        }

        composable(route = Route.INTERESTS) {
            InterestsScreen(navController, state, onEvent)
        }

        composable(route = Route.WORDS_PER_DAY) {
            WordsPerDayScreen(navController, state, onEvent)
        }
    }
}