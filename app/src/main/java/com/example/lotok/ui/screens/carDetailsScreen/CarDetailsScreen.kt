package com.example.lotok.ui.screens.carDetailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.CarPost
import com.example.lotok.data.Data
import com.example.lotok.ui.components.carPost.Rating
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarDetailsScreen(
    carInfo : CarPost,
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
fun VehicleDetails(
    modifier: Modifier = Modifier,
    energyType : String,
    seats : Int,
    engine : String,
    type : String,
    location : String

) {
    val details = listOf(
        "Energy Type" to energyType,
        "Seats" to seats.toString(),
        "Engine" to engine,
        "Type" to type,
        "Location" to location
    )

    Column(modifier = modifier) {
        Text(
            text = "Details",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

            details.forEach { (title, value) ->
            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "$title : ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = value,
                    color = Color(0x9B, 0x9B, 0x9B),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

            }
                Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VehicleDetailsPriview(){
    VehicleDetails(
        energyType = Data.carPostsList[0].energyType,
        seats = Data.carPostsList[0].seats,
        engine = Data.carPostsList[0].engine,
        type = Data.carPostsList[0].type,
        location = Data.carPostsList[0].location
    )
}


@Composable
@Preview(showBackground = true)
fun DrawLine(modifier: Modifier = Modifier) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(10.dp)) {
        drawLine(
            color = Color.Red,
            start = Offset(x = 119.dp.toPx(), y = 5f),
            end = Offset(x = 256.dp.toPx(), y = 5f),
            strokeWidth = 12f
        )
    }
}





@Composable
fun ReviewSection(
    modifier: Modifier = Modifier,
    rating : Double ,
    numberOfReviews : Int,
    description : String ?= null

) {

    Column(
        modifier = modifier


    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Rating(stars = rating)

            Spacer(modifier = Modifier.width(5.dp))

            // Display the number of reviews
            Text(
                text = "($numberOfReviews Reviews)",
                color = Color.LightGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Display the review text

        if (description != null) {
            Text(
                text = description,
                modifier = Modifier.padding(top = 10.dp , start = 36.dp )
            )
        }
    }
}


@Composable
fun RatingBar(ratings : List<Int>,modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Reviews & Ratings",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0x1D,0x1B,0x20)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = "4.3",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 44.sp,
                    color = Color(0x22, 0x22, 0x22)
                )
                Text(
                    text = "23 ratings",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Color(0x9B, 0x9B, 0x9B)
                )
            }

            Spacer(modifier = Modifier.width(28.dp))

            Column {
                ratings.indices.reversed().forEach { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        RatingStar(starCount = index + 1, modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.width(8.dp))
                        LinearProgressIndicator(
                            progress = ratings[ratings.size - index - 1].toFloat() / ratings.maxOrNull()!!,
                            color = Color(0xFF, 0xBA, 0x49),
                            modifier = Modifier
                                .height(8.dp)
                                .width(100.dp)
                                .align(Alignment.CenterVertically)

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if ((ratings[ratings.size - index - 1])>9) ratings[ratings.size - index - 1].toString() else 0.toString()+ratings[ratings.size - index - 1].toString(),
                            fontWeight = FontWeight.Bold
                        )


                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun RatingStar(starCount: Int,modifier: Modifier ) {
    Row(horizontalArrangement = Arrangement.End) {
        repeat(starCount) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRatingBar() {
    RatingBar(listOf(12, 5, 4, 2, 0))
}

@Composable
@Preview(showBackground = true)
fun ReviewSectionPreview() {
    ReviewSection(rating = 4.5,
        numberOfReviews = 23,
        description =  Data.carPostsList[0].description
    )
}


@Composable
@Preview(showBackground = true)
fun NameAndPricePreview(){
    NameAndPrice(
        name = Data.carPostsList[0].name,
        mark = Data.carPostsList[0].mark,
        dayPrice = Data.carPostsList[0].dayPrice,
        weekPrice = Data.carPostsList[0].weekPrice
    )
}
@Composable
@Preview fun CarPicturePreview(){
    CarPicture(imgSrc = Data.carPostsList[0].imgSrc)
}




