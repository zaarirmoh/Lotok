package com.example.lotok.ui.screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.profileInformation

@Composable
fun ProfilePictureAndName(
    modifier: Modifier = Modifier
){
    Column {
        Image(
            painter = painterResource(id = profileInformation.picture),
            contentDescription = null
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = profileInformation.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(
            text = profileInformation.email,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    }
}