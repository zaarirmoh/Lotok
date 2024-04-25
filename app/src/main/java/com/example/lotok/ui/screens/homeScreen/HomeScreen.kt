package com.example.lotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.R
import com.example.lotok.ui.components.topBar.EndIconNotification
import com.example.lotok.ui.components.topBar.StartIconMenu
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterLogo
import com.example.lotok.ui.theme.md_theme_light_onPrimary


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNotificationIconClicked: () -> Unit = {},
    onMenuIconClicked: () -> Unit = {},
    onSearchForACarButtonClicked: () -> Unit = {},
) {
    val navigationBarHeight = 90
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconMenu(onButtonClicked = onMenuIconClicked) }, //StartIconMenu()
                topBarCenter = { TopBarCenterLogo()},   //TopBarCenterText(text = "Home")
                endIcon = { EndIconNotification(onButtonClicked = onNotificationIconClicked) }
            )
        }
    ){ paddingContent ->
        Column(
            modifier = modifier
                .padding(paddingContent)
                .padding(bottom = navigationBarHeight.dp)
                .verticalScroll(rememberScrollState())
        ){
            Spacer(modifier = modifier.height(11.dp))
            SearchForACar(onSearchForACarButtonClicked = onSearchForACarButtonClicked)
            Spacer(modifier = modifier.height(32.dp))
            FilterCars()
            Spacer(modifier = modifier.height(25.dp))
            Categories()
            Spacer(modifier = modifier.height(25.dp))
            PopularCars()
        }
    }
}