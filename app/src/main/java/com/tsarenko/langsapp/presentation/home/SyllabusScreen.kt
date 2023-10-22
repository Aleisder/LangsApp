package com.tsarenko.langsapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Lesson
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.ui.theme.Typography

@Composable
fun SyllabusScreen(
    navController: NavController,
    state: HomeState
) {
    Column() {
        Surface(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.basics),
                    style = Typography.titleLarge
                )
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    modifier = Modifier.height(280.dp)
                ) {
                    items(state.chapters[0].lessons) {
                        LessonCard(it)
                    }
                }
            }

        }
    }


}

@Composable
fun LessonCard(lesson: Lesson) {
    Card(
        modifier = Modifier.size(110.dp, 130.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(painterResource(R.drawable.hello_lesson_preview), contentDescription = null)
            Spacer(Modifier.weight(1f))
            Text(
                text = lesson.title,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SyllabusScreenPreview() {
    LangsAppTheme {
        SyllabusScreen(
            navController = rememberNavController(),
            state = HomeState()
        )
    }
}