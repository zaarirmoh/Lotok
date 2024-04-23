package com.example.lotok.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.R

@Composable
fun PopularCars(
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = stringResource(id = R.string.PopularCars),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = modifier.padding(start = 21.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(8.dp)
        ) {

        }
    }
}
@Composable
fun CarPost(
    modifier: Modifier = Modifier,
    carPostPhoto: Int
){
    Card {
        
    }
}