package com.tsarenko.langsapp.presentation.syllabus

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsarenko.langsapp.ui.theme.LangsAppTheme

@Composable
fun SyllabusScreen() {

    val chapters = List(20) {
        Chapter(
            1,
            "Greetings",
            listOf(
                Lesson(1, "Halo!"),
                Lesson(2, "How are you doing?")
            )
        )
    }

    LazyColumn(
        modifier = Modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(chapters) { chapter ->
            var isExpanded by remember { mutableStateOf(false) }
            ChapterForm(
                chapter = chapter,
                onClick = { isExpanded = !isExpanded },
                isExpanded = isExpanded
            )

        }
    }


}

@Composable
fun ChapterForm(
    chapter: Chapter,
    onClick: () -> Unit,
    isExpanded: Boolean = false
) {
    Card(modifier = Modifier.padding(3.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = chapter.number.toString())
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
            )
            Text(text = chapter.title)
            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
        }
        AnimatedVisibility(
            visible = isExpanded
        ) {
            LazyColumn() {
                items(chapter.lessons) { lesson ->
                    LessonForm(lesson = lesson)
                }
            }
        }
    }
}

@Composable
fun LessonForm(
    lesson: Lesson
) {
    Card() {
        Text(text = lesson.title)
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SyllabusScreenPreview() {
    LangsAppTheme {
        SyllabusScreen()
    }
}