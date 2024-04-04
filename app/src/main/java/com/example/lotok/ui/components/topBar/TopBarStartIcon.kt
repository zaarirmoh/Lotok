package com.example.lotok.ui.components.topBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotok.ui.theme.Shapes
import com.example.lotok.ui.theme.StartIconHomeColor

@Composable
fun StartIconMenu(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = null,
            tint = StartIconHomeColor,
            modifier = modifier
        )
    }
}

@Composable
fun StartIconGoBack(
){
    Card(
        shape = RoundedCornerShape(100),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F7F9)
        )
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color(0xFF1B1E28)
            )
        }
    }
}