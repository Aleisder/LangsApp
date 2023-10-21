package com.tsarenko.langsapp.presentation.registration

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tsarenko.langsapp.R
import com.tsarenko.langsapp.ui.theme.GeologicaFontFamily
import com.tsarenko.langsapp.ui.theme.LangsAppTheme
import com.tsarenko.langsapp.util.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizeScreen(
    navController: NavController,
    state: RegistrationState,
    onEvent: (RegistrationEvent) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(30.dp)
    ) {

        Text(
            text = stringResource(id = R.string.email)
        )
        OutlinedTextField(
            value = state.email,
            onValueChange = { onEvent(RegistrationEvent.SetEmail(it)) },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))



        Button(
            onClick = {
                navController.navigate(Route.chooseLanguage)
            },
            enabled = state.isEmailValid
        ) {
            Text(text = stringResource(id = R.string.create_account))
        }

        Spacer(modifier = Modifier.weight(1f))

        DividerWithLabel(label = R.string.or)

        Spacer(modifier = Modifier.height(10.dp))

        ContinueWithOutlinedButton(
            title = R.string.continue_with_google,
            logo = R.drawable.google_logo,
            onClick = {}
        )

        Spacer(modifier = Modifier.height(10.dp))

        ContinueWithOutlinedButton(
            title = R.string.continue_with_facebook,
            logo = R.drawable.facebook_logo,
            onClick = {}
        )


    }

}

@Composable
fun DividerWithLabel(
    @StringRes label: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = stringResource(label),
            fontFamily = GeologicaFontFamily
        )
        Spacer(modifier = Modifier.width(8.dp))
        Divider(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ContinueWithOutlinedButton(
    @StringRes title: Int,
    @DrawableRes logo: Int,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)


    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = stringResource(id = title),
                fontFamily = GeologicaFontFamily

            )

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    LangsAppTheme {
        AuthorizeScreen(
            navController = rememberNavController(),
            state = RegistrationState(),
            onEvent = hiltViewModel()
        )
    }
}