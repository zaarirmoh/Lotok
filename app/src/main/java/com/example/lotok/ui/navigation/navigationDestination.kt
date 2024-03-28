package com.example.lotok.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lotok.ui.splashScreen.SplachScreen
import com.example.lotok.ui.welcomeScreen.WelcomeScreen

@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = LotokScreen.SplashScreen.name,
        modifier = modifier
    ) {
        composable(route = LotokScreen.SplashScreen.name){
            SplachScreen(navController = navController)
        }
        composable(route = LotokScreen.WelcomeScreen.name){
            WelcomeScreen()
        }
    }
}
