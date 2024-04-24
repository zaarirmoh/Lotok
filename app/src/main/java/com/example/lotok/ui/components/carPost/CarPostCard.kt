package com.example.lotok.ui.components.carPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.CarPost
import com.example.lotok.ui.screens.homeScreen.BookNowButton
import com.example.lotok.ui.screens.homeScreen.Favourite
import com.example.lotok.ui.screens.homeScreen.PricingText
import com.example.lotok.ui.screens.homeScreen.Rating

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarPostCard(
    modifier: Modifier = Modifier,
    carPostInfo: CarPost,
    onBookNowButtonClicked: () -> Unit = {}
){
    Card(
        modifier = modifier.size(width = 172.dp, height = 200.dp),
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = Color(0xFFDADADA))
    ) {
        Column {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(105.dp)
            ) {
                Image(
                    painter = painterResource(id = carPostInfo.imgSrc),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(105.dp)
                        .background(Color.Gray),
                    contentScale = ContentScale.Crop
                )
                Rating(stars = carPostInfo.rating)
                Favourite(modifier = modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 4.dp, top = 4.dp)
                )
            }
            Spacer(modifier = modifier.height(4.dp))
            Text(
                text = carPostInfo.mark + " " + carPostInfo.name,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = modifier.padding(start = 8.dp)
            )
            Spacer(modifier = modifier.height(3.dp))
            PricingText(
                dayPrice = carPostInfo.dayPrice.toString(),
                weekPrice = carPostInfo.weekPrice.toString()
            )
            Spacer(modifier = modifier.height(15.dp))
            BookNowButton(
                onBookNowButtonClicked = onBookNowButtonClicked
            )
        }
    }
}