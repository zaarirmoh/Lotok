package com.example.lotok.ui.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lotok.R
import com.example.lotok.ui.navigation.LotokScreen
import com.example.lotok.ui.theme.RedBackground
import kotlinx.coroutines.delay


@Composable
fun SplachScreen(
    modifier: Modifier = Modifier,
    delayTime: Long = 1500L,
    navController: NavController
) {
    LaunchedEffect(key1 = true) {
        delay(delayTime)
        navController.navigate(LotokScreen.WelcomeScreen.name)
    }
    Surface(
        color = RedBackground
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = modifier.height(320.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_without_backround_2),
                contentDescription = null,
                modifier = modifier
                    .height(101.dp)
                    .width(315.dp)
            )
            Spacer(modifier = modifier.height(223.dp))
            CircularProgressIndicator(
                color = Color(android.graphics.Color.BLACK),
                modifier = modifier
                    .height(48.dp)
                    .width(48.dp)
            )
        }
    }
}

@Preview
@Composable
fun SplachScreenPreview(){

}