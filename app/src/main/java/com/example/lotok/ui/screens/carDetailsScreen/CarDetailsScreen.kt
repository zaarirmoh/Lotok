package com.example.lotok.ui.screens.carDetailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.model.CarPost
import com.example.lotok.model.Data
import com.example.lotok.ui.components.carPost.CommentCard
import com.example.lotok.ui.components.lines.SimpleLine
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarDetailsScreen(
    carPost : CarPost,
    onGoBackIconClicked: () -> Unit = {},
    bookButtonClicked : () -> Unit = {}
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
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            var showMore  by remember { mutableStateOf(true) }
            val showText = if (showMore) "show More" else "show less"
            CarPictures(
                imgSrc = carPost.imgSrc,
                modifier = Modifier.fillMaxWidth(),
                onButtonClicked = bookButtonClicked

            )

            ClickableText(
                text = "Check availability here ? " ,
                onClick = {  },
                modifier = Modifier.padding(start = 22.dp , top = 13.dp)
            )

            NameAndPrice(
                modifier = Modifier.padding(start = 11.dp , end = 11.dp , top = 30.dp),
                name = carPost.model,
                mark = carPost.make,
                dayPrice = carPost.dayPrice,
                weekPrice = carPost.weekPrice
            )

            ReviewSection(
                modifier = Modifier.padding(start = 11.dp,end = 11.dp,top = 6.dp),
                rating = carPost.rating,
                numberOfReviews = 23,
                description =  carPost.description
            )

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            Details(
                modifier =Modifier.padding(top =21.dp, start = 11.dp , end = 30.dp),
                energyType = carPost.fuel,
                seats = carPost.power,
                engine = carPost.engine,
                type = carPost.transmission,
                location = carPost.location
            )

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            RatingBar(
                modifier =Modifier.padding(top =21.dp, start = 11.dp, end = 20.dp ),
                ratings = listOf(12, 5, 4, 2, 0)
            )

            Text(
                text = "${carPost.comments.size} Comments",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x1D, 0x1B, 0x20),
                modifier = Modifier.padding(start = 11.dp , top = 41.dp)

                )
            Spacer(modifier = Modifier.height(30.dp))
            Column(modifier = Modifier.padding(start = 2.dp,end = 10.dp)) {
                if (showMore)carPost.comments.subList(0,2).forEach { it ->
                    CommentCard(
                        profilePic = it.profilePic,
                        title = it.title,
                        date = it.date,
                        review = it.review
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
                else carPost.comments.forEach { it ->
                    CommentCard(
                        profilePic = it.profilePic,
                        title = it.title,
                        date = it.date,
                        review = it.review
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

            ClickableText(
                text = showText,
                onClick = { showMore = (!showMore)},
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )











        }
    }
}

@Composable
fun ClickableText(
    text: String,
    onClick: () -> Unit,
    modifier : Modifier = Modifier) {
    Text(
        text = text,
        textDecoration = TextDecoration.Underline,
        fontSize = 11.sp,
        modifier = modifier.clickable(onClick = onClick),
        color = Color.Black
    )
}




@Composable
@Preview
fun CarDetailsScreenPreview(){
    CarDetailsScreen(Data.carPostsList[0])
}















