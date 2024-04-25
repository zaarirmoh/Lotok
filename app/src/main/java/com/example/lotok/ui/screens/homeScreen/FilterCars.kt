package com.example.lotok.ui.screens.homeScreen

import android.health.connect.datatypes.units.Energy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.R
import com.example.lotok.ui.theme.md_theme_light_onPrimary
import java.time.Year

@Composable
fun FilterCars(
    modifier: Modifier = Modifier
){
    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            State()
            FromTo()
        }
        Row {
            Year()
            Energy()
        }
    }
}

@Composable
fun State(
    modifier: Modifier = Modifier
){
    Box {
        Button(
            onClick = {  },

        ) {
            Text(
                text = ,
                fontSize = ,
                fontWeight = ,
            )
        }
        Icon(
            imageVector = ,
            contentDescription = null,
            tint = ,
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start =)

        )
    }
}

@Composable
fun FromTo(
    modifier: Modifier = Modifier
){
    Box {
        Button(
            onClick = {  },

            ) {
            Text(
                text = ,
                fontSize = ,
                fontWeight = ,
            )
        }
        Icon(
            imageVector = ,
            contentDescription = null,
            tint = ,
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start =)

        )
    }
}

@Composable
fun Year(
    modifier: Modifier = Modifier
){
    Box {
        Button(
            onClick = {  },

            ) {
            Text(
                text = ,
                fontSize = ,
                fontWeight = ,
            )
        }
        Icon(
            imageVector = ,
            contentDescription = null,
            tint = ,
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start =)

        )
    }
}

@Composable
fun Energy(
    modifier: Modifier = Modifier
){
    Box {
        Button(
            onClick = {  },

            ) {
            Text(
                text = ,
                fontSize = ,
                fontWeight = ,
            )
        }
        Icon(
            imageVector = ,
            contentDescription = null,
            tint = ,
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start =)

        )
    }
}