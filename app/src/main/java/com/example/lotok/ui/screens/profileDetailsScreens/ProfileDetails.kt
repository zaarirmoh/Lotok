package com.example.lotok.ui.screens.profileDetailsScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HighlightOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.lotok.ui.screens.profileScreen.ProfilePictureAndName
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lotok.data.profileInformation

@Composable
fun ProfileDetails(
    modifier: Modifier = Modifier
){
    ProfilePictureAndName()
    Spacer(modifier = modifier.height(25.dp))
    ProfileInformationCards()
}
@Composable
fun ProfileInformationCards(
    modifier: Modifier = Modifier
){
  Column {
      ProfileInformationCard(
          profileDetailTitle = "First name",
          profileDetail = profileInformation.firstName
      )
      Spacer(modifier = modifier.height(16.dp))
      ProfileInformationCard(
          profileDetailTitle = "Last name",
          profileDetail = profileInformation.lastName
      )
      Spacer(modifier = modifier.height(16.dp))
      ProfileInformationCard(
          profileDetailTitle = "Email",
          profileDetail = profileInformation.email
      )
      Spacer(modifier = modifier.height(16.dp))
      ProfileInformationCard(
          profileDetailTitle = "Location",
          profileDetail = profileInformation.location
      )
      Spacer(modifier = modifier.height(16.dp))
      ProfileInformationCard(
          profileDetailTitle = "Mobile number",
          profileDetail = profileInformation.mobileNumber
      )
  }
}
@Composable
fun ProfileInformationCard(
    modifier: Modifier = Modifier,
    profileDetail: String?,
    profileDetailTitle: String
){
    Column {
        Text(
            text = profileDetailTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 25.dp)
        )
        Spacer(modifier = modifier.height(12.dp))
        InformationCard(profileDetail = profileDetail)
    }
}
@Composable
fun InformationCard(
    modifier: Modifier = Modifier,
    profileDetail: String?
){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F9)),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 25.dp, end = 25.dp)
    ) {
        Spacer(modifier = modifier.height(18.dp))
        if (profileDetail != null) {
            Text(
                text = profileDetail,
                fontSize = 16.sp,
                modifier = modifier.padding(start = 16.dp)
            )
        }
    }
}
@Composable
fun ProfileInformationTextFieldCards(
    modifier: Modifier = Modifier
){
    val newFirstName = remember { mutableStateOf(profileInformation.firstName) }
    val newLastName = remember{ mutableStateOf(profileInformation.lastName) }
    val newEmail = remember { mutableStateOf(profileInformation.email) }
    val newLocation = remember { mutableStateOf(profileInformation.location) }
    val newMobileNumber = remember { mutableStateOf(profileInformation.mobileNumber) }
    profileInformation.firstName = newFirstName.value
    profileInformation.lastName = newLastName.value
    profileInformation.email = newEmail.value
    profileInformation.location = newLocation.value
    profileInformation.mobileNumber = newMobileNumber.value
    Column {
        ProfileInformationTextFieldCard(
            profileDetailTitle = "First name",
            profileDetail = newFirstName,
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Last name",
            profileDetail = newLastName
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Email",
            profileDetail = newEmail
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Location",
            profileDetail = newLocation
        )
        Spacer(modifier = modifier.height(16.dp))
        ProfileInformationTextFieldCard(
            profileDetailTitle = "Mobile number",
            profileDetail = newMobileNumber
        )
    }
}
@Composable
fun ProfileInformationTextFieldCard(
    modifier: Modifier = Modifier,
    profileDetailTitle: String,
    profileDetail: MutableState<String>
){
    Column {
        Text(
            text = profileDetailTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(start = 25.dp)
        )
        Spacer(modifier = modifier.height(12.dp))
        InformationTextFieldCard(textFieldValue = profileDetail)
    }
}

@Composable
fun InformationTextFieldCard(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    suffix: @Composable () -> Unit = {}
){
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = {textFieldValue.value = it},
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.HighlightOff,
                contentDescription = null
            )
        },
        suffix = suffix,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)
    )
}
