package com.example.lotok.ui.screens.signInUpScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInUpText(
    modifier: Modifier = Modifier,
    text: String,
    onTextClicked: () -> Unit = {},
){

    Box(
        modifier.width(200.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7D848D)
                )) {
                    append("Don't have an account ?")
                }
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )){
                    append(text)
                }
                withStyle(style = SpanStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7D848D)
                )){
                    append("Or Connect")
                }
            }
        )
    }
}