package com.example.lotok.ui.screens.profileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.profileInformation

@Composable
fun ProfileStatistics(
    modifier: Modifier = Modifier
){
    Row {
        Spacer(modifier = modifier.width(46.dp))
        OneProfileStatistic(
            statisticType = "Cars posted",
            statistic = profileInformation.carsPosted
        )
        Spacer(modifier = modifier.width(34.dp))
        OneProfileStatistic(
            statisticType = "Posts saved",
            statistic = profileInformation.postsSaved
        )
        Spacer(modifier = modifier.width(34.dp))
        OneProfileStatistic(
            statisticType = "Bookings",
            statistic = profileInformation.bookings
        )
    }
}
@Composable
fun OneProfileStatistic(
    modifier: Modifier = Modifier,
    statisticType: String,
    statistic: Int
){
    Column {
        Text(
            text = statisticType,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = statistic.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}