package com.example.lotok.ui.components.carPost

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReviewCard(
    title: String,
    rating: Float,
    date: String,
    review: String,
) {
    Box {

        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(8.dp),

            ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title, fontWeight = FontWeight.Bold)
                    Text(text = date, fontSize = 12.sp, color = Color.Gray)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) { index ->
                        if (index < rating.toInt()) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Star Icon",
                                tint = Color.Red
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.StarBorder,
                                contentDescription = "Star Icon",
                                tint = Color.Red
                            )
                        }
                    }


                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = review)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReviewCard() {
    ReviewCard(
        title = "El Bench",
        rating = 4f,
        date = "June 5, 2019",
        review = "good. but I prefer Atos.",
        
    )
}
