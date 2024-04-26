package com.example.lotok.ui.screens.carDetailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.CarPost
import com.example.lotok.data.Data
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarDetailsScreen(
    carInfo : CarPost ,
    onGoBackIconClicked: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) },
                topBarCenter = { TopBarCenterText(text = "Car Details") },
                endIcon = { EndIconProfile() }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier ,
            contentPadding = it
        ) {


        }
    }

}
@Composable
fun CarPicture(modifier : Modifier = Modifier, imgSrc : List<Int> ){
    var currentPosition by remember { mutableIntStateOf(0) }
    val maxPosition = imgSrc.size

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(224.dp)) {
        Image(
            painter = painterResource(id = imgSrc[currentPosition]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
            modifier = Modifier
                .height(36.dp)
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp)
                .align(alignment = Alignment.BottomCenter)
        ) {
            Text( text = "Book", fontSize = 18.sp , color = Color.White   , fontWeight = FontWeight.Bold  )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(
                onClick = { if (currentPosition > 0) currentPosition-- },
                enabled = currentPosition > 0 ,
                modifier = Modifier
                    .size(40.dp)


            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    modifier = Modifier.fillMaxSize(),
                    tint = if (currentPosition > 0) Color.White else Color.Gray
                )
            }

            IconButton(
                onClick = { if (currentPosition < maxPosition) currentPosition++ },
                enabled = currentPosition < maxPosition-1 ,
                modifier = Modifier
                    .size(40.dp)

            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Next",
                    modifier = Modifier.fillMaxSize(),
                    tint = if(currentPosition < maxPosition-1 ) Color.White else Color.Gray
                )
            }
        }
    }
}


@Composable
fun NameAndPrice(
    modifier : Modifier = Modifier,
    name : String,
    mark : String,
    dayPrice : Int ,
    weekPrice :Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text =  dayPrice.toString() + " DZA/day",
                color = Color.Red,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = mark,
                color = Color(0x9B, 0x9B, 0x9B),
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text =  weekPrice.toString() + " DZA/week",
                color = Color.Red,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}





@Composable
fun StarRating(stars: List<Int>) {
    val totalStars = stars.sum()
    val averageRating = totalStars.toFloat() / stars.size
    val filledStars = averageRating.toInt()
    val fraction = averageRating - filledStars

    // Draw 5 stars
    Row {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(24.dp)
            )
        }
        if (fraction > 0f){
            if (fraction >= 0.5f) {
                Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.size(24.dp)
            )
            }
            else {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        repeat(5 - filledStars - if (fraction > 0f) 1 else 0) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Preview
@Composable
fun PreviewStarRating() {
    StarRating(stars = listOf(5, 1, 2, 5))
}


@Composable
@Preview(showBackground = true)
fun NameAndPricePreview(){
    NameAndPrice(
        name = Data.carPostsList[0].model,
        mark = Data.carPostsList[0].make,
        dayPrice = Data.carPostsList[0].dayPrice,
        weekPrice = Data.carPostsList[0].weekPrice
    )
}
@Composable
@Preview fun CarPicturePreview(){
    CarPicture(imgSrc = Data.carPostsList[0].imgSrc)
}
