package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.screens.signInUpScreens.signInScreen.SignInTextFields
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInGoogleFacebook
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUPTitle
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpButton
import com.example.lotok.ui.screens.signInUpScreens.signInUpComponents.SignInUpText


@Composable
fun OtpVerificationScreen(
    modifier: Modifier = Modifier,
    onGoBackButtonClicked: () -> Unit = {},
    onVerifyButtonClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackButtonClicked) }
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = modifier.height(65.dp))
            SignInUPTitle(
                title = "OTP Verification",
                description = "Please check your email www.uihut@gmail.com to see the verification code"
            )
            Spacer(modifier = modifier.height(50.dp))
            OtpCode()
            Spacer(modifier = modifier.height(40.dp))
            SignInUpButton(text = "Verify")
        }
    }
}
