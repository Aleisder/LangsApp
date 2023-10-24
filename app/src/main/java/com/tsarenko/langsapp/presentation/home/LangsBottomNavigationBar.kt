package com.tsarenko.langsapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun LangsBottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavigationItem.Syllabus,
        BottomNavigationItem.Chat,
        BottomNavigationItem.Profile
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    BottomAppBar() {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    Image(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

