package com.tsarenko.langsapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.domain.model.Lesson
import com.tsarenko.langsapp.ui.theme.Montserrat
import com.tsarenko.langsapp.util.Route

@Composable
fun LessonCard(
    lesson: Lesson,
    navController: NavController
) {
    Card(
        modifier = Modifier.size(110.dp, 130.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Route.LESSON)
                    }
            ) {
                Image(
                    painter = painterResource(R.drawable.hello_lesson_preview),
                    contentDescription = null
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = lesson.title,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }

            if (lesson.isDone) {
                Image(
                    painter = painterResource(id = R.drawable.icon_done),
                    contentDescription = "You passed this lesson"
                )
            }
        }
    }
}

@Preview
@Composable
fun LessonCardPreview() {
    LessonCard(
        lesson = Lesson(0, "Hello", "R.drawable.hello_lesson_preview", isDone = true),
        navController = rememberNavController()
    )
}