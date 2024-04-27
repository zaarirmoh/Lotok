package com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun OTPVerificationScreen(
    modifier: Modifier = Modifier,
    numberOfOtpCells: Int = 6
){
    val trying = remember { mutableStateOf("")}
    Surface() {
        BasicTextField(
            value = trying.value,
            onValueChange = {trying.value = it}
        ){
            Row(
            ) {
                repeat(numberOfOtpCells){

                }
            }
        }
    }

}