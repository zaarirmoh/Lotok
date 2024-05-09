package com.example.lotok.ui.screens.bookingScreen

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.lotok.ui.components.lines.SimpleLine
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.carDetailsScreen.CarPictures
import com.example.lotok.ui.screens.carDetailsScreen.ClickableText
import com.example.lotok.ui.screens.carDetailsScreen.NameAndPrice


@SuppressLint("StateFlowValueCalledInComposition", "UnrememberedMutableState")
@Composable
fun BookingScreen(
    bookingSharedViewModel: BookingSharedViewModel,
    carPost : CarPost,
    onGoBackIconClicked: () -> Unit = {},
    bookNowButtonClicked : () -> Unit = {}
) {
    var firstName by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.firstName)
    }

    var lastName by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.lastName)
    }

    var phoneNumber by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.phoneNumber)
    }

    var licenceNumber by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.licenceNumber)
    }

    var fromDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.fromDate)
    }

    var toDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.toDate)
    }

    var expirationDate by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.expirationDate)
    }

    var paymentMethod by remember {
        mutableStateOf(bookingSharedViewModel.uiState.value.paymentMethod)
    }

    val rentedDays = DateDifference(firstDate = fromDate, secondDate = toDate)

    val totalPrice = rentedDays * carPost.dayPrice


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
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 30.dp)
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp),
                value = firstName,
                onValueChange = {it -> firstName = it} ,


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
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
                value = lastName,
                onValueChange = {it -> lastName = it},
                labelText ="Last name",
                labelTextWarning ="Please enter your last name" ,
                placeHolderText = "",
                imageVector = Icons.Default.Person,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()},

            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp, top = 8.dp),
                value = phoneNumber,
                onValueChange = {it -> phoneNumber = it},
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
                },


            )

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            Text(
                text = "Driving Licence Inforamations :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 25.dp)
            )

            ImagePickerTextField(
                modifier= Modifier
                    .padding(start = 24.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
            )

            Text(
                text = "Expiration Date :",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 24.dp, top = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(
                    date = expirationDate,
                    onDateChanged = {it -> expirationDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(alignment = Alignment.Bottom))
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .padding(start = 8.dp),
                    value = licenceNumber,
                    onValueChange = {it -> licenceNumber = it},
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

            SimpleLine(
                height = 10,
                startX = 119,
                endX = 256,
                modifier = Modifier.padding(top=25.dp)
            )

            Text(
                text = "Booking informations :",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, top = 25.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "From :",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "  To :",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 24.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DatePickerButton(
                    date = fromDate,
                    onDateChanged = {it -> fromDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )

                DatePickerButton(
                    date = toDate,
                    onDateChanged = {it -> toDate = it},
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .align(alignment = Alignment.Bottom)
                )
            }
            ClickableText(
                text = "Check availability here ? " ,
                onClick = {  },
                modifier = Modifier.padding(start = 34.dp )
            )

            Text(
                text = "Payment Method :",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 30.dp, top = 20.dp)
            )
            PaymentOptions(paymentMethod = {it -> paymentMethod = it})
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total Price :")
                Text(text = "${totalPrice} DZA")
            }


            Button(
                onClick = bookNowButtonClicked ,
                colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#B3261E"))),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = "Book now",
                    fontSize = 18.sp ,
                    color = Color.White   ,
                    fontWeight = FontWeight.Bold,
                    modifier= Modifier.align(alignment = Alignment.CenterVertically)
                )
            }

            bookingSharedViewModel.updateFirstName(firstName)
            bookingSharedViewModel.updateLastName(lastName)
            bookingSharedViewModel.updatePhoneNumber(phoneNumber)
            bookingSharedViewModel.updateLicenceNumber(licenceNumber)
            bookingSharedViewModel.updateFromDate(fromDate)
            bookingSharedViewModel.updateToDate(toDate)
            bookingSharedViewModel.updateExpirationDate(expirationDate)
            bookingSharedViewModel.updatePaymentMethod(paymentMethod)
            bookingSharedViewModel.updateTotalPrice(totalPrice.toDouble())



        }
    }
}




val bookingSharedViewModel = BookingSharedViewModel()
@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(carPost = Data.carPostsList[0],bookingSharedViewModel = bookingSharedViewModel)
}