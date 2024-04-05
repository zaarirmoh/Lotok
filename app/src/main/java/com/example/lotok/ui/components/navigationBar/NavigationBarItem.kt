package com.example.lotok.ui.components.navigationBar

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
    val onClick: () -> Unit = {}
)
