package com.example.lotok.ui.components.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.lotok.R
import com.example.lotok.ui.components.icons.MyAppIcons
import com.example.lotok.ui.theme.StartIconHomeColor

@Composable
fun EndIconNotification(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            imageVector = MyAppIcons.Notification,
            contentDescription = null,
            tint = StartIconHomeColor
        )
    }
}

@Composable
fun EndIconProfile(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            painter = painterResource(id = MyAppIcons.Profile),
            contentDescription = null
        )
    }
}
@Composable
fun EndIconEdit(
    onButtonClicked: () -> Unit = {}
){
    IconButton(onClick = onButtonClicked) {
        Icon(
            painter = painterResource(id = MyAppIcons.Edit),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
    }
}