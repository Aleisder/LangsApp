package com.tsarenko.langsapp.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.tsarenko.langsapp.util.Route

sealed class BottomNavigationItem(
    val name: String,
    val route: String,
    val icon: ImageVector
) {
    object Syllabus : BottomNavigationItem(
        name = "Syllabus",
        route = Route.SYLLABUS,
        icon = Icons.Default.Home
    )

    object Chat : BottomNavigationItem(
        name = "Chat",
        route = Route.CHAT,
        icon = Icons.Default.Email
    )

    object Profile : BottomNavigationItem(
        name = "Profile",
        route = Route.PROFILE,
        icon = Icons.Default.Person
    )
}
