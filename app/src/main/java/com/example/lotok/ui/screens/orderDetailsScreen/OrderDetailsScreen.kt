package com.example.lotok.ui.screens.orderDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.model.CarPost
import com.example.lotok.model.OrderDetails

@Composable
fun OrderDetailsScreen(
    carPost: CarPost,
    uiState : OrderDetails,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        CardDetails(
            title =
            "Car Details",
            texts = listOf(
                { Text(text = "Make:") },
                { Text(text = carPost.make )},
                { Text(text = "Model:") },
                { Text(text = carPost.model) },
                { Text(text = "Car Number:") },
                { Text(text = carPost.dayPrice.toString())},
                { Text(text = "Location:") },
                { Text(text = carPost.location) }
            )

        )

        Spacer(modifier = Modifier.height(4.dp))

        CardDetails(
            title = "Client Details",
            texts = listOf(
                { Text("First Name:") },
                { Text(uiState.firstName) },
                { Text("Last Name:") },
                { Text(uiState.lastName) },
                { Text("Phone Number:") },
                { Text(uiState.phoneNumber) },
                { Text("Licence Number:") },
                { Text(uiState.licenceNumber) },
                { Text("Expiration Date:") },
                { Text(uiState.expirationDate) },
                { Text("Rented ") },
                { Text("From : ${uiState.fromDate}") },
                { Text("") },
                { Text("To :     ${uiState.toDate}") }
            )
        )
        Spacer(modifier = Modifier.height(4.dp))

        CardDetails(
            title = "Payment :",
            texts = listOf(
                { Text("Total Price :") },
                { Text(uiState.totalPrice.toString()) },
                { Text("Payment method :") },
                { Text(uiState.paymentMethod) }
            )
        )


    }


}

@Composable
fun CardDetails(modifier: Modifier = Modifier, title : String, texts : List<@Composable () -> Unit> ){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            for (i in texts.indices step 2) {
                val firstItem = texts[i]
                val secondItem = texts[i + 1]

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    firstItem()
                    secondItem()
                }
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    }
}


