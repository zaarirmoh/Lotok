package com.example.lotok.ui.screens.bookingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.model.CarPost
import com.example.lotok.model.Data
import com.example.lotok.ui.components.carPost.Rating
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.carDetailsScreen.CarPictures
import com.example.lotok.ui.screens.carDetailsScreen.ClickableText
import com.example.lotok.ui.screens.carDetailsScreen.NameAndPrice


@Composable
fun BookingScreen(
    carPost : CarPost,
    onGoBackIconClicked: () -> Unit = {},
    bookNowButtonClicked : () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBar(
                startIcon = { StartIconGoBack(onButtonClicked = onGoBackIconClicked) },
                topBarCenter = { TopBarCenterText(text = "Booking") },
                endIcon = { EndIconProfile() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.fillMaxWidth()){
                CarPictures(
                    imgSrc = carPost.imgSrc,
                    modifier = Modifier.fillMaxWidth(),
                    buttonEnabled = false,
                )
                Rating(stars = carPost.rating)
            }
            NameAndPrice(
                modifier = Modifier.padding(start = 11.dp , end = 11.dp ),
                name = carPost.model,
                mark = carPost.make,
                dayPrice = carPost.dayPrice,
                weekPrice = carPost.weekPrice
            )

            Text(
                text = "Client Informations :",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                labelText ="First name",
                labelTextWarning ="Please enter your first name" ,
                placeHolderText = "",
                imageVector = Icons.Default.AccountBox,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()}
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                labelText ="Last name",
                labelTextWarning ="Please enter your last name" ,
                placeHolderText = "",
                imageVector = Icons.Default.Person,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()}
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                labelText = "Phone number",
                labelTextWarning = "Please enter a valid phone number",
                placeHolderText = "",
                imageVector = Icons.Default.Phone,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                ),
                condition = {it ->
                    ( it.length) == 10 && (it.substring(0,2) == "05" || it.substring(0,2) == "06" || it.substring(0,2) == "07")
                            && it.toIntOrNull() != null
                }
            )

            Text(
                text = "Driving Licence Inforamations :",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            ImagePickerTextField(modifier= Modifier.padding(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .align(alignment = Alignment.Bottom))
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(start = 8.dp),
                    labelText = "number",
                    labelTextWarning = "Please enter your licence number",
                    placeHolderText = "",
                    imageVector = Icons.Default.CreditCard,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Phone
                    ),
                    condition = { it.isNotEmpty() }
                )
            }

            Text(
                text = "Booking informations :",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )

                DatePickerButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )
            }
            ClickableText(
                text = "Check availability here ? " ,
                onClick = {  },
                modifier = Modifier.padding(start = 22.dp )
            )

            Text(
                text = "Payment Method :",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 22.dp, top = 20.dp)
            )
            PaymentOptions()
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
                modifier =Modifier.fillMaxSize().padding(16.dp)
            ) {
                Text(
                    text = "Book",
                    fontSize = 18.sp ,
                    color = androidx.compose.ui.graphics.Color.White   ,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier.align(alignment = Alignment.CenterVertically)
                )
            }



        }
    }
}



    @Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(carPost = Data.carPostsList[0])
}