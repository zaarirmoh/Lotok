package com.example.lotok.ui.screens.bookingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lotok.model.CarPost
import com.example.lotok.model.Data
import com.example.lotok.ui.components.carPost.Rating
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.carDetailsScreen.CarPictures
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

            TextField(
                modifier = Modifier.padding(16.dp),
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

            WilayasDropdownMenu(Modifier.padding(16.dp))
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    modifier: Modifier = Modifier,
    labelText : String ,
    labelTextWarning: String,
    singleLine : Boolean = true,
    placeHolderText : String,
    imageVector: ImageVector,
    keyboardOptions : KeyboardOptions,
    condition : (String) -> Boolean

){
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = if (!isValid) Color.Red else Color(0xFF7D848D)

    )
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            isValid = condition(it)
                        },
        label = {
            Text(
                text = if (isValid)labelText else labelTextWarning,
                color = if (isValid)Color(0xFF7D848D) else Color.Red
                )

                },
        placeholder = {
            Text(
                text = placeHolderText,
                color = if (isValid)Color(0xFF7D848D) else Color.Red
            )
                      },

        trailingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        singleLine = singleLine,

        colors = textFieldColors,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    )
}

@Composable
fun WilayasDropdownMenu(modifier: Modifier) {
    val wilayas = listOf("Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Algiers", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arréridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipasa", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane")
    var selectedWilaya by remember { mutableStateOf(wilayas[0]) }

    Box(modifier = modifier) {
        var expanded by remember { mutableStateOf(false) }
        val surfaceColor = MaterialTheme.colorScheme.primary

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        ) {
            OutlinedTextField(
                value = selectedWilaya,
                onValueChange = { selectedWilaya = it },
                label = { Text("Wilaya") },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "Dropdown Icon",
                tint = if (expanded) MaterialTheme.colorScheme.primary else surfaceColor,
                modifier = Modifier.clickable { expanded = true }
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            wilayas.forEach { wilaya ->
                DropdownMenuItem(onClick = {
                    selectedWilaya = wilaya
                    expanded = false
                } , text = {Text(text = wilaya)})
                    //Text(text = wilaya)

            }
        }
    }
}






@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(carPost = Data.carPostsList[0])
}