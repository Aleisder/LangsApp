package com.tsarenko.langsapp.presentation.lesson.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tsarenko.langsapp.domain.model.LessonUnit
import com.tsarenko.langsapp.util.HorizontalSpacer
import com.tsarenko.langsapp.util.NextButton
import com.tsarenko.langsapp.util.VerticalSpacer

@Composable
fun QuestionUnitContent(
    questionUnit: LessonUnit.QuestionUnit,
    modifier: Modifier = Modifier
) {
    val isNextButtonShown by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = questionUnit.question,
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )

        VerticalSpacer(10)

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            AnswerButton(questionUnit.answers[0])
            HorizontalSpacer(10)
            AnswerButton(questionUnit.answers[1])
        }

        VerticalSpacer(height = 10)

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            AnswerButton(questionUnit.answers[2])
            HorizontalSpacer(10)
            AnswerButton(questionUnit.answers[3])
        }

        Spacer(modifier = Modifier.weight(1f))

        AnimatedVisibility(visible = isNextButtonShown) {
            NextButton(
                onClick = { /*TODO*/ },
                enabled = true
            )
        }
    }
}

@Composable
fun AnswerButton(
    value: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Gray)
            .clickable {

            }
    ) {
        Text(
            text = value,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(20.dp)
        )
    }
}