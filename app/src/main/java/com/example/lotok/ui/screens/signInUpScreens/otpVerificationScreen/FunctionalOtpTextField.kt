package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import android.app.Activity
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp

@Composable
fun FunctionalOtpTextField(
    modifier: Modifier = Modifier,
    numberOfOtpCells: Int = 4
){
    val context = LocalContext.current
    var otpValue by remember { mutableStateOf("") }
    var isOtpFilled by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    /**
     * Right now we don't have support for Autofill in Compose.
     * See [com.appmason.jetplayground.ui.components.Autofill] for some temporary solutions.
     *
     * If we have support in the future and want user to autofill OTP from keyboard manually,
     * then we do not need to fetch OTP automatically using Google SMS Retriever API and in
     * that case, we can totally remove this [OtpReceiverEffect] and let Autofill handle it.
     * But Google SMS Retriever API is a great way anyways to fetch and populate OTP!
     */
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    /**
     * Set status bar color for this screen
     */
    (LocalView.current.context as Activity).window.statusBarColor = Color.White.toArgb()

    /**
     * OTP Screen UI starts here
     */
    OtpTextField(
        modifier = Modifier
            .padding(top = 48.dp)
            .focusRequester(focusRequester),
        otpText = otpValue,
        shouldCursorBlink = false,
        onOtpModified = { value, otpFilled ->
            otpValue = value
            isOtpFilled = otpFilled
            if (otpFilled) {
                keyboardController?.hide()
            }
        },
        otpLength = numberOfOtpCells
    )
}