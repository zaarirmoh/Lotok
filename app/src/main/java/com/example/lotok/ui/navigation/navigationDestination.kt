package com.example.lotok.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lotok.data.Data
import com.example.lotok.ui.components.navigationBar.MyNavigationBar
import com.example.lotok.ui.screens.homeScreen.HomeScreen
import com.example.lotok.ui.screens.profileScreen.ProfileScreen
import com.example.lotok.ui.screens.selectACarScreen.SelectACarScreen
import com.example.lotok.ui.screens.selectBrandScreen.SelectBrandScreen
import com.example.lotok.ui.screens.welcomeScreen.WelcomeScreen


// ToDo: Try to Extract the scaffold out so all the screen have like one topAppBar and one NavigationBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val expandedMenu = remember { mutableStateOf(false)}
    val openDialog = remember { mutableStateOf(false)}
    // Get the name of the current screen
    val currentScreen = LotokScreen.valueOf(
        backStackEntry?.destination?.route ?: LotokScreen.WelcomeScreen.name
    )
    Scaffold(
        /**
         * topBar = {
         *                  AllTopBars(currentScreen = currentScreen)
         *         },
         */
        bottomBar = {
            // Get current back stack entry

            if(currentScreen.hasNavigationBar) MyNavigationBar(navController = navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = LotokScreen.HomeScreen.name,
            modifier = modifier
        ) {
            composable(route = LotokScreen.WelcomeScreen.name){
                WelcomeScreen(onButtonClicked = {
                    navController.navigate(LotokScreen.HomeScreen.name)
                })
            }
            composable(route = LotokScreen.HomeScreen.name){
                HomeScreen(
                    onNotificationIconClicked = {
                    },
                    onMenuIconClicked = {
                        expandedMenu.value = true
                    },
                    onSearchForACarButtonClicked = {
                        navController.navigate(LotokScreen.SelectBrandScreen.name)
                    },
                    openDialog = openDialog,
                    expendedMenu = expandedMenu
                )
            }
            composable(route = LotokScreen.SelectACarScreen.name){
                SelectACarScreen(
                    onProfileIconClicked = {
                    },
                    onGoBackIconClicked = {
                        navController.navigateUp()
                    },
                    onHomeIconClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.SelectBrandScreen.name){
                SelectBrandScreen(
                    carBrandsList = Data.carBrandsList,
                    onGoBackIconClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.ProfileScreen.name){
                ProfileScreen(
                    onEditIconClicked = {}
                )
            }
        }
    }
}
