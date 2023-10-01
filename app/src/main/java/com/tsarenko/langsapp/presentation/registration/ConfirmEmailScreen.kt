package com.tsarenko.langsapp.presentation.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.ui.theme.Blue500
import com.tsarenko.langsapp.ui.theme.GeologicaFontFamily
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.ui.theme.headerStyle

@Composable
fun ConfirmEmailScreen(
    email: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.confirm_email),
            style = headerStyle
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.confirm_email_body_1))
                append(" ")
                withStyle(style = SpanStyle(color = Blue500)) {
                    append(email)
                }
                append(" ")
                append(stringResource(id = R.string.confirm_email_body_2))
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Surface(
            modifier = Modifier,
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(3.dp, Blue500)
        ) {
            Text(
                text = "4 5 _ _ _",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = GeologicaFontFamily,
                modifier = Modifier.padding(horizontal = 56.dp, vertical = 23.dp)
            )
        }

        Spacer(modifier = Modifier.height(55.dp))

        CodeKeyboard()

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Не пришло письмо?"
        )

    }

}

@Composable
fun CodeKeyboard() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            NumberButton(number = "7")
            NumberButton(number = "8")
            NumberButton(number = "9")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            NumberButton(number = "4")
            NumberButton(number = "5")
            NumberButton(number = "6")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            NumberButton(number = "1")
            NumberButton(number = "2")
            NumberButton(number = "3")
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(start = 92.dp)
        ) {
            NumberButton(number = "0")
            NumberButton(number = "<")
        }

        
    }
}

@Composable
fun NumberButton(number: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = number,
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = GeologicaFontFamily
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, locale = "RU")
fun ConfirmEmailScreenPreview() {
    LangsAppTheme() {
        ConfirmEmailScreen("example@gmail.com")
    }
}