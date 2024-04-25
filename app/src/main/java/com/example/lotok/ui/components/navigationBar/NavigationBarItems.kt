package com.example.lotok.ui.components.navigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ControlPoint
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ControlPoint
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import com.example.lotok.ui.navigation.LotokScreen

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        route = LotokScreen.HomeScreen.name
    ),
    BottomNavigationItem(
        title = "Shop",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.SelectACarScreen.name
    ),
    BottomNavigationItem(
        title = "Add",
        selectedIcon = Icons.Filled.ControlPoint,
        unselectedIcon = Icons.Outlined.ControlPoint,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.SelectACarScreen.name
    ),
    BottomNavigationItem(
        title = "Chat",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.SelectACarScreen.name
    ),
    BottomNavigationItem(
        title = "Chat",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.SelectACarScreen.name
    )
)