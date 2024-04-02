package com.example.lotok.ui.components.topBar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TopBarCenterText(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Bold
    )
}