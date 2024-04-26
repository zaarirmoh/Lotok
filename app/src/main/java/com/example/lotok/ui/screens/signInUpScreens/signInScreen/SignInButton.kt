package com.example.lotok.ui.screens.signInUpScreens.signInScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onSignInButtonClicked: () -> Unit = {},
){
    Button(
        onClick = onSignInButtonClicked,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .height(56.dp)
    ) {
        Text(
            text = "SignIn",
            color = MaterialTheme.colorScheme.surface
        )
    }
}