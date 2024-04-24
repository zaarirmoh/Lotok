package com.example.lotok.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.R
import com.example.lotok.data.CarPost
import com.example.lotok.data.Data

@Composable
fun PopularCars(
    modifier: Modifier = Modifier
){
    Column{
        Text(
            text = stringResource(id = R.string.PopularCars),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = modifier.padding(start = 21.dp)
        )
        CarPosts()
    }
}
@Composable
fun CarPosts(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp),
        modifier = modifier.height((220*(Data.carPosts.size/2)).dp)
    ) {
        items(Data.carPosts){
            CarPost(carPostInfo = it)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarPost(
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

@Composable
fun Rating(
    modifier: Modifier = Modifier,
    stars: Double
){
    val integerPart = stars.toInt()
    var decimalPart = stars-integerPart
    Row(
        modifier = modifier.padding(start = 8.dp, top = 5.dp),
        horizontalArrangement = Arrangement.Start,
    ) {
        repeat(integerPart){
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier.size(19.dp)
            )
        }
        if(decimalPart!=0.0){
            Icon(
                imageVector = Icons.AutoMirrored.Default.StarHalf,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier.size(19.dp)
            )
        }
        decimalPart = Math.round(decimalPart).toDouble()
        repeat((5-integerPart-decimalPart).toInt()){
            Icon(
                imageVector = Icons.Default.StarBorder,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier.size(19.dp)
            )
        }
    }
}
@Composable
fun Favourite(
    modifier: Modifier = Modifier
){
    var isIconClicked by rememberSaveable {
        mutableStateOf(value = false)
    }
    Icon(
        imageVector = Icons.Rounded.Favorite,
        contentDescription = null,
        tint = if(isIconClicked)
                MaterialTheme.colorScheme.primary else
                MaterialTheme.colorScheme.onError,
        modifier = modifier.clickable {
            isIconClicked = !isIconClicked
        }
    )
}

@Composable
fun PricingText(
    modifier: Modifier = Modifier,
    dayPrice: String,
    weekPrice: String,
){
    Row {
        Spacer(modifier = modifier.width(10.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.primary
                    )){
                    append(dayPrice + "DZD")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 7.sp,
                        color = MaterialTheme.colorScheme.primary
                    )){
                    append("/Day")
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontWeight = FontWeight.ExtraBold
                    )
                ){
                    append("|")
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )){
                    append(weekPrice + "DZD")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 7.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )){
                    append("/Week")
                }
            }
        )

    }
}

@Composable
fun BookNowButton(
    modifier: Modifier = Modifier,
    onBookNowButtonClicked: () -> Unit
){
    Button(
        onClick = onBookNowButtonClicked,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
            .height(22.dp)
    ) {
        Text(
            text = stringResource(id = R.string.BookNow),
            fontSize = 5.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}