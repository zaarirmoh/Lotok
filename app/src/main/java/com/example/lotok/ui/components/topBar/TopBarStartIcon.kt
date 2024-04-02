package com.example.lotok.ui.components.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.lotok.ui.theme.StartIconHomeColor

@Composable
fun StartIconMenu(onButtonClicked: () -> Unit = {}){
    IconButton(onClick = onButtonClicked) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = null,
            tint = StartIconHomeColor
        )
    }
}

@Composable
fun StartIconGoBack(){

}