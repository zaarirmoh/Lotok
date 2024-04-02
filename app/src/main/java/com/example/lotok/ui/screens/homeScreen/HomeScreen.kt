package com.example.lotok.ui.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lotok.ui.components.topBar.EndIconNotification
import com.example.lotok.ui.components.topBar.StartIconMenu
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconMenu() },
                topBarCenter = { TopBarCenterText(text = "Home") },
                endIcon = { EndIconNotification() }
            )
        }
    ) {

    }
}