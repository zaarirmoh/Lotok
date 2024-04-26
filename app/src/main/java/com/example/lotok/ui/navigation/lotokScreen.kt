package com.example.lotok.ui.navigation

import androidx.compose.runtime.Composable
import com.example.lotok.R

enum class LotokScreen(
    val hasNavigationBar: Boolean,
    //val topBarType: Int = 0
) {
    WelcomeScreen(false),
    HomeScreen(true),//R.string.TopBarMenuLogoNotification
    SelectACarScreen(false),//R.string.TopBarGoBackTextProfile
    SelectBrandScreen(false),
    ProfileScreen(true),
    MainSettingsScreen(false),
    ProfileDetailsScreen(false),
    EditProfileScreen(false),
    SignInScreen(false)
}