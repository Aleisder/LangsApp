package com.tsarenko.langsapp.presentation.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.ui.theme.Blue500
import com.tsarenko.langsapp.util.NextButton

@Composable
fun HowManyWordsPerDayScreen() {

    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.how_many_words_per_day),
        )

        Row() {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(BorderStroke(3.dp, Blue500))
            ) {
                Text(
                    text = "5",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(5.dp)
                )
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        NextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HowManyWordsPerDayScreenPreview() {
    MaterialTheme() {
        HowManyWordsPerDayScreen()
    }
}