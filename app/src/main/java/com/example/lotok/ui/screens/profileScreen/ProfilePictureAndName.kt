package com.example.lotok.ui.screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.profileInformation

@Composable
fun ProfilePictureAndName(
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = profileInformation.picture),
            contentDescription = null,
            modifier = modifier
                .size(96.dp)
                .clip(CircleShape)
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