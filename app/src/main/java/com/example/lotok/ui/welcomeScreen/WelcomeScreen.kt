package com.example.lotok.ui.welcomeScreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotok.R
import com.example.lotok.ui.theme.LotokTheme

@Composable
fun WelcomeScreen(
){
    val red_container_image = painterResource(id = R.drawable.red_container)
    val red_car = painterResource(id = R.drawable.red_car)
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = red_container_image,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxWidth()
                        .aspectRatio(red_container_image.intrinsicSize.width / red_container_image.intrinsicSize.height)
                )
                Column(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = red_car,
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 386.dp, height = 243.dp)
                            .offset(x = 9.dp, y = 248.dp)
                            .aspectRatio(red_car.intrinsicSize.width / red_car.intrinsicSize.height)

                    )

                }

            }

    }

}

@Preview
@Composable
 fun WelcomeScreenPreview(){
    LotokTheme {
        WelcomeScreen()
    }
    
}