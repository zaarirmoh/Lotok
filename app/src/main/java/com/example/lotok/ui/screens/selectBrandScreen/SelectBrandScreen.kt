package com.example.lotok.ui.screens.selectBrandScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectBrandScreen(
    onGoBackIconClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) }, //StartIconMenu()
                topBarCenter = { TopBarCenterText(text = "Choose a brand") },   //TopBarCenterText(text = "Home")
                endIcon = { EndIconProfile() }
            )
        }
    ) {

    }
}