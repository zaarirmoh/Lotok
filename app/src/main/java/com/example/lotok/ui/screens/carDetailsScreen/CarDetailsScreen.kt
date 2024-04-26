package com.example.lotok.ui.screens.carDetailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.CarPost
import com.example.lotok.data.Data
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
                name = carPost.name,
                mark = carPost.mark,
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
                energyType = carPost.energyType,
                seats = carPost.seats,
                engine = carPost.engine,
                type = carPost.type,
                location = carPost.location
            )

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            RatingBar(
                modifier =Modifier.padding(top =21.dp, start = 11.dp , end = 30.dp),
                ratings = listOf(12, 5, 4, 2, 0)
            )







        }
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit,modifier : Modifier = Modifier) {
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















