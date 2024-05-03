package com.example.lotok.ui.screens.bookingScreen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.example.lotok.model.CarPost
import com.example.lotok.model.Data
import com.example.lotok.ui.components.carPost.Rating
import com.example.lotok.ui.components.topBar.EndIconProfile
import com.example.lotok.ui.components.topBar.StartIconGoBack
import com.example.lotok.ui.components.topBar.TopBar
import com.example.lotok.ui.components.topBar.TopBarCenterText
import com.example.lotok.ui.screens.carDetailsScreen.CarPictures
import com.example.lotok.ui.screens.carDetailsScreen.NameAndPrice
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects


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
                modifier = Modifier.padding(16.dp),
                labelText ="Last name",
                labelTextWarning ="Please enter your last name" ,
                placeHolderText = "",
                imageVector = Icons.Default.Person,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                condition = {it.isNotEmpty()}
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

            ImagePickerTextField(modifier= Modifier.padding(16.dp))

            TextField(
                modifier = Modifier.padding(16.dp),
                labelText ="Driving licence number",
                labelTextWarning ="Please enter your driving licence number" ,
                placeHolderText = "",
                imageVector = Icons.Default.CreditCard,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Phone
                ),
                condition = {it.isNotEmpty()}
            )

            /*WilayasDropdownMenu(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))*/






        }
    }
}



@Composable
fun ImagePickerTextField(modifier: Modifier) {

    val context = LocalContext.current
    val file = context.createImageFile()

    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )



    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    var selectedImageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }


    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()){
            capturedImageUri = uri
            selectedImageUris = selectedImageUris.toMutableList().apply { add(capturedImageUri) }
        }


    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        if (it)
        {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        }
        else
        {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    var isDialogOpen by remember { mutableStateOf(false) }


    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris -> selectedImageUris = uris }
    )





    Card(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(modifier = Modifier.fillMaxSize(),horizontalArrangement = Arrangement.SpaceBetween) {
            if (selectedImageUris.isEmpty()) {
                Text(
                    text = "    Driving licence Pictures",
                    color = Color.Gray,
                    modifier =Modifier.align(
                        androidx.compose.ui.Alignment.CenterVertically
                    )

                )

            }
            else  {
            Row(modifier = Modifier.weight(1f)) {
                selectedImageUris.forEach  { uri ->
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(4.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            } }

            IconButton(onClick = { isDialogOpen = true }, modifier = Modifier) {
                Icon(Icons.Default.Upload, contentDescription = null)
            }

        }
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { isDialogOpen = false },
            title = { Text("Choose an image") },
            text = {
                Column {
                    TextButton(onClick = {
                        val permissionCheckResult =
                            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED)
                        {
                            cameraLauncher.launch(uri)
                            capturedImageUri = uri
                            selectedImageUris.toMutableList().add(capturedImageUri)

                        }
                        else
                        {
                            permissionLauncher.launch(Manifest.permission.CAMERA)
                        }
                        isDialogOpen = false
                    }) {
                        Text("Take a photo")
                    }
                    TextButton(onClick = {
                        multiplePhotoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                        isDialogOpen = false
                    }) {
                        Text("Choose from gallery")
                    }
                }
            },
            confirmButton = { },
            dismissButton = { }
        )
    }


}



fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
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

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WilayasDropdownMenu( modifier : Modifier = Modifier) {
    var mExpanded by remember { mutableStateOf(false) }
    val wilayas = listOf(
        "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa",
        "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa",
        "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel",
        "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma",
        "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla",
        "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès",
        "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras",
        "Tipaza", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa",
        "Relizane"
    )

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(modifier = modifier) {

        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Wilaya")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            wilayas.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                },text = {Text(text = label)})
            }
        }
    }
}*/








    @Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(carPost = Data.carPostsList[0])
}