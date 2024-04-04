package com.example.lotok.ui.components.topBar

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.R

@Composable
fun TopBarCenterText(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TopBarCenterLogo(
    @DrawableRes imgSrc: Int,
    modifier: Modifier = Modifier
){
    Icon(
        painter = painterResource(id = imgSrc),
        contentDescription = null,
        modifier = modifier.scale(1.9F)
    )
}