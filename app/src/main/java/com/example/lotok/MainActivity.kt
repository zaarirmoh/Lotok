package com.example.lotok

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lotok.ui.navigation.LotokNavHost
import com.example.lotok.ui.navigation.LotokScreen
import com.example.lotok.ui.screens.welcomeScreen.WelcomeScreenViewModel
import com.example.lotok.ui.theme.LotokTheme

val dessertReleaseViewModel: WelcomeScreenViewModel
    @Composable
    get() = viewModel(
        factory = WelcomeScreenViewModel.Factory
    )
val startDestination: String
    @SuppressLint("StateFlowValueCalledInComposition") @Composable
    get() = if (dessertReleaseViewModel.uiState.value) {
        LotokScreen.WelcomeScreen.name
    } else LotokScreen.HomeScreen.name

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LotokTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LotokNavHost(
                        startDestination = LotokScreen.HomeScreen.name,
                        welcomeScreenViewModel = dessertReleaseViewModel
                    )
                }
            }
        }
    }
}

