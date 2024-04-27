package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OTPVerificationScreen(
    modifier: Modifier = Modifier
){
    val otpVal: String? = null
    OTPVerificationTextFields {
        otpVal
    }
}