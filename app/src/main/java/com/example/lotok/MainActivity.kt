package com.example.lotok

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.lotok.ui.navigation.LotokNavHost
import com.example.lotok.ui.navigation.LotokScreen
import com.example.lotok.ui.theme.LotokTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val SHOW_WELCOME_SCREEN = booleanPreferencesKey("show_welcome_screen")

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
                    var moh by remember {
                        mutableStateOf(true)
                    }
                    var isLaunchedEffectFinished by remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        lifecycleScope.launch{
                            val preferences = dataStore.data.first()
                            moh = preferences[SHOW_WELCOME_SCREEN] ?: false
                            isLaunchedEffectFinished = true
                        }
                    }
                    if (isLaunchedEffectFinished){
                        LotokNavHost(
                            showWelcomeScreen = moh,
                            onWelcomeScreenButtonClicked = {
                                lifecycleScope.launch{
                                    dataStore.edit { settings ->
                                        settings[SHOW_WELCOME_SCREEN] = true
                                    }
                                    moh = true
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}

