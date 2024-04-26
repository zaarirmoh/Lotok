package com.example.lotok.ui.screens.signInUpScreens.signInScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.screens.signInUpScreens.SignInGoogleFacebook
import com.example.lotok.ui.screens.signInUpScreens.SignInUPTitle

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            Spacer(modifier = modifier.height(75.dp))
            SignInUPTitle(
                title = "Sign In Now",
                description = "Please sign in to continue to our app"
            )
            Spacer(modifier = modifier.height(50.dp))
            SignInTextFields()
            Spacer(modifier = modifier.height(10.dp))
            ForgotPasswordTextButton()
            Spacer(modifier = modifier.height(40.dp))
            SignInButton()
            Spacer(modifier = modifier.height(40.dp))
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = modifier.padding(bottom = 30.dp).fillMaxHeight()
            ) {
                SignInGoogleFacebook()
            }

        }
    }
}