package com.tsarenko.langsapp.presentation.syllabus

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.Typography

@Composable
fun SyllabusScreen() {

    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.basics),
            style = Typography.titleLarge
        )


    }


}

@Composable
fun LessonCard(lesson: Lesson) {

    Card(
        modifier = Modifier.size(110.dp, 130.dp)
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = lesson.title)

    }


    
}

@Preview
@Composable
fun LessonCardPreview() {
    LessonCard(
        lesson = Lesson(0, "Hello!", false)
    )
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