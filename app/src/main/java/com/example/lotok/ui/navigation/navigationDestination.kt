package com.example.lotok.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lotok.ui.screens.homeScreen.HomeScreen
import com.example.lotok.ui.screens.selectACarScreen.SelectACarScreen
import com.example.lotok.ui.screens.selectBrandScreen.SelectBrandScreen
import com.example.lotok.ui.screens.welcomeScreen.WelcomeScreen


// ToDo: Try to Extract the scaffold out so all the screen have like one topAppBar and one NavigationBar
@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = LotokScreen.WelcomeScreen.name,
        modifier = modifier
    ) {
        composable(route = LotokScreen.WelcomeScreen.name){
            WelcomeScreen(onButtonClicked = {
                navController.navigate(LotokScreen.HomeScreen.name)
            })
        }
        composable(route = LotokScreen.HomeScreen.name){
            HomeScreen(onNotificationIconClicked = {
                navController.navigate(LotokScreen.SelectACarScreen.name)
            })
        }
        composable(route = LotokScreen.SelectACarScreen.name){
            SelectACarScreen(
                onProfileIconClicked = {
                    navController.navigate(LotokScreen.SelectBrandScreen.name)
                },
                onGoBackIconClicked = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = LotokScreen.SelectBrandScreen.name){
            SelectBrandScreen(onGoBackIconClicked = {
                navController.navigateUp()
            })
        }
    }
}
