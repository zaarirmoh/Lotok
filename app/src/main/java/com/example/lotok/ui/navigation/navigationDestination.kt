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
import com.example.lotok.data.profileInformation
import com.example.lotok.ui.components.navigationBar.MyNavigationBar
import com.example.lotok.ui.screens.carDetailsScreen.CarDetailsScreen
import com.example.lotok.ui.screens.homeScreen.HomeScreen
import com.example.lotok.ui.screens.profileDetailsScreens.editProfileScreen.EditProfileScreen
import com.example.lotok.ui.screens.profileDetailsScreens.profileDetailsScreen.ProfileDetailsScreen
import com.example.lotok.ui.screens.profileScreen.ProfileScreen
import com.example.lotok.ui.screens.selectACarScreen.SelectACarScreen
import com.example.lotok.ui.screens.selectBrandScreen.SelectBrandScreen
import com.example.lotok.ui.screens.settingsScreens.mainSettingsScreen.MainSettingsScreen
import com.example.lotok.ui.screens.signInUpScreens.forgotPasswordScreen.ForgotPasswordScreen
import com.example.lotok.ui.screens.signInUpScreens.otpVerificationScreen.OtpVerificationScreen
import com.example.lotok.ui.screens.signInUpScreens.signInScreen.SignInScreen
import com.example.lotok.ui.screens.signInUpScreens.singUpScreen.SignUpScreen
import com.example.lotok.ui.screens.welcomeScreen.WelcomeScreen
import com.example.lotok.ui.screens.welcomeScreen.WelcomeScreenViewModel


// ToDo: Try to Extract the scaffold out so all the screen have like one topAppBar and one NavigationBar
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LotokNavHost(
    modifier: Modifier = Modifier,
    startDestination :String = LotokScreen.HomeScreen.name,
    welcomeScreenViewModel: WelcomeScreenViewModel,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val expandedMenu = remember { mutableStateOf(false)}
    val openDialog = remember { mutableStateOf(false)}
    val newFirstName = remember { mutableStateOf(profileInformation.firstName) }
    val newLastName = remember{ mutableStateOf(profileInformation.lastName) }
    val newEmail = remember { mutableStateOf(profileInformation.email) }
    val newLocation = remember { mutableStateOf(profileInformation.location) }
    val newMobileNumber = remember { mutableStateOf(profileInformation.mobileNumber) }
    // Get the name of the current screen
    val currentScreen = LotokScreen.valueOf(
        backStackEntry?.destination?.route ?: LotokScreen.HomeScreen.name
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
            startDestination = startDestination ,
            modifier = modifier
        ) {
            composable(route = LotokScreen.WelcomeScreen.name){
                WelcomeScreen(onButtonClicked = {
                    welcomeScreenViewModel.selectLayout(false)
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
                    onSettingsClicked = {
                        expandedMenu.value = false
                        navController.navigate(LotokScreen.MainSettingsScreen.name)
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
                    },
                    onLogoClicked ={ navController.navigate(LotokScreen.CarDetailsScreen.name)}
                )
            }
            composable(route = LotokScreen.ProfileScreen.name){
                ProfileScreen(
                    onEditIconClicked = {},
                    onProfileCardClicked = {
                        navController.navigate(LotokScreen.ProfileDetailsScreen.name)
                    },
                    onCarsPostedCardClicked = {},
                    onSettingsCardClicked = {
                        navController.navigate(LotokScreen.MainSettingsScreen.name)
                    },
                    onVersionCardClicked = {},
                )
            }
            composable(route = LotokScreen.MainSettingsScreen.name){
                MainSettingsScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.ProfileDetailsScreen.name){
                ProfileDetailsScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    },
                    onEditButtonClicked = {
                        navController.navigate(LotokScreen.EditProfileScreen.name)
                    }
                )
            }
            composable(route = LotokScreen.EditProfileScreen.name){
                EditProfileScreen(
                    onGoBackButtonClicked = {
                        newFirstName.value = profileInformation.firstName
                        newLastName.value = profileInformation.lastName
                        newEmail.value = profileInformation.email
                        newLocation.value = profileInformation.location
                        newMobileNumber.value = profileInformation.mobileNumber
                        navController.navigateUp()
                    },
                    onDoneButtonClicked = {
                        profileInformation.firstName = newFirstName.value
                        profileInformation.lastName = newLastName.value
                        profileInformation.email = newEmail.value
                        profileInformation.location = newLocation.value
                        profileInformation.mobileNumber = newMobileNumber.value
                        navController.navigateUp()
                    },
                    newFirstName = newFirstName,
                    newLastName = newLastName,
                    newEmail = newEmail,
                    newLocation = newLocation,
                    newMobileNumber = newMobileNumber
                )
            }
            composable(route = LotokScreen.SignInScreen.name){
                SignInScreen(
                    onSignInTextClicked = {
                        navController.navigate(LotokScreen.SignUpScreen.name)
                    },
                    onForgotPasswordTextClicked = {
                        navController.navigate(LotokScreen.ForgotPasswordScreen.name)
                    },
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.SignUpScreen.name){
                SignUpScreen(
                    onSignUPTextClicked = {
                        navController.navigate(LotokScreen.SignInScreen.name)
                    },
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    }
                )
            }
            composable(route = LotokScreen.ForgotPasswordScreen.name){
                ForgotPasswordScreen(
                    onGoBackButtonClicked = {
                        navController.navigateUp()
                    },
                    onForgotPasswordButtonClicked = {
                        navController.navigate(LotokScreen.OtpVerificationScreen.name)
                    }
                )
            }
            composable(route = LotokScreen.OtpVerificationScreen.name){
                OtpVerificationScreen()
            }
            composable(route = LotokScreen.CarDetailsScreen.name){
                 CarDetailsScreen(Data.carPostsList[0])
            }
        }
    }
}
