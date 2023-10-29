package com.tsarenko.langsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.presentation.chat.ChatScreen
import com.tsarenko.langsapp.presentation.home.HomeViewModel
import com.tsarenko.langsapp.presentation.home.LangsBottomNavigationBar
import com.tsarenko.langsapp.presentation.home.screens.SyllabusScreen
import com.tsarenko.langsapp.presentation.lesson.LessonScreen
import com.tsarenko.langsapp.presentation.lesson.LessonViewModel
import com.tsarenko.langsapp.presentation.profile.ProfileScreen
import com.tsarenko.langsapp.presentation.registration.RegistrationViewModel
import com.tsarenko.langsapp.presentation.registration.screens.AuthorizeScreen
import com.tsarenko.langsapp.presentation.registration.screens.InterestsScreen
import com.tsarenko.langsapp.presentation.registration.screens.LanguageScreen
import com.tsarenko.langsapp.presentation.registration.screens.WordsPerDayScreen
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.util.Graph
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

    val viewModel = hiltViewModel<RegistrationViewModel>()
    val registrationState by viewModel.state.collectAsState()
    val registrationOnEvent = viewModel::onEvent

    NavHost(
        navController = navController,
        startDestination = Graph.REGISTRATION
    ) {

        navigation(
            startDestination = Route.AUTHORIZATION,
            route = Graph.REGISTRATION
        ) {
            composable(route = Route.AUTHORIZATION) {
                AuthorizeScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.LANGUAGE) {
                LanguageScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.INTERESTS) {
                InterestsScreen(navController, registrationState, registrationOnEvent)
            }

            composable(route = Route.WORDS_PER_DAY) {
                WordsPerDayScreen(navController, registrationState, registrationOnEvent)
            }
        }

        composable(route = Graph.HOME) {
            HomeNavigation()
        }

    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { LangsBottomNavigationBar(navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun HomeNavGraph(navController: NavHostController) {

    val homeViewModel = hiltViewModel<HomeViewModel>()
    val homeState by homeViewModel.state.collectAsState()
    val homeOnEvent = homeViewModel::onEvent

    val lessonViewModel = hiltViewModel<LessonViewModel>()
    val lessonState by lessonViewModel.state.collectAsState()
    val lessonOnEvent = lessonViewModel::onEvent

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = Route.SYLLABUS
    ) {
        composable(route = Route.SYLLABUS) {
            SyllabusScreen(navController, homeState, homeOnEvent)
        }
        composable(route = Route.CHAT) {
            ChatScreen()
        }
        composable(route = Route.PROFILE) {
            ProfileScreen()
        }

        navigation(
            route = Graph.LESSON,
            startDestination = Route.LESSON
        ) {
            composable(route = Route.LESSON) {
                //LessonNavigation()
                LessonScreen(navController, lessonState, lessonOnEvent)
            }
        }
    }

}