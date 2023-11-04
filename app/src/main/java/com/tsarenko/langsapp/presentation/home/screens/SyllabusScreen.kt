package com.tsarenko.langsapp.presentation.home.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Chapter
import com.tsarenko.langsapp.presentation.home.HomeEvent
import com.tsarenko.langsapp.presentation.home.HomeState
import com.tsarenko.langsapp.presentation.home.components.LessonCard
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Typography
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun SyllabusScreen(
    navController: NavController,
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {
    Column() {
        Surface(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                state.syllabus.chapters.forEach {
                    ChapterTab(
                        chapter = it,
                        navController = navController
                    )
                    VerticalSpacer(20)
                }
            }

        }
    }
}

@Composable
fun ChapterTab(
    chapter: Chapter,
    navController: NavController
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = chapter.title,
                style = Typography.titleLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.view_all),
                modifier = Modifier.clickable {
                    // TODO: implement screen with expanded lessons list
                }
            )
        }

        VerticalSpacer(10)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chapter.lessons) {
                LessonCard(
                    lesson = it,
                    navController = navController
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SyllabusScreenPreview() {
    LangsAppTheme {
        SyllabusScreen(
            navController = rememberNavController(),
            state = HomeState(),
            onEvent = {}
        )
    }
}